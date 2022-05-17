package compiler.other;

import compiler.expressions.*;

public abstract class Binder<T> {
    public abstract T bind(Program node, BinderTypeEnum type);
    public abstract T bind(BinaryExpression node, BinderTypeEnum type);
    public abstract T bind(Assignment node, BinderTypeEnum type);
    public abstract T bind(Negative node, BinderTypeEnum type);
    public abstract T bind(Function node, BinderTypeEnum type);
    public abstract T bind(Value node, BinderTypeEnum type);
    public abstract T bind(Variable node, BinderTypeEnum type);
    public abstract T bind(Declaration node, BinderTypeEnum type);
    public abstract T bind(IfStatement node, BinderTypeEnum type);
    public abstract T bind(ElseStatement node, BinderTypeEnum type);
    public abstract T bind(ElseIfStatement node, BinderTypeEnum type);
    public abstract T bind(BooleanExpression node, BinderTypeEnum type);
    public abstract T bind(WhileStatement node, BinderTypeEnum type);
    public abstract T bind(FunctionParam node, BinderTypeEnum type);
    public abstract T bind(FunctionReturnStatement node, BinderTypeEnum type);
    public abstract T bind(FunctionCall node, BinderTypeEnum type);
    public abstract T bind(FunctionCallParam node, BinderTypeEnum type);
    public abstract T bind(Parentheses node, BinderTypeEnum type);

    public T bind(INode node, BinderTypeEnum type) {
        if (node instanceof Program) {
            return this.bind((Program)node, type);
        }

        if (node instanceof BinaryExpression) {
            return this.bind((BinaryExpression)node, type);
        }

        if (node instanceof Assignment) {
            return this.bind((Assignment)node, type);
        }

        if (node instanceof Negative) {
            return this.bind((Negative)node, type);
        }

        if (node instanceof Function) {
            return this.bind((Function)node, type);
        }

        if (node instanceof Value) {
            return this.bind((Value)node, type);
        }

        if (node instanceof Variable) {
            return this.bind((Variable)node, type);
        }

        if (node instanceof Declaration) {
            return this.bind((Declaration)node, type);
        }

        if (node instanceof IfStatement) {
            return this.bind((IfStatement)node, type);
        }

        if (node instanceof ElseStatement) {
            return this.bind((ElseStatement)node, type);
        }

        if (node instanceof ElseIfStatement) {
            return this.bind((ElseIfStatement)node, type);
        }

        if (node instanceof BooleanExpression) {
            return this.bind((BooleanExpression)node, type);
        }

        if (node instanceof WhileStatement) {
            return this.bind((WhileStatement)node, type);
        }

        if (node instanceof FunctionParam) {
            return this.bind((FunctionParam)node, type);
        }

        if (node instanceof FunctionReturnStatement) {
            return this.bind((FunctionReturnStatement)node, type);
        }

        if (node instanceof FunctionCall) {
            return this.bind((FunctionCall)node, type);
        }

        if (node instanceof FunctionCallParam) {
            return this.bind((FunctionCallParam)node, type);
        }

        if (node instanceof Parentheses) {
            return this.bind((Parentheses)node, type);
        }

        return null;
    }
}