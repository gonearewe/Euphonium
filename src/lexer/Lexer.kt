package lexer

import java.util.regex.Pattern

class Lexer private constructor(val source: String) {
    private val tokens = ArrayList<Token>()

    private val matchers = arrayListOf(
            Pattern.compile("^\\d*").matcher(source),
            Pattern.compile("^(let|val|var|const|if|else|return|struct|for|when)").matcher(source),
            Pattern.compile("^([(){}\\[\\]])").matcher(source)
    )

    fun tokenize(source: String): Lexer {
        val lexer = Lexer(source)
        var start = 0
        while (start != source.length) {

        }
    }
}