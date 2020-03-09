package lexer

import java.util.regex.Matcher
import java.util.regex.Pattern

class Lexer private constructor(private val source: String) {
    private val tokens = ArrayList<Token>()
    private var position = -1
    val hasNext
        get() = position + 1 != tokens.size

    private val matchers = arrayListOf(
            Pair<Matcher, String>(Pattern
                    .compile("\\d+")
                    .matcher(source), "number"),

            Pair<Matcher, String>(Pattern
                    .compile("(let|val|var|const|if|else|return|struct|for|when|while|main|fun)")
                    .matcher(source), "keyword"),

            Pair<Matcher, String>(Pattern
                    .compile("[(){}\\[\\],;]")
                    .matcher(source), "separator"),

            Pair<Matcher, String>(Pattern
                    .compile("(==|=>|=|\\+\\+|\\+|--|->|-|\\*|/|%|!=|!|>=|<=|>|<|\\|\\||&&)")
                    .matcher(source), "operator"),

            Pair<Matcher, String>(Pattern
                    .compile("[a-zA-Z]\\w*")
                    .matcher(source), "identifier")
    )

    companion object {
        fun tokenize(source: String): Lexer {
            val lexer = Lexer(source)
            var start = 0
            while (start != source.length) {
                if (source[start].isWhitespace()) {
                    start++
                    continue
                }
//            val f=lexer.matchers[4].first.find(7)
                for ((matcher, type) in lexer.matchers) {
                    if (matcher.find(start)) {
                        if (matcher.start() != start) {
                            continue
                        }
                        val end = matcher.end()
                        lexer.tokens.add(Token(source.substring(start, end), type))
                        start = end
                        break
                    }
                }
            }

            return lexer
        }
    }

    fun nextToken(): Token {
        position++
        return tokens[position]
    }

    fun lookAhead(step: Int = 1): Token? {
        if (!exist(position + step)) {
            return null
        }

        return tokens[position + step]
    }

    private fun exist(position: Int) = position < tokens.size

    override fun toString(): String {
        return buildString(tokens.size) {
            tokens.map {
                append("(")
                append(it.type)
                append(", ")
                append(it.value)
                append(")\n")
            }
        }
    }
}


fun main() {
    val l = Lexer.tokenize("""
        |let a; 
        |a=7;
        |var b =a ;
        |if(a == b){
        |   let fn = fun(x ,y ){
        |       var x=10;
        |       while(x>=0){
        |           print(x);
        |           x--;
        |       }
        |       
        |       return x;
        |   }
        |}
    """.trimMargin())
    while (l.hasNext) {
        println(l.nextToken())
    }
}