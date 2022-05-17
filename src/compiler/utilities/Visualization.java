package compiler.utilities;

import compiler.ast.ASTVisitor;
import compiler.expressions.*;
import compiler.other.INode;

public class Visualization extends ASTVisitor<String> {
    private static final String spaceString = "|  ";
    private Integer depth;

    public Visualization() {
        depth = 0;
    }

    private void newLine(StringBuilder output) {
        output.append("\r\n");
    }

    public String buildIndentation() {
        return "\033[0;97m   " +
                spaceString.repeat(Math.max(0, depth));
    }

    @Override
    public String visit(Program node) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        for (INode child : node.children) {
            sb.append(this.visit(child));
        }
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(BinaryExpression node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.leftNode));
        sb.append(this.visit(node.rightNode));
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(Assignment node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.leftNode));
        sb.append(this.visit(node.rightNode));
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(Negative node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.node));
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(Function node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        for (INode param : node.parametersList) {
            sb.append(this.visit(param));
        }
        for (INode child : node.bodyNoteList) {
            sb.append(this.visit(child));
        }
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(Value node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        return sb.toString();
    }

    @Override
    public String visit(Variable node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        return sb.toString();
    }

    @Override
    public String visit(Declaration node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        return sb.toString();
    }

    @Override
    public String visit(IfStatement node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.expression));
        for (INode child : node.bodyNodeList) {
            sb.append(this.visit(child));
        }
        if (node.childNode != null) {
            sb.append(this.visit(node.childNode));
        }
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(ElseStatement node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        for (INode child : node.bodyNodeList) {
            sb.append(this.visit(child));
        }
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(ElseIfStatement node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.expression));
        for (INode child : node.bodyNodeList) {
            sb.append(this.visit(child));
        }
        if (node.childNode != null) {
            sb.append(this.visit(node.childNode));
        }
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(BooleanExpression node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.leftNode));
        sb.append(this.visit(node.rightNode));
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(WhileStatement node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.expression));
        for (INode child : node.bodyNodeList) {
            sb.append(this.visit(child));
        }
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(FunctionParam node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        return sb.toString();
    }

    @Override
    public String visit(FunctionReturnStatement node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.expression));
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(FunctionCall node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        for (INode param : node.parametersList) {
            sb.append(this.visit(param));
        }
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(FunctionCallParam node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.expression));
        depth--;
        return sb.toString();
    }

    @Override
    public String visit(Parentheses node) {
        StringBuilder sb = new StringBuilder();
        this.newLine(sb);
        sb.append(this.buildIndentation());
        sb.append("|->");
        sb.append(node.getDisplayName());
        depth++;
        sb.append(this.visit(node.innerExpression));
        depth--;
        return sb.toString();
    }
}