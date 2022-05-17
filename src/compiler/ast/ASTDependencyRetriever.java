package compiler.ast;

import compiler.expressions.*;
import compiler.other.INode;
import java.util.ArrayList;
import java.util.Optional;

public class ASTDependencyRetriever extends ASTVisitor<ArrayList<INode>> {
    private final ArrayList<INode> dependencies;
    private final ArrayList<Function> functions;
    private final ArrayList<Declaration> variables;

    public ASTDependencyRetriever(ArrayList<Function> functions,
                                  ArrayList<Declaration> variables) {
        dependencies = new ArrayList<>();
        this.functions = functions;
        this.variables = variables;
    }

    @Override
    public ArrayList<INode> visit(Program node) {
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(BinaryExpression node) {
        this.visit(node.leftNode);
        this.visit(node.rightNode);
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(Assignment node) {
        this.visit(node.leftNode);
        this.visit(node.rightNode);
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(Negative node) {
        this.visit(node.node);
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(Function node) {
        dependencies.add(node);
        for (INode child : node.bodyNoteList) {
            this.visit(child);
        }
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(Value node) {
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(Variable node) {
        Optional<Declaration> dependency = variables.stream().filter
                (v -> v.name.equals(node.value)).findFirst();
        dependency.ifPresent(dependencies::add);
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(Declaration node) {
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(IfStatement node) {
        this.visit(node.expression);
        for (INode child : node.bodyNodeList) {
            this.visit(child);
        }
        if (node.childNode != null) {
            this.visit(node.childNode);
        }
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(ElseStatement node) {
        for (INode child : node.bodyNodeList) {
            this.visit(child);
        }
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(ElseIfStatement node) {
        this.visit(node.expression);
        for (INode child : node.bodyNodeList) {
            this.visit(child);
        }
        if (node.childNode != null) {
            this.visit(node.childNode);
        }
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(BooleanExpression node) {
        this.visit(node.leftNode);
        this.visit(node.rightNode);
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(WhileStatement node) {
        this.visit(node.expression);
        for (INode child : node.bodyNodeList) {
            this.visit(child);
        }
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(FunctionParam node) {
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(FunctionReturnStatement node) {
        this.visit(node.expression);
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(FunctionCall node) {
        Optional<Function> dependency = functions.stream().filter
                (f -> f.name.equals(node.name)).findFirst();
        dependency.ifPresent(dependencies::add);
        for(INode param: node.parametersList) {
            this.visit(param);
        }
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(FunctionCallParam node) {
        this.visit(node.expression);
        return dependencies;
    }

    @Override
    public ArrayList<INode> visit(Parentheses node) {
        this.visit(node.innerExpression);
        return dependencies;
    }
}