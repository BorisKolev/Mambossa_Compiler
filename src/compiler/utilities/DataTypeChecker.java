package compiler.utilities;

import compiler.ast.ASTVisitor;
import compiler.expressions.*;
import compiler.other.DataTypeEnum;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataTypeChecker extends ASTVisitor<Boolean> {
    private final DataTypeEnum dataType;
    private final SymbolTable symbolTable;

    public DataTypeChecker(DataTypeEnum dataType, SymbolTable table) {
        this.dataType = dataType;
        symbolTable = table;
    }

    @Override
    public Boolean visit(Program node) {
        return node.children.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(BinaryExpression node) {
        return this.visit(node.leftNode) && this.visit(node.rightNode);
    }

    @Override
    public Boolean visit(Assignment node) {
        return this.visit(node.leftNode) && this.visit(node.rightNode);
    }

    @Override
    public Boolean visit(Negative node) {
        return this.visit(node.node);
    }

    @Override
    public Boolean visit(Function node) {
        return node.dataType == dataType && node.bodyNoteList.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(Value node) {
        try {
            switch (dataType) {
                case Integer -> Integer.parseInt(node.value.toString());
                case Float -> Float.parseFloat(node.value.toString());
                case Bool -> {
                    Pattern p = Pattern.compile(String.format("(%s|%s)", KeyWords.TRUE, KeyWords.FALSE));
                    Matcher m = p.matcher(node.value.toString());
                    return m.find();
                }
            }
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean visit(Variable node) {
        Symbol symbol = symbolTable.get(node.value);
        return symbol.dataType == dataType;
    }

    @Override
    public Boolean visit(Declaration node) {
        return true;
    }

    @Override
    public Boolean visit(IfStatement node) {
        return node.bodyNodeList.stream().allMatch(c -> this.visit(c)) && this.visit(node.childNode);
    }

    @Override
    public Boolean visit(ElseStatement node) {
        return node.bodyNodeList.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(ElseIfStatement node) {
        return node.bodyNodeList.stream().allMatch(c -> this.visit(c)) && this.visit(node.childNode);
    }

    @Override
    public Boolean visit(BooleanExpression node) {
        if (dataType == DataTypeEnum.Bool) {
            return true;
        }
        return this.visit(node.leftNode) && this.visit(node.rightNode);
    }

    @Override
    public Boolean visit(WhileStatement node) {
        return node.bodyNodeList.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(FunctionParam node) {
        return true;
    }

    @Override
    public Boolean visit(FunctionReturnStatement node) {
        return this.visit(node.expression);
    }

    @Override
    public Boolean visit(FunctionCall node) {
        Symbol symbol = symbolTable.get(new FunctionNameDefinition(node, symbolTable).toString());
        if (symbol != null) {
            return symbol.dataType == dataType;
        }
        return false;
    }

    @Override
    public Boolean visit(FunctionCallParam node) {
        return this.visit(node.expression);
    }

    @Override
    public Boolean visit(Parentheses node) {
        return this.visit(node.innerExpression);
    }
}