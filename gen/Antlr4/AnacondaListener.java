// Generated from C:/Users/a3rog/BorisTest/src/antlr4\Anaconda.g4 by ANTLR 4.9.2
package antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnacondaParser}.
 */
public interface AnacondaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#compile}.
	 * @param ctx the parse tree
	 */
	void enterCompile(AnacondaParser.CompileContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#compile}.
	 * @param ctx the parse tree
	 */
	void exitCompile(AnacondaParser.CompileContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(AnacondaParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(AnacondaParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AnacondaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AnacondaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(AnacondaParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(AnacondaParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#functionReturn}.
	 * @param ctx the parse tree
	 */
	void enterFunctionReturn(AnacondaParser.FunctionReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#functionReturn}.
	 * @param ctx the parse tree
	 */
	void exitFunctionReturn(AnacondaParser.FunctionReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#functionParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParam(AnacondaParser.FunctionParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#functionParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParam(AnacondaParser.FunctionParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(AnacondaParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(AnacondaParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(AnacondaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(AnacondaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(AnacondaParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(AnacondaParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(AnacondaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(AnacondaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(AnacondaParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(AnacondaParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(AnacondaParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(AnacondaParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(AnacondaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(AnacondaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(AnacondaParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(AnacondaParser.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(AnacondaParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(AnacondaParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(AnacondaParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(AnacondaParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(AnacondaParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(AnacondaParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(AnacondaParser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(AnacondaParser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(AnacondaParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(AnacondaParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(AnacondaParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link AnacondaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(AnacondaParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnacondaParser#functionCallParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallParam(AnacondaParser.FunctionCallParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnacondaParser#functionCallParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallParam(AnacondaParser.FunctionCallParamContext ctx);
}