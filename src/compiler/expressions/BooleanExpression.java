package compiler.expressions;

import compiler.other.BooleanEnum;
import compiler.other.INode;

public class BooleanExpression extends INode {
    public final INode leftNode, rightNode;
    public final BooleanEnum operation;

    public BooleanExpression(INode left, INode right, BooleanEnum operation) {
        super();
        leftNode = left;
        rightNode = right;
        this.operation = operation;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(operation: %s)", BooleanExpression.class.getSimpleName(), operation);
    }
}