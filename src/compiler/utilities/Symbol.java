package compiler.utilities;

import compiler.other.Scope;
import compiler.other.DataTypeEnum;

public class Symbol {
    public final Object value;
    public final String name;
    public final DataTypeEnum dataType;
    public Scope scope;

    public Symbol(String name, DataTypeEnum dataType) {
        super();
        this.name = name;
        this.dataType = dataType;
        value = null;
    }

    public Symbol(String name, DataTypeEnum dataType, Object value) {
        super();
        this.name = name;
        this.dataType = dataType;
        this.value = value;
    }
}