package compiler.utilities;

import compiler.other.DataTypeEnum;
import java.util.Objects;

public class KeyWords {
    public static final String INTEGER = "int";
    public static final String FLOAT = "float";
    public static final String BOOL = "bool";
    public static final String VOID = "void";
    public static final String TRUE = "True";
    public static final String FALSE = "False";

    public static DataTypeEnum getType(String input) {
        if (input.equals(INTEGER)) {
            return DataTypeEnum.Integer;
        }

        if (input.equals(FLOAT)) {
            return DataTypeEnum.Float;
        }

        if (input.equals(BOOL)) {
            return DataTypeEnum.Bool;
        }

        if (input.equals(VOID)) {
            return DataTypeEnum.Void;
        }

        return null;
    }

    public static boolean check(String input) {
        if (Objects.equals(input, INTEGER) || Objects.equals(input, FLOAT) || Objects.equals(input, BOOL) ||
                Objects.equals(input, VOID) || Objects.equals(input, TRUE) || Objects.equals(input, FALSE)) {
            return true;
        } else {
            return false;
        }
    }
}