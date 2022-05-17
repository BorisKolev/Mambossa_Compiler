package compiler.expressions;

import compiler.other.INode;

public class FunctionCallParam extends INode {
    public INode expression;

    public FunctionCallParam(INode expression) {
        super();
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return FunctionCallParam.class.getSimpleName();
    }
}