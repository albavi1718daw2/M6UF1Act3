import java.io.*;
import java.util.*;

public class ConsultarFitxerAleatori {
	
	public static void consultar() throws IOException {
		
		Scanner teclado = new Scanner(System.in);
		
		// Cogemos el fichero
		File file = new File("personas.txt");
		
		// Creamos un flujo de acceso al fichero de solo lectura
		RandomAccessFile randomFile = new RandomAccessFile(file, "r");
		
		// Apuntador, es el inicio del fichero
		int apuntador = 0;
		char name[] = new char[25], surname[] = new char[25], dni[] = new char[25], aux = ' ';
		
		// Pedimos el  identificador al usuario
		System.out.print("Introduce la ID a consultar: ");
		int id = teclado.nextInt();
		
		// Apuntador per agafar la persona
		apuntador = (id - 1) * 154;
		
		if (apuntador >= randomFile.length() || id == 0) {
			
			System.out.println("ID INCORRECTO. No existe esta persona.");
			
		} else {
			
			// Apuntamos al inicio de la persona
			randomFile.seek(apuntador);
			
			// Leemos los strings
			String names = new String(readString(name, randomFile, aux));
			String surnames = new String(readString(surname, randomFile, aux));
			String ids = new String(readString(dni, randomFile, aux));

			// Lee la altura
			int heights = randomFile.readInt();

			// Mostramos los datos de cada persona
			System.out.println("\nNombre: " + names + "\nApellidos: " + surnames 
					+ "\nDNI: " + ids + "\nAltura: " + heights);
		}
		
		// Cerramos el fichero
		randomFile.close();
	}

	public static String readString(char[] name, RandomAccessFile randomFile, char aux) throws IOException {

		// Lee el nombre
		for(int i = 0; i < name.length; i++) {
			aux = randomFile.readChar();
			name[i] = aux;
		}

		return new String(name);
	}
}
