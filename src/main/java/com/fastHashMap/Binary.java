package com.fastHashMap;

import java.util.Arrays;

public final class Binary {
    private final byte[] value;
    
    public Binary(byte[] value) {
        if (value == null)
            throw new NullPointerException("value is null");
        
        this.value = value;
    }

    public byte[] getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Arrays.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Binary other = (Binary) obj;
        
        return Arrays.equals(this.value, other.value);
    }

    @Override
    public String toString() {
        return "Binary{" + "value=size(" + value.length + ")}";
    }
}
