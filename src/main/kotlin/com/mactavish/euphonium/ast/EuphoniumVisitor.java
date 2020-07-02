// Generated from E:/MyProjects/Euphonium/src/main/kotlin/com/mactavish/euphonium/grammar\Euphonium.g4 by ANTLR 4.8
package com.mactavish.euphonium.ast;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EuphoniumParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface EuphoniumVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EuphoniumParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(EuphoniumParser.ExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link EuphoniumParser#exprStatement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(EuphoniumParser.ExprStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link EuphoniumParser#vardecl}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecl(EuphoniumParser.VardeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link EuphoniumParser#typedecl}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedecl(EuphoniumParser.TypedeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link EuphoniumParser#fundecl}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFundecl(EuphoniumParser.FundeclContext ctx);
}
