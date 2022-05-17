package compiler.expressions;

import compiler.other.INode;

public class FunctionReturnStatement extends INode {
    public Function parent;
    public INode expression;

    public FunctionReturnStatement(INode expression) {
        super();
        parent = null;
        this.expression = expression;
    }

    public FunctionReturnStatement(INode expression, Function parent) {
        super();
        this.expression = expression;
        this.parent = parent;
    }
    

    @Override
    public String getDisplayName() {
        return FunctionReturnStatement.class.getSimpleName();
    }
}