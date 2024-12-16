package comprobadorEmail;

public class Main {

	public static void main(String[] args) {


		ComprobadorEmail comprobador = new ComprobadorEmail();
		
		String email = "hola2@hola.com";
		boolean resultado = comprobador.emailValido(email);
		
		
		System.out.println("Comprobación del email " + email);
		System.out.println("Resultado: " + resultado);
	}

}
