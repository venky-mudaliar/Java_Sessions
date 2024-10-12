import java.io.*;

public class Ch42_Reader_Writer {
	public static void main(String[] args) {
        // Core Methods of Reader
        coreMethodsOfReader();

        // Core Methods of Writer
        coreMethodsOfWriter();

        // BufferedReader Example
        bufferedReaderExample();

        // BufferedWriter Example
        bufferedWriterExample();
    }

    // Core methods of Reader
    public static void coreMethodsOfReader() {
        // 1. int read()
        try (Reader reader = new FileReader("input.txt")) {
            System.out.println("Reader - Character by Character:");
            int character = reader.read();  // Read one character
            while (character != -1) {  // -1 indicates end of file
                System.out.print((char) character);  // Cast integer to char for display
                character = reader.read();  // Read the next character
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. int read(char[] cbuf)
        try (Reader reader = new FileReader("input.txt")) {
            char[] buffer = new char[100];  // Buffer to hold characters
            int charsRead = reader.read(buffer);  // Read into buffer
            System.out.println("\nReader - Multiple Characters: " + new String(buffer, 0, charsRead));  // Print buffer contents
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3. int read(char[] cbuf, int off, int len)
        try (Reader reader = new FileReader("input.txt")) {
            char[] buffer = new char[50];
            int charsRead = reader.read(buffer, 10, 30);  // Read 30 characters starting at offset 10
            System.out.println("Reader - With Offset: " + new String(buffer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Core methods of Writer
    public static void coreMethodsOfWriter() {
        // 1. void write(int c)
        try (Writer writer = new FileWriter("output.txt")) {
            writer.write(65);  // Writes the character 'A'
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. void write(char[] cbuf)
        try (Writer writer = new FileWriter("output.txt")) {
            char[] data = "Hello, World!".toCharArray();
            writer.write(data);  // Writes the entire array to the file
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3. void write(char[] cbuf, int off, int len)
        try (Writer writer = new FileWriter("output.txt")) {
            char[] data = "Hello, World!".toCharArray();
            writer.write(data, 0, 5);  // Writes "Hello" to the file
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 4. flush() is automatically handled with try-with-resources
    }

    // BufferedReader Example
    public static void bufferedReaderExample() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            System.out.println("BufferedReader - Reading Line by Line:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);  // Print each line
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // BufferedWriter Example
    public static void bufferedWriterExample() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bufferedOutput.txt"))) {
            bufferedWriter.write("This is an example.");
            bufferedWriter.newLine();  // Adds a newline
            bufferedWriter.write("Using BufferedWriter.");
            bufferedWriter.flush();    // Ensure data is written
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
