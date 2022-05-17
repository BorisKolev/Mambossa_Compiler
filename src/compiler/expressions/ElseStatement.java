package compiler.expressions;

import compiler.other.INode;
import java.util.List;

public class ElseStatement extends INode {
    public final List<INode> bodyNodeList;

    public ElseStatement(List<INode> body) {
        super();
        bodyNodeList = body;
    }

    @Override
    public String getDisplayName() {
        return ElseStatement.class.getSimpleName();
    }
}