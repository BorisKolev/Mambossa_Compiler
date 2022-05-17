package compiler.expressions;

import compiler.other.INode;

public class Negative extends INode {
    public final INode node;

    public Negative(INode innerNode) {
        super();
        node = innerNode;
    }

    @Override
    public String getDisplayName() {
        return Negative.class.getSimpleName();
    }
}