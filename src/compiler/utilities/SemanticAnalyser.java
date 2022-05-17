package compiler.utilities;

import compiler.other.INode;
import compiler.expressions.Program;
import compiler.other.BinderTypeEnum;
import java.util.ArrayList;

public class SemanticAnalyser {
    private final SyntaxBinder syntaxBinder = new SyntaxBinder();

    public Program analyse(Program node) {
        Program result = (Program)syntaxBinder.bind(node, BinderTypeEnum.All);
        ArrayList<INode> declarationChildren = new ArrayList<>();
        ArrayList<INode> syntaxChildren = new ArrayList<>();
        for (INode child : result.children) {
            declarationChildren.add(syntaxBinder.bind(child, BinderTypeEnum.Declaration));
        }
        for (INode child : declarationChildren) {
            syntaxChildren.add(syntaxBinder.bind(child, BinderTypeEnum.Syntax));
        }
        return new Program(syntaxChildren);
    }
}