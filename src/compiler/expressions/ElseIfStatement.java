package compiler.expressions;

import compiler.other.INode;
import java.util.List;

public class ElseIfStatement extends INode {
    public final List<INode> bodyNodeList;
    public final INode expression, childNode;

    public ElseIfStatement(List<INode> body, INode expression, INode child) {
        super();
        bodyNodeList = body;
        this.expression = expression;
        childNode = child;
    }

    @Override
    public String getDisplayName() {
        return ElseIfStatement.class.getSimpleName();
    }
}