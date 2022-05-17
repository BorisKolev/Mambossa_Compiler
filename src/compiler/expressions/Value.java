package compiler.expressions;

import compiler.other.INode;

public class Value extends INode {
    public final Object value;

    public Value(Object value) {
        super();
        this.value = value;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(value: %s)", Value.class.getSimpleName(), value);
    }
}