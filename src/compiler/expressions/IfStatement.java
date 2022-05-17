package compiler.expressions;

import compiler.other.INode;
import java.util.List;

public class IfStatement extends INode {
    public final List<INode> bodyNodeList;
    public final INode expression, childNode;

    public IfStatement(List<INode> body, INode expression, INode child) {
        super();
        bodyNodeList = body;
        this.expression = expression;
        childNode = child;
    }

    @Override
    public String getDisplayName() {
        return IfStatement.class.getSimpleName();
    }
}