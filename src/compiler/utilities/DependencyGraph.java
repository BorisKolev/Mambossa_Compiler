package compiler.utilities;

import compiler.other.INode;
import compiler.other.Dependency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class DependencyGraph {
    private final Map<Dependency, Set<Dependency>> dependencies;

    public DependencyGraph() {
        dependencies = new HashMap<>();
    }

    public static Dependency buildDependency(INode node) {
        return new Dependency(node.id, node.getDisplayName());
    }

    public boolean containsCycle(Dependency a, Dependency b) {
        return this.containsDependency(a, b) && this.containsDependency(b, a);
    }

    public boolean containsDependency(Dependency parent, Dependency dependency) {
        if (!dependencies.containsKey(parent)) {
            return false;
        }
        Set<Dependency> setDependencies = dependencies.get(parent);
        if (setDependencies.stream().anyMatch(d -> d.equals(dependency))) {
            return true;
        }
        for (Dependency temp : setDependencies) {
            if (this.containsDependency(temp, dependency)) {
                return true;
            }
        }
        return false;
    }

    public void addDependency(INode parent, INode dependency) {
        Dependency parentDependency = buildDependency(parent);
        if (dependencies.containsKey(parentDependency)) {
            dependencies.get(parentDependency).add(buildDependency(dependency));
        } else {
            Set<Dependency> scopedDependencies = new HashSet<>();
            scopedDependencies.add(buildDependency(dependency));
            dependencies.put(parentDependency, scopedDependencies);
        }
    }
}