package compiler.expressions;

import compiler.other.INode;
import java.util.ArrayList;
import java.util.List;

public class Program extends INode {
    public final List<INode> children;

    public Program() {
        super();
        this.children = new ArrayList<>();
    }

    public Program(List<INode> children) {
        super();
        this.children = children;
    }

    @Override
    public String getDisplayName() {
        return Program.class.getSimpleName();
    }
}