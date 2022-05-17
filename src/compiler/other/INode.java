package compiler.other;

import java.util.UUID;

public abstract class INode {
    public UUID id;

    public INode(UUID id) {
        this.id = id;
    }

    public INode() {
        this.id = UUID.randomUUID();
    }

    public abstract String getDisplayName();
}