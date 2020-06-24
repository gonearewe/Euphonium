// Generated from E:/MyProjects/Euphonium/src/main/kotlin/com/mactavish/euphonium/grammar\Euphonium.g4 by ANTLR 4.8
package com.mactavish.euphonium.ast;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EuphoniumParser}.
 */
public interface EuphoniumListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link EuphoniumParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExpr(EuphoniumParser.ExprContext ctx);

    /**
     * Exit a parse tree produced by {@link EuphoniumParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExpr(EuphoniumParser.ExprContext ctx);

    /**
     * Enter a parse tree produced by {@link EuphoniumParser#exprStatement}.
     *
     * @param ctx the parse tree
     */
    void enterExprStatement(EuphoniumParser.ExprStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link EuphoniumParser#exprStatement}.
     *
     * @param ctx the parse tree
     */
    void exitExprStatement(EuphoniumParser.ExprStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link EuphoniumParser#vardecl}.
     *
     * @param ctx the parse tree
     */
    void enterVardecl(EuphoniumParser.VardeclContext ctx);

    /**
     * Exit a parse tree produced by {@link EuphoniumParser#vardecl}.
     *
     * @param ctx the parse tree
     */
    void exitVardecl(EuphoniumParser.VardeclContext ctx);

    /**
     * Enter a parse tree produced by {@link EuphoniumParser#typedecl}.
     *
     * @param ctx the parse tree
     */
    void enterTypedecl(EuphoniumParser.TypedeclContext ctx);

    /**
     * Exit a parse tree produced by {@link EuphoniumParser#typedecl}.
     *
     * @param ctx the parse tree
     */
    void exitTypedecl(EuphoniumParser.TypedeclContext ctx);

    /**
     * Enter a parse tree produced by {@link EuphoniumParser#fundecl}.
     *
     * @param ctx the parse tree
     */
    void enterFundecl(EuphoniumParser.FundeclContext ctx);

    /**
     * Exit a parse tree produced by {@link EuphoniumParser#fundecl}.
     *
     * @param ctx the parse tree
     */
    void exitFundecl(EuphoniumParser.FundeclContext ctx);
}
