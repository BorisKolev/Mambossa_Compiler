package compiler.ast;

import compiler.expressions.*;
import compiler.other.INode;

public abstract class ASTVisitor<T> {
    public abstract T visit(Program node);
    public abstract T visit(BinaryExpression node);
    public abstract T visit(Assignment node);
    public abstract T visit(Negative node);
    public abstract T visit(Function node);
    public abstract T visit(Value node);
    public abstract T visit(Variable node);
    public abstract T visit(Declaration node);
    public abstract T visit(IfStatement node);
    public abstract T visit(ElseStatement node);
    public abstract T visit(ElseIfStatement node);
    public abstract T visit(BooleanExpression node);
    public abstract T visit(WhileStatement node);
    public abstract T visit(FunctionParam node);
    public abstract T visit(FunctionReturnStatement node);
    public abstract T visit(FunctionCall node);
    public abstract T visit(FunctionCallParam node);
    public abstract T visit(Parentheses node);

    public T visit(INode node) {
        if (node instanceof Program) {
            return this.visit((Program)node);
        }

        if (node instanceof BinaryExpression) {
            return this.visit((BinaryExpression)node);
        }

        if (node instanceof Assignment) {
            return this.visit((Assignment)node);
        }

        if (node instanceof Negative) {
            return this.visit((Negative)node);
        }

        if (node instanceof Function) {
            return this.visit((Function)node);
        }

        if (node instanceof Value) {
            return this.visit((Value)node);
        }

        if (node instanceof Variable) {
            return this.visit((Variable)node);
        }

        if (node instanceof Declaration) {
            return this.visit((Declaration)node);
        }

        if (node instanceof IfStatement) {
            return this.visit((IfStatement)node);
        }

        if (node instanceof ElseStatement) {
            return this.visit((ElseStatement)node);
        }

        if (node instanceof ElseIfStatement) {
            return this.visit((ElseIfStatement)node);
        }

        if (node instanceof BooleanExpression) {
            return this.visit((BooleanExpression)node);
        }

        if (node instanceof WhileStatement) {
            return this.visit((WhileStatement)node);
        }

        if (node instanceof FunctionParam) {
            return this.visit((FunctionParam)node);
        }

        if (node instanceof FunctionReturnStatement) {
            return this.visit((FunctionReturnStatement)node);
        }

        if (node instanceof FunctionCall) {
            return this.visit((FunctionCall)node);
        }

        if (node instanceof FunctionCallParam) {
            return this.visit((FunctionCallParam)node);
        }

        if (node instanceof Parentheses) {
            return this.visit((Parentheses)node);
        }

        return null;
    }
}