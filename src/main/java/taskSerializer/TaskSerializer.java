package taskSerializerr;

import Model.Model;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TaskSerializer {

    private static final String DATA_PATH = "data.bin";

    public static void serialize(Object[] tasks) throws IOException {
        try(var serializer = new ObjectOutputStream(new FileOutputStream(DATA_PATH))) {
            serializer.writeObject(tasks);
        }
    }

    public static Model[] deserialize() throws  IOException, ClassNotFoundException {
        try(var deserializer = new ObjectInputStream(new FileInputStream(DATA_PATH))) {
            Object[] task = (Object[]) deserializer.readObject();
            Model[] array = new Model[task.length];
            for (int i = 0; i < task.length; i++) {
                array[i] = (Model)task[i];
            }
            return array;
        }
    }
}
