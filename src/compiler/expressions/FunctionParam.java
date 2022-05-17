package compiler.expressions;

import compiler.other.DataTypeEnum;
import compiler.other.INode;

public class FunctionParam extends INode {
    public final String name;
    public final DataTypeEnum dataType;

    public FunctionParam(String name, DataTypeEnum dataType) {
        super();
        this.name = name;
        this.dataType = dataType;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s, type: %s)", FunctionParam.class.getSimpleName(), name, dataType);
    }
}