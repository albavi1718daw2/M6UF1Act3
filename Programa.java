import java.io.IOException;
import java.util.Scanner;

public class Programa {
	
	public static void main(String[] args) throws IOException {
		
		// Llamamos al men�
		menu();
	}
	
	public static void menu() throws IOException {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Elige una opcion: ");
		System.out.println("--------------------------");
		System.out.println("1) Guardar persona");
		System.out.println("2) Leer todas las fichas");
		System.out.println("3) Consultar seg�n el �ndice");
		System.out.println("4) Salir");
		int opcion = teclado.nextInt();
		
		// Llamamos al m�todo que hace la ejecuci�n seg�n
		// lo que elija el usuario
		opcionElegida(opcion);
	}
	
	public static void opcionElegida(int opcion) throws IOException {
		
		switch (opcion) {
			
			case 1:
				// Guardamos las personas seg�n los campos que nos diga el usuario
				EscriuFitxerAleatori.escriure();
				System.out.println("Persona escrita de forma correcta.");
				System.out.println(" ");
				menu();
				break;
				
			case 2:
				// Leemos todas las fichas de las personas// Guardamos las personas seg�n los campos que nos diga el usuario
				LlegirFitxerAleatori.llegir();
				System.out.println(" ");
				menu();
				break;
				
			case 3:
				// Consultamos seg�n el �ndice
				ConsultarFitxerAleatori.consultar();
				System.out.println(" ");
				menu();
				break;
				
			case 4:
				// Salimos
				System.out.println("Has salido correctamente.");
				break;
				
			default: 
				System.out.println("Has elegido una opci�n incorrecta.");
				menu();
				break;
		}
	}
}
