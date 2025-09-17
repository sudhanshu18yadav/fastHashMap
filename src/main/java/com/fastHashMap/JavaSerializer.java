package com.fastHashMap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaSerializer {
    public static <T> Binary serialize(T o) {
        if (o == null)
            return null;
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(o);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
        
        return new Binary(baos.toByteArray());
    }
    
    public static <T> T deserialize(Binary b) {
        if (b == null)
            return null;
        
        ByteArrayInputStream bais = new ByteArrayInputStream(b.getValue());
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}