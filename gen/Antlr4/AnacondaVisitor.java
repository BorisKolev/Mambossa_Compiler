// Generated from C:/Users/a3rog/BorisTest/src/antlr4\Anaconda.g4 by ANTLR 4.9.2
package antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnacondaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnacondaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#compile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompile(AnacondaParser.CompileContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(AnacondaParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AnacondaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(AnacondaParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#functionReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturn(AnacondaParser.FunctionReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#functionParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParam(AnacondaParser.FunctionParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(AnacondaParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(AnacondaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#ifElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(AnacondaParser.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(AnacondaParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#elseIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStatement(AnacondaParser.ElseIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(AnacondaParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(AnacondaParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixExpr(AnacondaParser.InfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(AnacondaParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(AnacondaParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(AnacondaParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(AnacondaParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(AnacondaParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(AnacondaParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnacondaParser#functionCallParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallParam(AnacondaParser.FunctionCallParamContext ctx);
}