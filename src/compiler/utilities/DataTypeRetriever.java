package compiler.utilities;

import compiler.ast.ASTVisitor;
import compiler.expressions.*;
import compiler.other.DataTypeEnum;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataTypeRetriever extends ASTVisitor<DataTypeEnum> {
    private final SymbolTable symbolTable;

    public DataTypeRetriever(SymbolTable table) {
        symbolTable = table;
    }

    private boolean parseInt(String value) {
        try {  
            Integer.parseInt(value);  
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
         }  
    }

    private boolean parseFloat(String value) {
        if (!value.contains(".")) {
            return false;
        }
        try {  
            Float.parseFloat(value);
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
         }  
    }

    private boolean parseBool(String value) {
        Pattern p = Pattern.compile(String.format("(%s|%s)", KeyWords.TRUE, KeyWords.FALSE));
        Matcher m = p.matcher(value);
        return m.find();
    }

    @Override
    public DataTypeEnum visit(Program node) {
        return null;
    }

    @Override
    public DataTypeEnum visit(BinaryExpression node) {
        DataTypeEnum left = this.visit(node.leftNode);
        DataTypeEnum right = this.visit(node.rightNode);
        if (left == DataTypeEnum.Float || right ==  DataTypeEnum.Float) {
            return DataTypeEnum.Float;
        }
        return DataTypeEnum.Integer;
    }

    @Override
    public DataTypeEnum visit(Assignment node) {
        return null;
    }

    @Override
    public DataTypeEnum visit(Negative node) {
        return this.visit(node.node);
    }

    @Override
    public DataTypeEnum visit(Function node) {
        return node.dataType;
    }

    @Override
    public DataTypeEnum visit(Value node) {
        String value = node.value.toString();
        if (this.parseBool(value)) {
            return DataTypeEnum.Bool;
        }
        if (this.parseFloat(value)) {
            return DataTypeEnum.Float;
        }
        if (this.parseInt(value)) {
            return DataTypeEnum.Integer;
        }
        return null;
    }

    @Override
    public DataTypeEnum visit(Variable node) {
        Symbol temp = symbolTable.get(node.value);
        if (temp != null) {
            return temp.dataType;
        }
        return null;
    }

    @Override
    public DataTypeEnum visit(Declaration node) {
        return node.dataType;
    }

    @Override
    public DataTypeEnum visit(IfStatement node) {
        return null;
    }

    @Override
    public DataTypeEnum visit(ElseStatement node) {
        return null;
    }

    @Override
    public DataTypeEnum visit(ElseIfStatement node) {
        return null;
    }

    @Override
    public DataTypeEnum visit(BooleanExpression node) {
        return null;
    }

    @Override
    public DataTypeEnum visit(WhileStatement node) {
        return null;
    }

    @Override
    public DataTypeEnum visit(FunctionParam node) {
        return node.dataType;
    }

    @Override
    public DataTypeEnum visit(FunctionReturnStatement node) {
        return this.visit(node.expression);
    }

    @Override
    public DataTypeEnum visit(FunctionCall node) {
        Symbol temp = symbolTable.get(new FunctionNameDefinition(node, symbolTable).toString());
        if (temp != null) {
            return temp.dataType;
        }
        return null;
    }

    @Override
    public DataTypeEnum visit(FunctionCallParam node) {
        return this.visit(node.expression);
    }

    @Override
    public DataTypeEnum visit(Parentheses node) {
        return this.visit(node.innerExpression);
    }
}