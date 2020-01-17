import java.io.*;

public class LlegirFitxerAleatori {
	
	public static void llegir() throws IOException {
		
		// Cogemos el fichero
		File file = new File("personas.txt");
		
		// Creamos un flujo de acceso al fichero de solo lectura
		RandomAccessFile randomFile = new RandomAccessFile(file, "r");
		
		// Apuntador, es el inicio del fichero
		int apuntador = 0;
		char name[] = new char[25], surname[] = new char[25], dni[] = new char[25], aux = ' ';
		
		boolean finish = false;
		int contador = 1;
		
		//Recorrer el fitxer llibres
		while (!finish) {
			
			// Apuntamos al inicio de cada libro en el fichero
			randomFile.seek(apuntador);

			// Leemos los strings
			String names = new String(readString(name, randomFile, aux));
			String surnames = new String(readString(surname, randomFile, aux));
			String ids = new String(readString(dni, randomFile, aux));
			
			// Lee la altura
			int heights = randomFile.readInt();
			
			// Mostramos los datos de cada persona
			System.out.println("\nID: " + contador + "\nNombre: " + names + "\nApellidos: " + surnames 
					+ "\nDNI: " + ids + "\nAltura: " + heights);
			
			// Posicionamos en la siguiente persona
			apuntador += 154;
			
			// Si coincide con el final del fichero, salimos
			if (randomFile.getFilePointer() == randomFile.length()) finish = true;
			
			contador++;
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
