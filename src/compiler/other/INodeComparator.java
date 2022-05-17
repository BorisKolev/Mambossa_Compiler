package compiler.other;

import compiler.utilities.DependencyGraph;
import java.util.Comparator;

public record INodeComparator(DependencyGraph dependencyGraph) implements Comparator<INode> {

    @Override
    public int compare(INode a, INode b) {
        Dependency aDependency = DependencyGraph.buildDependency(a);
        Dependency bDependency = DependencyGraph.buildDependency(b);
        if (dependencyGraph.containsCycle(aDependency, bDependency)) {
            throw new RuntimeException(String.format
                    ("Dependency cycle detected, a: %s, b: %s", aDependency, bDependency));
        }
        if (dependencyGraph.containsDependency(aDependency, bDependency)) {
            return 1;
        }
        if (dependencyGraph.containsDependency(bDependency, aDependency)) {
            return -1;
        }
        return 0;
    }
}