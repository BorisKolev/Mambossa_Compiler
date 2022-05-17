package compiler.expressions;

import compiler.other.DataTypeEnum;
import compiler.other.INode;

public class Declaration extends INode {
    public final String name;
    public final DataTypeEnum dataType;

    public Declaration(String name, DataTypeEnum dataType) {
        super();
        this.name = name;
        this.dataType = dataType;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s, type: %s)", Declaration.class.getSimpleName(), name, dataType);
    }
}