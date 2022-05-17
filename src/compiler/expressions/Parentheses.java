package compiler.expressions;

import compiler.other.INode;

public class Parentheses extends INode {
    public INode innerExpression;

    public Parentheses(INode innerExpression) {
        super();
        this.innerExpression = innerExpression;
    }

    @Override
    public String getDisplayName() {
        return Parentheses.class.getSimpleName();
    }
}