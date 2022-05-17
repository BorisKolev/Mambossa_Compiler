package compiler.expressions;

import compiler.other.INode;
import java.util.List;

public class WhileStatement extends INode {
    public final List<INode> bodyNodeList;
    public final INode expression;

    public WhileStatement(List<INode> body, INode expression) {
        super();
        bodyNodeList = body;
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return WhileStatement.class.getSimpleName();
    }
}