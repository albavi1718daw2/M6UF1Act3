import java.io.*;
import java.util.Scanner;

public class EscriuFitxerAleatori {
	
	public static void escriure() throws IOException {
		
		Scanner teclado = new Scanner(System.in);
		
		// Elegimos el fichero
		File file = new File("personas.txt");
		
		// Crea un flujo (stream) de archivo de acceso aleatorio para leer
		RandomAccessFile randomFile = new RandomAccessFile(file, "rw");
		randomFile.seek(randomFile.length());
		
		// Cogemos los datos
		System.out.println(" ");
		System.out.println("Introduce el nombre: ");
		String name = teclado.nextLine();
		System.out.println("Introduce los apellidos: ");
		String surname = teclado.nextLine();
		System.out.println("Introduce el dni: ");
		String dni = teclado.nextLine();
		System.out.println("Introduce la altura (en cm): ");
		int height = teclado.nextInt();
		
		// Buffer de strings
		StringBuffer buffer = null;
		
		// Leemos los strings y los escribimos
		writeString(name, buffer, randomFile);
		writeString(surname, buffer, randomFile);
		writeString(dni, buffer, randomFile);
		
		// Leemos el número y lo escribimos
		writeInt(height, randomFile);
		
		randomFile.close();
	}
	
	public static void writeString(String str, StringBuffer buffer, RandomAccessFile randomFile) throws IOException {
		
		// Leemos los bytes del string y los escribimos
		buffer = new StringBuffer(str);
		buffer.setLength(25);
		randomFile.writeChars(buffer.toString());
	}
	
	public static void writeInt(int number, RandomAccessFile randomFile) throws IOException {

		// Leemos los bytes del string y los escribimos
		randomFile.writeInt(number);
	}
}
