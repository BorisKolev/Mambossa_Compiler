package compiler.expressions;

import compiler.other.AssignmentEnum;
import compiler.other.INode;

public class Assignment extends INode {
    public final INode leftNode, rightNode;
    public final AssignmentEnum operation;

    public Assignment(INode left, INode right, AssignmentEnum operation) {
        super();
        leftNode = left;
        rightNode = right;
        this.operation = operation;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(operation:%s)", Assignment.class.getSimpleName(), operation.toString());
    }
}