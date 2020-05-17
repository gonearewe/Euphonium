package parser

open class Block : ASTNode {
    val sequences: List<ASTNode> = ArrayList<ASTNode>()

}

class WhileBlock : Block() {

}