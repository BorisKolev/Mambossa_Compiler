package compiler.utilities;

import compiler.ast.ASTVisitor;
import compiler.expressions.*;
import compiler.other.INode;

public class PythonVisitor extends ASTVisitor<String> {
    private int numberIndent;
    private Boolean hasFirstLine = false;

    public PythonVisitor() {
        numberIndent = 0;
    }

    private void addLine(StringBuilder output, INode node) {
        if (node instanceof Declaration) {
            return;
        }
        if (hasFirstLine) {
            output.append("\r\n");
        } else {
            hasFirstLine = true;
        }
    }

    private void addIndent(StringBuilder output) {
        output.append("\t".repeat(Math.max(0, numberIndent)));
    }

    @Override
    public String visit(Program node) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < node.children.size(); i++) {
            INode child = node.children.get(i);
            this.addLine(output, child);
            String temp = this.visit(child);
            output.append(temp);
        }
        return output.toString();
    }

    @Override
    public String visit(BinaryExpression node) {
        StringBuilder output = new StringBuilder();
        output.append(this.visit(node.leftNode));
        switch (node.operation) {
            case Add -> output.append(" + ");
            case Sub -> output.append(" - ");
            case Multi -> output.append(" * ");
            case Div -> output.append(" / ");
            case Pow -> output.append(" ^ ");
            case Mod -> output.append(" % ");
            default -> {
            }
        }
        output.append(this.visit(node.rightNode));
        return output.toString();
    }

    @Override
    public String visit(Assignment node) {
        StringBuilder output = new StringBuilder();
        output.append(this.visit(node.leftNode));
        switch (node.operation) {
            case Assign -> output.append(" = ");
            case AssignAddition -> output.append(" += ");
            case AssignSubtraction -> output.append(" -= ");
            case AssignMultiplication -> output.append(" *= ");
            case AssignDivision -> output.append(" /= ");
            case AssignPower -> output.append(" ^= ");
            case AssignModulo -> output.append(" %= ");
            default -> {
            }
        }
        output.append(this.visit(node.rightNode));
        return output.toString();
    }

    @Override
    public String visit(Negative node) {
        StringBuilder output = new StringBuilder();
        output.append("-");
        output.append(this.visit(node.node));
        return output.toString();
    }

    @Override
    public String visit(Value node) {
        return node.value.toString();
    }

    @Override
    public String visit(Variable node) {
        return node.value;
    }

    @Override
    public String visit(Declaration node) {
        // Python doesn't require declaration, so we can skip any that appear.
        return "";
    }

    @Override
    public String visit(IfStatement node) {
        StringBuilder output = new StringBuilder();
        output.append("if ");
        output.append(this.visit(node.expression));
        output.append(":");
        numberIndent++;
        for (INode child : node.bodyNodeList) {
            if(child instanceof Declaration) {
                continue;
            }
            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }
        numberIndent--;
        if (node.childNode != null) {
            addLine(output, node.childNode);
            addIndent(output);
            output.append(this.visit(node.childNode));
        }
        return output.toString();
    }

    @Override
    public String visit(ElseStatement node) {
        StringBuilder output = new StringBuilder();
        output.append("else:");
        numberIndent++;
        for (INode child : node.bodyNodeList) {
            if(child instanceof Declaration) {
                continue;
            }
            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }
        numberIndent--;
        return output.toString();
    }

    @Override
    public String visit(ElseIfStatement node) {
        StringBuilder output = new StringBuilder();
        output.append("elif ");
        output.append(this.visit(node.expression));
        output.append(":");
        numberIndent++;
        for (INode child : node.bodyNodeList) {
            if(child instanceof Declaration) {
                continue;
            }
            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }
        numberIndent--;
        if (node.childNode != null) {
            addLine(output, node.childNode);
            addIndent(output);
            output.append(this.visit(node.childNode));
        }
        return output.toString();
    }

    @Override
    public String visit(BooleanExpression node) {
        StringBuilder output = new StringBuilder();
        output.append(this.visit(node.leftNode));
        switch (node.operation) {
            case Equal -> output.append(" == ");
            case NegativeEqual -> output.append(" != ");
            case GreaterThan -> output.append(" > ");
            case LessThan -> output.append(" < ");
            case GreaterThanEqual -> output.append(" >= ");
            case LessThanEqual -> output.append(" <= ");
            case Or -> output.append(" or ");
            case And -> output.append(" and ");
        }
        output.append(this.visit(node.rightNode));
        return output.toString();
    }

    @Override
    public String visit(WhileStatement node) {
        StringBuilder output = new StringBuilder();
        output.append("while ");
        output.append(this.visit(node.expression));
        output.append(":");
        numberIndent++;
        for (INode child : node.bodyNodeList) {
            if(child instanceof Declaration) {
                continue;
            }
            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }
        numberIndent--;
        return output.toString();
    }

    @Override
    public String visit(Function node) {
        StringBuilder output = new StringBuilder();
        output.append("def ");
        output.append(node.name);
        output.append("(");
        for (int i = 0; i < node.parametersList.size(); i++) {
            if (i > 0) {
                output.append(", ");
            }
            output.append(this.visit(node.parametersList.get(i)));
        }
        output.append(")");
        output.append(":");
        numberIndent++;
        for (INode child : node.bodyNoteList) {
            if(child instanceof Declaration) {
                continue;
            }
            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }
        numberIndent--;
        return output.toString();
    }

    @Override
    public String visit(FunctionParam node) {
        return node.name;
    }

    @Override
    public String visit(FunctionReturnStatement node) {
        StringBuilder output = new StringBuilder();
        output.append("return ");
        output.append(this.visit(node.expression));
        return output.toString();
    }

    @Override
    public String visit(FunctionCall node) {
        StringBuilder output = new StringBuilder();
        output.append(node.name);
        output.append("(");
        for (int i = 0; i < node.parametersList.size(); i++) {
            if (i > 0) {
                output.append(", ");
            }
            output.append(this.visit(node.parametersList.get(i)));
        }
        output.append(")");
        return output.toString();
    }

    @Override
    public String visit(FunctionCallParam node) {
        return this.visit(node.expression);
    }

    @Override
    public String visit(Parentheses node) {
        StringBuilder output = new StringBuilder();
        output.append("(");
        output.append(this.visit(node.innerExpression));
        output.append(")");
        return output.toString();
    }
}