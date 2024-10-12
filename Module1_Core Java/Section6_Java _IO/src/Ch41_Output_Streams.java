import java.io.*;

public class Ch41_Output_Streams {
	public static void main(String[] args) {
        // Core Methods of OutputStream
        coreMethodsOfOutputStream();

        // Types of OutputStreams
        fileOutputStreamExample();
        bufferedOutputStreamExample();
        dataOutputStreamExample();
        objectOutputStreamExample();
        pipedOutputStreamExample();
    }

    // Core methods of OutputStream
    public static void coreMethodsOfOutputStream() {
        try (OutputStream output = new FileOutputStream("output.txt")) {
            // 1. void write(int b)
            output.write(65);  // Writes the byte for ASCII 'A'

            // 2. void write(byte[] b)
            byte[] data = "Hello, World!".getBytes();
            output.write(data);  // Writes the entire byte array

            // 3. void write(byte[] b, int off, int len)
            output.write(data, 0, 5);  // Writes "Hello"

            // 4. void flush()
            output.flush();  // Flushes the stream to ensure data is written
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Types of OutputStreams

    // 1. FileOutputStream Example
    public static void fileOutputStreamExample() {
        try (OutputStream output = new FileOutputStream("file.txt")) {
            output.write("Hello, File!".getBytes());  // Writes data to file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. BufferedOutputStream Example
    public static void bufferedOutputStreamExample() {
        try (OutputStream output = new BufferedOutputStream(new FileOutputStream("bufferedOutput.txt"))) {
            output.write("Efficient Write with BufferedOutputStream!".getBytes());
            output.flush();  // Ensures data is written from buffer to file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. DataOutputStream Example
    public static void dataOutputStreamExample() {
        try (DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream("dataOutput.dat"))) {
            dataOutput.writeInt(123);  // Write an int
            dataOutput.writeBoolean(true);  // Write a boolean
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4. ObjectOutputStream Example
    public static void objectOutputStreamExample() {
        try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream("objectOutput.dat"))) {
            MyClass obj = new MyClass("Sample", 42);
            objectOutput.writeObject(obj);  // Write an object
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 5. PipedOutputStream Example
    public static void pipedOutputStreamExample() {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            pos.write(65);  // Writes 'A' to the pipe
            System.out.println("PipedOutputStream - Read data: " + (char) pis.read());
            pos.close();
            pis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Class used for ObjectOutputStream example
    static class MyClass implements Serializable {
        private String name;
        private int id;

        public MyClass(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "MyClass{name='" + name + "', id=" + id + "}";
        }
    }
}

