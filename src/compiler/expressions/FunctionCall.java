package compiler.expressions;

import compiler.other.INode;
import java.util.List;

public class FunctionCall extends INode {
    public String name;
    public List<FunctionCallParam> parametersList;

    public FunctionCall(String name, List<FunctionCallParam> params) {
        super();
        this.name = name;
        parametersList = params;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s)", FunctionCall.class.getSimpleName(), name);
    }
}