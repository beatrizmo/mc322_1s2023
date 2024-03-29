package lab;

import java.util.Date;

public class ClientePJ extends Cliente{
	final private String CNPJ;
	private Date dataFundacao;
	
	public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao) {
		super(nome, endereco);
		this.CNPJ = gerarCNPJ(CNPJ);
		this.dataFundacao = dataFundacao;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String gerarCNPJ(String CNPJ) {
		if (this.validarCNPJ(CNPJ)) {
			return CNPJ;
		}
		return "CNPJ invalido";
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public boolean validarCNPJ(String CNPJ) {
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

	@Override
	public String toString() {
		return "ClientePJ [CNPJ=" + CNPJ + ", dataFundacao=" + dataFundacao + super.toString();
	}

	
}
