package lab;

public class Validacao {
	
	public static boolean validarCNPJ(String CNPJ) {
	    // Remove caracteres não numéricos
	    CNPJ = CNPJ.replaceAll("[^0-9]", "");

	    // Verifica se o tamanho do CNPJ é 14 caracteres
	    if (CNPJ.length() != 14) {
	        return false;
	    }

	    // Verifica se todos os caracteres do CNPJ são iguais
	    if (CNPJ.matches("(\\d)\\1{13}")) {
	        return false;
	    }

	    int soma = 0;
	    int peso = 2;
	    for (int i = 11; i >= 0; i--) {
	        soma += (CNPJ.charAt(i) - '0') * peso;
	        peso++;
	        if (peso > 9) {
	            peso = 2;
	        }
	    }

	    int digito1 = soma % 11;
	    if (digito1 < 2) {
	        digito1 = 0;
	    } else {
	        digito1 = 11 - digito1;
	    }

	    soma = 0;
	    peso = 2;
	    for (int i = 12; i >= 0; i--) {
	        soma += (CNPJ.charAt(i) - '0') * peso;
	        peso++;
	        if (peso > 9) {
	            peso = 2;
	        }
	    }

	    int digito2 = soma % 11;
	    if (digito2 < 2) {
	        digito2 = 0;
	    } else {
	        digito2 = 11 - digito2;
	    }

	    return CNPJ.charAt(12) == (char) (digito1 + '0') && CNPJ.charAt(13) == (char) (digito2 + '0');
	}

	public static boolean validarCPF(String CPF) {
		String newCPF = CPF.replaceAll("-", "");
		newCPF = newCPF.replaceAll("\\.","");
		int n = newCPF.length();
		
		if (n != 11) { //verificar se tem 11 dígitos
			return false;
		}
		
		int iguais = 0; //verificar se todos os dígitos são iguais
		for (int i = 1; i < n; i++) {
			if (newCPF.charAt(0) != newCPF.charAt(i)) {
					iguais = 1;	
					break;
			}
		}
		if (iguais == 0) {
			return false;
		}
		
		//calcular os dígitos verificadores
		int soma = 0; 
		for (int i=0; i < 9; i++) { //primeiro dígito
			soma += Character.getNumericValue(newCPF.charAt(i)) * (10-i);
		}	
		int primeiroVerificador = 11 - (soma % 11);
		if (primeiroVerificador == 10 || primeiroVerificador == 11) {
			primeiroVerificador = 0;
		}
		soma = 0;
		for (int i=0; i < 10; i++) { //segundo dígito
			soma += Character.getNumericValue(newCPF.charAt(i)) * (11-i);
		}
		int segundoVerificador = 11 - (soma % 11);
		if (segundoVerificador == 10 || segundoVerificador == 11) {
			segundoVerificador = 0;
		}
				
		//verificar se os dígitos calculados são iguais aos informados
		if (primeiroVerificador != Character.getNumericValue(newCPF.charAt(9))) {
			return false;
		}
		if (segundoVerificador != Character.getNumericValue(newCPF.charAt(10))) {
			return false;
		}
		
		return true;
	}

	public static boolean validarNome(String nome) {
		
		if(nome == "" || nome.charAt(0) == ' ') {
			return false;
		}
	    String expressaoRegular = "^[a-zA-Z ]+$";
	    return nome.matches(expressaoRegular);
	}
}

