import java.io.*;

//MyClass implementing Serializable
class MyClass implements Serializable {
	// serialVersionUID ensures class compatibility during deserialization
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;

	// transient fields will not be serialized
	private transient String password;

	public MyClass(String name, int age, String password) {
		this.name = name;
		this.age = age;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Password: " + (password != null ? password : "Not serialized");
	}
}

public class Ch43_Serialization_Deserialization {
	public static void main(String[] args) {
		// Serialization
		serializeObject();

		// Deserialization
		deserializeObject();
	}

	// Method for serialization
	public static void serializeObject() {
		try {
			MyClass obj = new MyClass("John", 25, "secretPassword"); // Create an object with a transient field
			FileOutputStream fileOut = new FileOutputStream("object.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj); // Serialize the object
			out.close();
			fileOut.close();
			System.out.println("Object serialized and saved to object.ser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method for deserialization
	public static void deserializeObject() {
		try {
			FileInputStream fileIn = new FileInputStream("object.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			MyClass obj = (MyClass) in.readObject(); // Deserialize the object
			in.close();
			fileIn.close();
			System.out.println("Object deserialized: " + obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
