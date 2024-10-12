import java.io.*;

public class Ch40_Input_Streams {

	public static void main(String[] args) {
        // Core Methods of InputStream
        coreMethodsOfInputStream();

        // Types of InputStreams
        fileInputStreamExample();
        bufferedInputStreamExample();
        dataInputStreamExample();
        objectInputStreamExample();
        pipedInputStreamExample();
    }

    // Core methods of InputStream

    public static void coreMethodsOfInputStream() {
        try (InputStream input = new FileInputStream("file.txt")) {
            // 1. int read()
            int data = input.read();  // Reads one byte
            while (data != -1) {
                System.out.print((char) data);  // Cast to char to display text
                data = input.read();  // Read the next byte
            }
            // 2. int read(byte[] b)
            byte[] buffer = new byte[100];
            int bytesRead = input.read(buffer);  // Read bytes into buffer
            if (bytesRead != -1) {
                System.out.println("\nBytes read: " + bytesRead);
            }

            // 3. int read(byte[] b, int off, int len)
            int moreBytesRead = input.read(buffer, 10, 50);  // Read bytes with offset and length
            if (moreBytesRead != -1) {
                System.out.println("More bytes read: " + moreBytesRead);
            }

            // 4. void close() - automatically closed with try-with-resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Types of InputStreams

    // 1. FileInputStream Example
    public static void fileInputStreamExample() {
        try (InputStream fileInput = new FileInputStream("input.dat")) {
            int byteData = fileInput.read();  // Reads one byte from the file
            System.out.println("\nFileInputStream - Byte data: " + byteData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. BufferedInputStream Example
    public static void bufferedInputStreamExample() {
        try (InputStream bufferedInput = new BufferedInputStream(new FileInputStream("input.txt"))) {
            int byteData = bufferedInput.read();  // Buffered read for efficiency
            System.out.println("BufferedInputStream - Byte data: " + byteData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. DataInputStream Example
    public static void dataInputStreamExample() {
        try (DataInputStream dataInput = new DataInputStream(new FileInputStream("data.dat"))) {
            int value = dataInput.readInt();  // Reads an integer
            System.out.println("DataInputStream - Read integer: " + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4. ObjectInputStream Example
    public static void objectInputStreamExample() {
        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("object.dat"))) {
            MyClass obj = (MyClass) objectInput.readObject();  // Reads an object
            System.out.println("ObjectInputStream - Read object: " + obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 5. PipedInputStream Example
    public static void pipedInputStreamExample() {
        try {
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);
            pos.write(65);  // Writes 'A' to the stream
            int data = pis.read();  // Reads 'A' from the stream
            System.out.println("PipedInputStream - Read data: " + (char) data);
            pis.close();
            pos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Class used for ObjectInputStream example
    static class MyClass implements Serializable {
        private String name;

        public MyClass(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyClass{name='" + name + "'}";
        }
    }
}
