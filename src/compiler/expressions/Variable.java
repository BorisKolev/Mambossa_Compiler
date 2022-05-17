package compiler.expressions;

import compiler.other.INode;

public class Variable extends INode {
    public final String value;

    public Variable(String value) {
        super();
        this.value = value;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(value: %s)", Variable.class.getSimpleName(), value);
    }
}