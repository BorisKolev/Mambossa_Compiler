package compiler.ast;

import compiler.expressions.*;
import compiler.other.BinderTypeEnum;
import compiler.other.INode;
import compiler.other.INodeComparator;
import compiler.utilities.DependencyGraph;
import compiler.utilities.DependencyGraphBinder;
import compiler.utilities.Sorting;
import java.util.ArrayList;

public class ASTSorter extends ASTVisitor<INode> {
    private final INodeComparator nodeComparator;

    public ASTSorter(INode tree) {
        DependencyGraphBinder dependencyGraphBinder = new DependencyGraphBinder();
        // Allow the declarations of functions and variables to be handled
        dependencyGraphBinder.bind(tree, BinderTypeEnum.Declaration);
        // Build up the dependency graph
        DependencyGraph dependencyGraph = dependencyGraphBinder.bind(tree, BinderTypeEnum.Syntax);
        // Use a comparator through the service
        nodeComparator = new INodeComparator(dependencyGraph);
    }

    @Override
    public INode visit(Program node) {
        // Change the order of the nodes using a selection sort dependent on the graph
        ArrayList<INode> body = new ArrayList<>();
        for (INode child : Sorting.selectionSort(node.children, nodeComparator)) {
            body.add(this.visit(child));
        }
        return new Program(body);
    }

    @Override
    public INode visit(BinaryExpression node) {
        return node;
    }

    @Override
    public INode visit(Assignment node) {
        return node;
    }

    @Override
    public INode visit(Negative node) {
        return node;
    }

    @Override
    public INode visit(Function node) {
        // Change the order of the nodes using a selection sort dependent on the graph
        ArrayList<INode> body = new ArrayList<>();
        for (INode child : Sorting.selectionSort(node.bodyNoteList, nodeComparator)) {
            body.add(this.visit(child));
        }
        return new Function(node.dataType, node.name, body, node.parametersList);
    }

    @Override
    public INode visit(Value node) {
        return node;
    }

    @Override
    public INode visit(Variable node) {
        return node;
    }

    @Override
    public INode visit(Declaration node) {
        return node;
    }

    @Override
    public INode visit(IfStatement node) {
        // Change the order of the nodes using a selection sort dependent on the graph
        ArrayList<INode> body = new ArrayList<>();
        for (INode child : Sorting.selectionSort(node.bodyNodeList, nodeComparator)) {
            body.add(this.visit(child));
        }
        INode child = null;
        if (node.childNode != null) {
            child = this.visit(node.childNode);
        }
        return new IfStatement(body, node.expression, child);
    }

    @Override
    public INode visit(ElseStatement node) {
        // Change the order of the nodes using a selection sort dependent on the graph
        ArrayList<INode> body = new ArrayList<>();
        for (INode child : Sorting.selectionSort(node.bodyNodeList, nodeComparator)) {
            body.add(this.visit(child));
        }
        return new ElseStatement(body);
    }

    @Override
    public INode visit(ElseIfStatement node) {
        // Change the order of the nodes using a selection sort dependent on the graph
        ArrayList<INode> body = new ArrayList<>();
        for (INode child : Sorting.selectionSort(node.bodyNodeList, nodeComparator)) {
            body.add(this.visit(child));
        }
        INode child = null;
        if (node.childNode != null) {
            child = this.visit(node.childNode);
        }
        return new ElseIfStatement(body, node.expression, child);
    }

    @Override
    public INode visit(BooleanExpression node) {
        return node;
    }

    @Override
    public INode visit(WhileStatement node) {
        // Change the order of the nodes using a selection sort dependent on the graph
        ArrayList<INode> body = new ArrayList<>();
        for (INode child : Sorting.selectionSort(node.bodyNodeList, nodeComparator)) {
            body.add(this.visit(child));
        }
        return new WhileStatement(body, node.expression);
    }

    @Override
    public INode visit(FunctionParam node) {
        return node;
    }

    @Override
    public INode visit(FunctionReturnStatement node) {
        return node;
    }

    @Override
    public INode visit(FunctionCall node) {
        return node;
    }

    @Override
    public INode visit(FunctionCallParam node) {
        return node;
    }

    @Override
    public INode visit(Parentheses node) {
        return node;
    }
}