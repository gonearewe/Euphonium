package lexer

import java.util.regex.Matcher
import java.util.regex.Pattern

class Lexer private constructor(private val source: String) {
    private val tokens = ArrayList<Token>()

    private val matchers = arrayListOf(
            Pair<Matcher, String>(Pattern
                    .compile("^\\d+")
                    .matcher(source), "number"),

            Pair<Matcher, String>(Pattern
                    .compile("^(let|val|var|const|if|else|return|struct|for|when|true|false)")
                    .matcher(source), "keyword"),

            Pair<Matcher, String>(Pattern
                    .compile("^([(){}\\[\\]])")
                    .matcher(source), "separator"),

            Pair<Matcher, String>(Pattern
                    .compile("^(==|=>|=|\\+\\+|\\+|--|->|-|\\*|/|\\|#)")
                    .matcher(source), "operator"),

            Pair<Matcher, String>(Pattern
                    .compile("^(a-zA-Z)[\\w_]*")
                    .matcher(source), "separator"),
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

                for ((matcher, type) in lexer.matchers) {
                    if (matcher.find(start)) {
                        val end = matcher.end() + 1
                        lexer.tokens.add(Token(source.substring(start, end), type))
                        start = end
                        break
                    }
                }
            }

            return lexer
        }

    }

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
    println(Lexer.tokenize("let x=67; val y=x; when(x==y){ return true;}"))
}