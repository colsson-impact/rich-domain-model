package org.example;

import java.util.UUID;


public abstract class BaseEntityId {
    private final UUID id;

    protected BaseEntityId(UUID id) {
        if (id == null){
            throw new IllegalArgumentException("id must not be null");
        }
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntityId that = (BaseEntityId) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id.toString();
    }
}