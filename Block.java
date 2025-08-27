package firstBlockchain;

import java.util.Date;

public class Block {
	public String hash; 
	public String hashDelBloquePrevio;
	private String datos;
	private long marcaTiempo;
	private int numeroRandom;

	public Block(String datos, String hashDelBloquePrevio) {
		this.datos = datos;
		this.hashDelBloquePrevio = hashDelBloquePrevio;
		this.marcaTiempo = new Date().getTime();
		this.hash = calcularHash(); 
	}
	
	
	public String calcularHash() {
		String hashCalculado = Encriptacion.aplicarSHA256( 
				hashDelBloquePrevio +
				Long.toString(marcaTiempo) +
				Integer.toString(numeroRandom) + 
				datos 
			);
		
		return hashCalculado;
	}
	
	public void minarBloque(int dificultad) {
	    String objetivo = "0".repeat(dificultad);
	    
	    double tiempoInicio = System.currentTimeMillis();

	    // Repite intentos de minado hasta que el hash empiece con la cantidad de ceros que se solicita
	    while (!cumpleDificultad(objetivo, dificultad)) {
	        numeroRandom++;
	        hash = calcularHash();
	    }
	    
	    // Muestra el tiempo transcurrido al minar un bloque
	    double tiempoFin = System.currentTimeMillis();
	    
	    int segundos = (int) ((tiempoFin - tiempoInicio)/1000);
	    int minutos = 0;
	    
	    if(segundos > 60) {
	    	minutos = (int) (segundos / 60);
	    	segundos = segundos % 60;
	    	
	    	System.out.println("Bloque minado !!! : " + hash);
		    System.out.println("Tiempo de minado total : " + minutos + "minutos y " + segundos + " segundos." );
	    } else {
	    	 segundos = (int) ((tiempoFin - tiempoInicio)/1000);
	    	 System.out.println("Bloque minado !!! : " + hash);
			 System.out.println("Tiempo de minado total : " + segundos + " segundos." );
	    }

	}

	private boolean cumpleDificultad(String objetivo, int dificultad) {
	    return hash.startsWith(objetivo);
	}
}
