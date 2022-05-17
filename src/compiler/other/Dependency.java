package compiler.other;

import java.util.UUID;

public record Dependency(UUID id, String name) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependency dependency = (Dependency) o;
        if (!this.id.toString().equals(dependency.id.toString())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (this.id != null ? this.id.toString().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s", id, name);
    }
}