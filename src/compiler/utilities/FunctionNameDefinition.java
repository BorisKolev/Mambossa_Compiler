package compiler.utilities;

import compiler.expressions.FunctionCall;
import compiler.expressions.Function;
import compiler.other.DataTypeEnum;

public class FunctionNameDefinition {
    public final String name;
    public final DataTypeEnum[] parametersTypes;

    public FunctionNameDefinition(Function node) {
        this.name = node.name;
        parametersTypes = new DataTypeEnum[node.parametersList.size()];
        for (int i = 0; i < node.parametersList.size(); i++) {
            parametersTypes[i] = node.parametersList.get(i).dataType;
        }
    }

    public FunctionNameDefinition(FunctionCall node, SymbolTable table) {
        this.name = node.name;
        parametersTypes = new DataTypeEnum[node.parametersList.size()];
        DataTypeRetriever dataTypeRetriever = new DataTypeRetriever(table);
        for (int i = 0; i < node.parametersList.size(); i++) {
            parametersTypes[i] = dataTypeRetriever.visit(node.parametersList.get(i));
        }
    }

    public String getDataTypeParams() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.parametersTypes.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.parametersTypes[i]);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        for (DataTypeEnum param : this.parametersTypes) {
            sb.append("_");
            sb.append(param);
        }
        return sb.toString();
    }
}