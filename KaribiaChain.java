package firstBlockchain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class KaribiaChain {
	
	public static int dificultad = 7;
	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 

	public static void main(String[] args) {
		
		//Minamos los bloques para crear la blockchain
		blockchain.add(new Block("Soy el primer bloque", "0"));
		System.out.println("Intentando minar bloque 1");
		blockchain.get(0).minarBloque(dificultad);
		
		blockchain.add(new Block("Yo soy el segundo bloque!", blockchain.get(blockchain.size()-1).hash));
		System.out.println("Intentando minar bloque 2");
		blockchain.get(1).minarBloque(dificultad);
	
		blockchain.add(new Block("Aquí el tercer bloque", blockchain.get(blockchain.size()-1).hash));
		System.out.println("Intentando minar bloque 3");
		blockchain.get(2).minarBloque(dificultad);
		
		System.out.println("Blockchain es valida: " + validarBlockchain());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("KaribiaChain: ");
		System.out.println(blockchainJson);
		
		//Guardo el contenido en un archivo .json
		guardarBlockchain("blockchain.json", blockchainJson); 
		
	}
	
	// Método que sirve para validar que la blockchain sea correcta (comprobación de hash entre bloques)
	public static Boolean validarBlockchain() {
		Block bloqueActual; 
		Block bloqueAnterior;
		String objetivo = "0".repeat(dificultad);
		
		for(int i=1; i < blockchain.size(); i++) {
			bloqueActual = blockchain.get(i);
			bloqueAnterior = blockchain.get(i-1);
			
			if(!bloqueActual.hash.equals(bloqueActual.calcularHash()) ) {
				System.out.println("Hash actual no coincide");			
				return false;
			}

			if(!bloqueAnterior.hash.equals(bloqueActual.hashDelBloquePrevio) ) {
				System.out.println("Hash previo no coincide");
				return false;
			}
			
			if(!bloqueActual.hash.substring( 0, dificultad).equals(objetivo)) {
				System.out.println("Este bloque aún no ha sido minado");
				return false;
			}
		}
		
		return true;
	}
	
	// Nuevo método para guardar la blockchain en archivo JSON
		private static void guardarBlockchain(String nombreArchivo, String contenidoJson) {
			try (FileWriter writer = new FileWriter(nombreArchivo)) {
				writer.write(contenidoJson);
				System.out.println("Blockchain guardada en " + nombreArchivo);
			} catch (IOException e) {
				System.out.println("Error al guardar la blockchain: " + e.getMessage());
			}
		}
	

}
