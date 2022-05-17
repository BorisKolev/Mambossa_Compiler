package compiler.utilities;

import compiler.ast.ASTDependencyRetriever;
import compiler.expressions.*;
import compiler.other.Binder;
import compiler.other.BinderTypeEnum;
import compiler.other.INode;
import java.util.ArrayList;

public class DependencyGraphBinder extends Binder<DependencyGraph> {
    private final DependencyGraph dependGraph;
    private final ArrayList<Function> functionArray;
    private final ArrayList<Declaration> variableArray;

    public DependencyGraphBinder() {
        dependGraph = new DependencyGraph();
        functionArray = new ArrayList<>();
        variableArray = new ArrayList<>();
    }

    private ArrayList<INode> getDependencies(INode tree) {
        return new ASTDependencyRetriever(functionArray, variableArray).visit(tree);
    }

    @Override
    public DependencyGraph bind(Program node, BinderTypeEnum type) {
        int childrenLength = node.children.size();
        for (int i = 0; i < childrenLength; i++) {
            INode child = node.children.get(i);
            this.bind(child, type);
            if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
                dependGraph.addDependency(node, child);
                if ((i + 1) < childrenLength) {
                    INode nextChild = node.children.get(i + 1);
                    if (child instanceof Function || nextChild instanceof Function) {
                        continue;
                    }
                    dependGraph.addDependency(nextChild, child);
                }
            }
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(BinaryExpression node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.bind(node.leftNode, type);
            this.bind(node.rightNode, type);
            dependGraph.addDependency(node, node.leftNode);
            dependGraph.addDependency(node, node.rightNode);
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(Assignment node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.bind(node.leftNode, type);
            this.bind(node.rightNode, type);
            dependGraph.addDependency(node, node.leftNode);
            dependGraph.addDependency(node, node.rightNode);
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(Negative node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.bind(node.node, type);
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(Function node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Declaration || type == BinderTypeEnum.All) {
            functionArray.add(node);
        }
        for (INode child: node.bodyNoteList) {
            this.bind(child, type);
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(Value node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            for (INode dependency : this.getDependencies(node)) {
                dependGraph.addDependency(node, dependency);
            }
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(Variable node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            for (INode dependency : this.getDependencies(node)) {
                dependGraph.addDependency(node, dependency);
            }
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(Declaration node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Declaration || type == BinderTypeEnum.All) {
            variableArray.add(node);
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(IfStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.bind(node.expression, type);
            dependGraph.addDependency(node, node.expression);
        }
        int childrenLength = node.bodyNodeList.size();
        for (int i = 0; i < childrenLength; i++) {
            INode child = node.bodyNodeList.get(i);
            this.bind(child, type);
            if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
                dependGraph.addDependency(node, child);
                if ((i + 1) < childrenLength) {
                    INode nextChild = node.bodyNodeList.get(i + 1);
                    if (child instanceof Function || nextChild instanceof Function) {
                        continue;
                    }
                    dependGraph.addDependency(nextChild, child);
                }
            }
        }
        if (node.childNode != null) {
            this.bind(node.childNode, type);
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(ElseStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            int childrenLength = node.bodyNodeList.size();
            for (int i = 0; i < childrenLength; i++) {
                INode child = node.bodyNodeList.get(i);
                this.bind(child, type);
                dependGraph.addDependency(node, child);
                if ((i + 1) < childrenLength) {
                    INode nextChild = node.bodyNodeList.get(i + 1);
                    if (child instanceof Function || nextChild instanceof Function) {
                        continue;
                    }
                    dependGraph.addDependency(nextChild, child);
                }
            }
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(ElseIfStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.bind(node.expression, type);
            dependGraph.addDependency(node, node.expression);
        }
        int childrenLength = node.bodyNodeList.size();
        for (int i = 0; i < childrenLength; i++) {
            INode child = node.bodyNodeList.get(i);
            this.bind(child, type);
            if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
                dependGraph.addDependency(node, child);
                if ((i + 1) < childrenLength) {
                    INode nextChild = node.bodyNodeList.get(i + 1);
                    if (child instanceof Function || nextChild instanceof Function) {
                        continue;
                    }
                    dependGraph.addDependency(nextChild, child);
                }
            }
        }
        if (node.childNode != null) {
            this.bind(node.childNode, type);
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(BooleanExpression node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.bind(node.leftNode, type);
            this.bind(node.rightNode, type);
            dependGraph.addDependency(node, node.leftNode);
            dependGraph.addDependency(node, node.rightNode);
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(WhileStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.bind(node.expression, type);
            dependGraph.addDependency(node, node.expression);
        }
        int childrenLength = node.bodyNodeList.size();
        for (int i = 0; i < childrenLength; i++) {
            INode child = node.bodyNodeList.get(i);
            this.bind(child, type);
            if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
                dependGraph.addDependency(node, child);
                if ((i + 1) < childrenLength) {
                    INode nextChild = node.bodyNodeList.get(i + 1);
                    if (child instanceof Function || nextChild instanceof Function) {
                        continue;
                    }
                    dependGraph.addDependency(nextChild, child);
                }
            }
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(FunctionParam node, BinderTypeEnum type) {
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(FunctionReturnStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.bind(node.expression, type);
            dependGraph.addDependency(node, node.expression);
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(FunctionCall node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            for (INode dependency : this.getDependencies(node)) {
                dependGraph.addDependency(node, dependency);
            }
            for (INode param : node.parametersList) {
                this.bind(param, type);
            }
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(FunctionCallParam node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            for (INode dependency : this.getDependencies(node)) {
                dependGraph.addDependency(node, dependency);
            }
        }
        return dependGraph;
    }

    @Override
    public DependencyGraph bind(Parentheses node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.bind(node.innerExpression, type);
            dependGraph.addDependency(node, node.innerExpression);
        }
        return dependGraph;
    }
}