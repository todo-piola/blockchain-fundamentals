package firstBlockchain;

import java.security.MessageDigest;

public class Encriptacion {
	
	// Método que aplica el algoritmo hash criptográfico SHA256
	public static String aplicarSHA256(String input){		
		try {
			MessageDigest mensaje = MessageDigest.getInstance("SHA-256");	        

			byte[] hash = mensaje.digest(input.getBytes("UTF-8"));	        
			StringBuffer hexadecimalString = new StringBuffer();
			
			for (int i = 0; i < hash.length; i++) {
				String hexadecimal = Integer.toHexString(0xff & hash[i]);
				if(hexadecimal.length() == 1) hexadecimalString.append('0');
				hexadecimalString.append(hexadecimal);
			}
			return hexadecimalString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
