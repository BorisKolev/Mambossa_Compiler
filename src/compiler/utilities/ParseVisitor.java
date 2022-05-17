package compiler.utilities;

import antlr4.gen.*;
import antlr4.gen.AnacondaParser.*;
import compiler.exceptions.Keyword;
import compiler.exceptions.UnsupportedDataType;
import compiler.exceptions.UnsupportedNode;
import compiler.expressions.*;
import compiler.other.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParseVisitor extends AnacondaBaseVisitor<INode> {
    public INode visitCompileUnit(CompileContext context) {
        return this.visitStatements(context.statements());
    }

    public INode visitStatements(StatementsContext context) {
        Program result = new Program();
        /* Loop through the statements the parser finds and if
        the statement is empty or null, skip it and if it
        is not null it is a new line. */
        for (StatementContext statement : context.statement()) {
            if (statement.toString() == null || Objects.equals(statement.toString(), "")) {
                continue;
            }
            INode node = this.visitStatement(statement);
            if (node != null) {
                result.children.add(node);
            }
        }
        return result;
    }

    @Override
    public INode visitStatement(StatementContext context) {
        FunctionContext functionStatement = context.function();
        if (functionStatement != null) {
            return this.visitFunction(functionStatement);
        }
        FunctionReturnContext functionReturnStatement = context.functionReturn();
        if (functionReturnStatement != null) {
            return this.visitFunctionReturn(functionReturnStatement);
        }
        DeclarationContext declaration = context.declaration();
        if (declaration != null) {
            return this.visitDeclaration(declaration);
        }
        AssignmentContext assignment = context.assignment();
        if (assignment != null) {
            return this.visitAssignment(assignment);
        }
        IfElseStatementContext ifElseStatement = context.ifElseStatement();
        if (ifElseStatement != null) {
            return this.visitIfElseStatement(ifElseStatement);
        }
        WhileStatementContext whileStatement = context.whileStatement();
        if (whileStatement != null) {
            return this.visitWhileStatement(whileStatement);
        }
        ExpressionContext expr = context.expression();
        if (expr != null) {
            return this.visitExpr(expr);
        }
        return null;
    }

    public INode visitExpr(ExpressionContext context) {
        if (context instanceof ParensExprContext) {
            return this.visitParensExpr((ParensExprContext) context);
        }
        if (context instanceof UnaryExprContext) {
            return this.visitUnaryExpr((UnaryExprContext) context);
        }
        if (context instanceof InfixExprContext) {
            return this.visitInfixExpr((InfixExprContext) context);
        }
        if (context instanceof ValueExprContext) {
            return this.visitValueExpr((ValueExprContext) context);
        }
        if (context instanceof NotExprContext) {
            return this.visitNotExpr((NotExprContext) context);
        }
        if (context instanceof BooleanExprContext) {
            return this.visitBooleanExpr((BooleanExprContext) context);
        }
        if (context instanceof FunctionCallExprContext) {
            return this.visitFunctionCallExpr((FunctionCallExprContext) context);
        }
        return null;
    }

    public INode visitIfElseStatement(IfElseStatementContext context) {
        IfStatement ifStatement = (IfStatement) this.visitIfStatement(context.ifStat);
        List<ElseIfStatement> elseIfStatements = context.elseIfStatement().stream()
                .map(x -> (ElseIfStatement) this.visitElseIfStatement(x)).collect(Collectors.toList());
        ElseStatement elseStatement = (ElseStatement) this.visitElseStatement(context.elseStatement());
        if (elseIfStatements.size() > 0) {
            for (int i = elseIfStatements.size() - 2; i >= 0; i--) {
                ElseIfStatement current = elseIfStatements.get(i);
                ElseIfStatement sibling = elseIfStatements.get(i + 1);
                if (i == elseIfStatements.size() - 2 && elseStatement != null) {
                    elseIfStatements.set(i + 1, new ElseIfStatement
                            (sibling.bodyNodeList, sibling.expression, elseStatement));
                }
                elseIfStatements.set(i, new ElseIfStatement
                        (current.bodyNodeList, current.expression, elseIfStatements.get(i + 1)));
            }
            if (elseIfStatements.size() == 1) {
                ElseIfStatement elseIfStatementNode = elseIfStatements.get(0);
                elseIfStatements.set(0, new ElseIfStatement
                        (elseIfStatementNode.bodyNodeList, elseIfStatementNode.expression, elseStatement));
            }
            return new IfStatement(ifStatement.bodyNodeList, ifStatement.expression, elseIfStatements.get(0));
        } else {
            if (elseStatement != null) {
                return new IfStatement(ifStatement.bodyNodeList, ifStatement.expression, elseStatement);
            }
        }
        return new IfStatement(ifStatement.bodyNodeList, ifStatement.expression, null);
    }

    public INode visitIfStatement(IfStatementContext context) {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);
            if (node != null)
                children.add(node);
        }
        return new IfStatement(children, this.visitExpr(context.expr), null);
    }

    public INode visitElseStatement(ElseStatementContext context) {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);
            if (node != null)
                children.add(node);
        }
        return new ElseStatement(children);
    }

    public INode visitElseIfStatement(ElseIfStatementContext context) {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);
            if (node != null)
                children.add(node);
        }
        return new ElseIfStatement(children, this.visitExpr(context.expr), null);
    }

    @Override
    public INode visitWhileStatement(WhileStatementContext context) {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);
            if (node != null)
                children.add(node);
        }
        return new WhileStatement(children, this.visitExpr(context.expr));
    }

    @Override
    public INode visitFunction(FunctionContext context) {
        String name = context.name.getText();
        /* Throw an error if the name of the variable matches one of the
        predefined keywords in the compiler. This occurs when a user has
        attempted to use an expression operator that is not supported. */
        if (KeyWords.check(name)) {
            throw new Keyword(String.format("You cannot use the keyword %s as an identifier", name));
        }
        // Throw if an unsupported data type is attempted.
        DataTypeEnum dataTypeEnum = KeyWords.getType(context.type.getText());
        if (dataTypeEnum == null) {
            throw new UnsupportedDataType(
                    String.format("The data type: %s is currently unsupported", context.type.getText()));
        }
        List<INode> body = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);
            if (node != null)
                body.add(node);
        }
        List<FunctionParam> params = new ArrayList<>();
        for (FunctionParamContext param : context.functionParam()) {
            FunctionParam node = (FunctionParam) this.visitFunctionParam(param);
            if (node != null)
                params.add(node);
        }
        return new Function(dataTypeEnum, name, body, params);
    }

    @Override
    public INode visitFunctionReturn(FunctionReturnContext context) {
        return new FunctionReturnStatement(this.visitExpr(context.expression()));
    }

    @Override
    public INode visitFunctionParam(FunctionParamContext context) {
        DeclarationContext declaration = context.declaration();
        String name = declaration.name.getText();
        /* Throw an error if the name of the variable matches one of the
        predefined keywords in the compiler. This occurs when a user has
        attempted to use an expression operator that is not supported. */
        if (KeyWords.check(name)) {
            throw new Keyword(String.format("You cannot use the keyword %s as an identifier", name));
        }
        // Throw if an unsupported data type is attempted
        DataTypeEnum dataTypeEnum = KeyWords.getType(declaration.type.getText());
        if (dataTypeEnum == null) {
            throw new UnsupportedDataType(
                    String.format("The data type: %s is currently unsupported", declaration.type.getText()));
        }
        return new FunctionParam(name, dataTypeEnum);
    }

    public INode visitBooleanExpr(BooleanExprContext context) {
        // Check which type of expression has been declared and return the appropriate value
        return switch (context.op.getType()) {
            case AnacondaLexer.Equals -> new BooleanExpression
                    (this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanEnum.Equal);
            case AnacondaLexer.NegativeEquals -> new BooleanExpression
                    (this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanEnum.NegativeEqual);
            case AnacondaLexer.GreaterThan -> new BooleanExpression
                    (this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanEnum.GreaterThan);
            case AnacondaLexer.LessThan -> new BooleanExpression
                    (this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanEnum.LessThan);
            case AnacondaLexer.GreaterThanEquals -> new BooleanExpression
                    (this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanEnum.GreaterThanEqual);
            case AnacondaLexer.LessThanEquals -> new BooleanExpression
                    (this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanEnum.LessThanEqual);
            case AnacondaLexer.Or -> new BooleanExpression
                    (this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanEnum.Or);
            case AnacondaLexer.And -> new BooleanExpression
                    (this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanEnum.And);
            default ->
                    /* The default case occurs when a user has attempted to use
                    an expression operator that is not supported. */
                    throw new UnsupportedNode("Node is unsupported");
        };
    }

    public INode visitDeclaration(DeclarationContext context) {
        String name = context.name.getText();
        /* Throw an error if the name of the variable matches one of the
        predefined keywords in the compiler. This occurs when a user has
        attempted to use an expression operator that is not supported. */
        if (KeyWords.check(name)) {
            throw new Keyword(String.format("You cannot use the keyword %s as an identifier", name));
        }
        // Throw if an unsupported data type is attempted
        DataTypeEnum dataTypeEnum = KeyWords.getType(context.type.getText());
        if (dataTypeEnum == null) {
            throw new UnsupportedDataType(
                    String.format("The data type: %s is currently unsupported", context.type.getText()));
        }
        return new Declaration(name, dataTypeEnum);
    }

    public INode visitValueExpr(ValueExprContext context) {
        return new Value(context.value.getText());
    }

    public INode visitParensExpr(ParensExprContext context) {
        return new Parentheses(this.visitExpr(context.expression()));
    }

    public INode visitInfixExpr(InfixExprContext context) {
        // Check which type of expression has been declared and return the appropriate value
        return switch (context.op.getType()) {
            case AnacondaLexer.Add -> new BinaryExpression(this.visitExpr(context.left),
                    this.visitExpr(context.right),
                    ArithmeticEnum.Add);
            case AnacondaLexer.Subtract -> new BinaryExpression(this.visitExpr(context.left),
                    this.visitExpr(context.right),
                    ArithmeticEnum.Sub);
            case AnacondaLexer.Multiply -> new BinaryExpression(this.visitExpr(context.left),
                    this.visitExpr(context.right),
                    ArithmeticEnum.Multi);
            case AnacondaLexer.Divide -> new BinaryExpression(this.visitExpr(context.left),
                    this.visitExpr(context.right),
                    ArithmeticEnum.Div);
            case AnacondaLexer.Power -> new BinaryExpression(this.visitExpr(context.left),
                    this.visitExpr(context.right),
                    ArithmeticEnum.Pow);
            case AnacondaLexer.Modulo -> new BinaryExpression(this.visitExpr(context.left),
                    this.visitExpr(context.right),
                    ArithmeticEnum.Mod);
            default ->
                    /* The default case occurs when a user has attempted to use
                    an expression operator that is not supported. */
                    throw new UnsupportedNode("Node is unsupported");
        };
    }

    public INode visitAssignment(AssignmentContext context) {
        // Remove all new line characters
        String name = context.variable.getText().replace("\r", "").replace("\n", "");
        return switch (context.op.getType()) {
            case AnacondaLexer.Assign -> new Assignment(new Variable(name),
                    this.visitExpr(context.right), AssignmentEnum.Assign);
            case AnacondaLexer.AssignPlus -> new Assignment(new Variable(name),
                    this.visitExpr(context.right), AssignmentEnum.AssignAddition);
            case AnacondaLexer.AssignMinus -> new Assignment(new Variable(name),
                    this.visitExpr(context.right), AssignmentEnum.AssignSubtraction);
            case AnacondaLexer.AsssignMultiply -> new Assignment(new Variable(name),
                    this.visitExpr(context.right), AssignmentEnum.AssignMultiplication);
            case AnacondaLexer.AsssignDivide -> new Assignment(new Variable(name),
                    this.visitExpr(context.right), AssignmentEnum.AssignDivision);
            case AnacondaLexer.AsssignPower -> new Assignment(new Variable(name),
                    this.visitExpr(context.right), AssignmentEnum.AssignPower);
            default ->
                    /* The default case occurs when a user has attempted to use
                    an expression operator that is not supported. */
                    throw new UnsupportedNode("Node is unsupported");
        };
    }

    public INode visitUnaryExpr(UnaryExprContext context) {
        // Check which type of expression has been declared and return the appropriate value
        return switch (context.op.getType()) {
            case AnacondaLexer.Add -> this.visitExpr(context.expression());
            case AnacondaLexer.Subtract -> new Negative(this.visitExpr(context.expression()));
            default -> throw new UnsupportedNode("Node is unsupported");
        };
    }

    @Override
    public INode visitFunctionCallParam(FunctionCallParamContext context) {
        return new FunctionCallParam(this.visit(context.expression()));
    }

    @Override
    public INode visitFunctionCallExpr(FunctionCallExprContext context) {
        ArrayList<FunctionCallParam> params = new ArrayList<>();
        for (FunctionCallParamContext param : context.functionCallParam()) {
            params.add((FunctionCallParam)this.visitFunctionCallParam(param));
        }
        return new FunctionCall(context.name.getText(), params);
    }
}