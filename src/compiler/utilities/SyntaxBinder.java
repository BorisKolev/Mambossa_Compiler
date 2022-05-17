package compiler.utilities;

import compiler.exceptions.*;
import compiler.expressions.*;
import compiler.other.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxBinder extends Binder<INode> {
    private final Stack<SymbolTable> symbolTableStack = new Stack<>();

    private SymbolTable symbolTable() {
        return symbolTableStack.peek();
    }

    @Override
    public INode bind(Program node, BinderTypeEnum type) {
        symbolTableStack.add(new SymbolTable(ScopeTypeEnum.Program));
        return node;
    }

    @Override
    public INode bind(BinaryExpression node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            return new BinaryExpression(this.bind(node.leftNode, type),
                    this.bind(node.rightNode, type), node.operation);
        }
        return node;
    }

    @Override
    public INode bind(Assignment node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            INode left = this.bind(node.leftNode, type);
            INode right = this.bind(node.rightNode, type);
            if (left instanceof Variable) {
                Symbol temp = this.symbolTable().get(((Variable) left).value);
                if (temp != null) {
                    if (temp.dataType == DataTypeEnum.Bool) {
                        if (!(right instanceof BooleanExpression) && !new DataTypeChecker(temp.dataType,
                                this.symbolTable()).visit(right)) {
                            throw new IncorrectDataType(String.format("\"%s\" was expecting data type of %s",
                                    temp.name, temp.dataType));
                        }
                    } else if (!new DataTypeChecker(temp.dataType, this.symbolTable()).visit(right)) {
                        throw new IncorrectDataType(
                                String.format("\"%s\" was expecting data type of %s",
                                        temp.name, temp.dataType));

                    }
                } else {
                    throw new UndefinedVariable(String.format(
                            "Variable \"%s\" has not been defined in the current scope",
                            ((Variable) left).value));
                }
            }
            return new Assignment(left, right, node.operation);
        }
        return node;
    }

    @Override
    public INode bind(Negative node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            return new Negative(this.bind(node.node, type));
        }
        return node;
    }

    @Override
    public INode bind(Function node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Declaration || type == BinderTypeEnum.All) {
            this.symbolTable().add(new Symbol(new FunctionNameDefinition(node).toString(),
                    node.dataType, node.parametersList));
        }
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            ArrayList<INode> body = new ArrayList<>();
            ArrayList<FunctionParam> params = new ArrayList<>();
            symbolTableStack.add(new SymbolTable(this.symbolTable(), ScopeTypeEnum.Function));
            for (FunctionParam param : node.parametersList) {
                params.add((FunctionParam) this.bind(param, type));
            }
            if (node.dataType != DataTypeEnum.Void && node.bodyNoteList.stream().noneMatch
                    (c -> c instanceof FunctionReturnStatement)) {
                throw new UndefinedFunctionReturn(String.format
                        ("function: \"%s\" is a non void type and must return a value", node.name));
            }
            for (INode child : node.bodyNoteList) {
                this.bind(child, BinderTypeEnum.Declaration);
            }
            for (INode child : node.bodyNoteList) {
                body.add(this.bind(child, BinderTypeEnum.Syntax));
            }
            symbolTableStack.pop();
            return new Function(node.dataType, node.name, body, params);
        }
        return node;
    }

    @Override
    public INode bind(Value node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            if (this.symbolTable().contains(node.value.toString())) {
                return new Variable(node.value.toString());
            }
            Pattern p = Pattern.compile("[A-Za-z]+");
            Matcher m = p.matcher(node.value.toString());
            Matcher boolM = p.matcher(node.value.toString());
            if (m.find() && !boolM.find()) {
                throw new UndefinedVariable(
                        String.format("Variable \"%s\" has not been defined in the current scope",
                                node.value));
            }
        }
        return node;
    }

    @Override
    public INode bind(Variable node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            if (!this.symbolTable().contains(node.value)) {
                throw new UndefinedVariable(String.format
                        ("Variable \"%s\" has not been defined in the current scope", node.value));
            }                
        }
        return node;
    }

    @Override
    public INode bind(Declaration node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            if (this.symbolTable().containsDeclaration(node.name))
            throw new DuplicateDefinition(
                    String.format("\"%s\" already exists in the current scope", node.name));
            this.symbolTable().add(new Symbol(node.name, node.dataType));
        }
        return node;
    }

    @Override
    public INode bind(IfStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            symbolTableStack.add(new SymbolTable(this.symbolTable(), ScopeTypeEnum.If));
            ArrayList<INode> body = new ArrayList<>();
            INode expression = this.bind(node.expression, BinderTypeEnum.Syntax);
            if (!(expression instanceof BooleanExpression) && !new DataTypeChecker
                    (DataTypeEnum.Bool, this.symbolTable()).visit(expression)) {
                throw new IncorrectDataType("If statement expressions must be of data type BOOL");
            }
            for (INode child : node.bodyNodeList) {
                this.bind(child, BinderTypeEnum.Declaration);
            }
            for (INode child : node.bodyNodeList) {
                body.add(this.bind(child, BinderTypeEnum.Syntax));
            }
            symbolTableStack.pop();
            return new IfStatement(body, expression, node.childNode != null ?
                    this.bind(node.childNode, type) : null);
        }
        return node;
    }

    @Override
    public INode bind(ElseStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            symbolTableStack.add(new SymbolTable(this.symbolTable(), ScopeTypeEnum.If));
            ArrayList<INode> body = new ArrayList<>();
            for (INode child : node.bodyNodeList) {
                this.bind(child, BinderTypeEnum.Declaration);
            }
            for (INode child : node.bodyNodeList) {
                body.add(this.bind(child, BinderTypeEnum.Syntax));
            }
            symbolTableStack.pop();
            return new ElseStatement(body);
        }
        return node;
    }

    @Override
    public INode bind(ElseIfStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            symbolTableStack.add(new SymbolTable(this.symbolTable(), ScopeTypeEnum.If));
            ArrayList<INode> body = new ArrayList<>();
            INode expression = this.bind(node.expression, BinderTypeEnum.Syntax);
            if (!(expression instanceof BooleanExpression) && !new DataTypeChecker
                    (DataTypeEnum.Bool, this.symbolTable()).visit(expression)) {
                throw new IncorrectDataType("If statement expressions must be of data type BOOL");
            }
            for (INode child : node.bodyNodeList) {
                this.bind(child, BinderTypeEnum.Declaration);
            }
            for (INode child : node.bodyNodeList) {
                body.add(this.bind(child, BinderTypeEnum.Syntax));
            }
            symbolTableStack.pop();
            return new ElseIfStatement(body, node.expression, node.childNode != null ?
                    this.bind(node.childNode, type) : null);
        }
        return node;
    }

    @Override
    public INode bind(BooleanExpression node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            return new BooleanExpression(this.bind(node.leftNode, type),
                    this.bind(node.rightNode, type), node.operation);
        }
        return node;
    }

    @Override
    public INode bind(WhileStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            symbolTableStack.add(new SymbolTable(this.symbolTable(), ScopeTypeEnum.While));
            ArrayList<INode> body = new ArrayList<>();
            for (INode child : node.bodyNodeList) {
                this.bind(child, BinderTypeEnum.Declaration);
            }
            for (INode child : node.bodyNodeList) {
                body.add(this.bind(child, BinderTypeEnum.Syntax));
            }
            symbolTableStack.pop();
            return new WhileStatement(body, node.expression);
        }
        return node;
    }

    @Override
    public INode bind(FunctionParam node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            this.symbolTable().add(new Symbol(node.name, node.dataType));
        }
        return node;
    }

    @Override
    public INode bind(FunctionReturnStatement node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            INode expression = this.bind(node.expression, type);
            if (!new DataTypeChecker(node.parent.dataType, this.symbolTable()).visit(expression)) {
                throw new IncorrectDataType(String.format
                        ("Function \"%s\" was expecting a return of data type %s",
                                node.parent.name, node.parent.dataType));
            }
            return new FunctionReturnStatement(expression, node.parent);
        }
        return node;
    }

    @Override
    public INode bind(FunctionCall node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            ArrayList<FunctionCallParam> params = new ArrayList<>();
            for (FunctionCallParam param : node.parametersList) {
                params.add((FunctionCallParam)this.bind(param, type));
            }
            FunctionCall newNode = new FunctionCall(node.name, params);
            FunctionNameDefinition functionBestMatch = new FunctionNameDefinition
                    (newNode, this.symbolTable());
            Symbol symbol = this.symbolTable().get(functionBestMatch.toString());
            if (symbol == null) {
                throw new UndefinedFunction(String.format
                        ("Function \"%s(%s)\" has not been defined in the current scope",
                                node.name, functionBestMatch.getDataTypeParams()));
            }
            return newNode;
        }
        return node;
    }

    @Override
    public INode bind(FunctionCallParam node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            return new FunctionCallParam(this.bind(node.expression, type));
        }
        return node;
    }

    @Override
    public INode bind(Parentheses node, BinderTypeEnum type) {
        if (type == BinderTypeEnum.Syntax || type == BinderTypeEnum.All) {
            return new Parentheses(this.bind(node.innerExpression, type));
        }
        return node;
    }

}