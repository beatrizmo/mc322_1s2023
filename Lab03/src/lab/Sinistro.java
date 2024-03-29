package lab;

import java.util.Random;

public class Sinistro {
	final private int id;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	//Constructor	
	public Sinistro(String data, String endereco, Cliente cliente, Veiculo veiculo, Seguradora seguradora) {
		this.id = gerarIdRandom();
		this.data = data;
		this.endereco = endereco;
		this.cliente = cliente;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
	}
	
	//Getters e setters
	public int getID() {
		return id;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String toString() {
		return "Sinistro [id=" + id + ", data=" + data + ", endereco=" + endereco + ", seguradora=" + seguradora.getNome()
				+ ", veiculo=" + veiculo.getPlaca() + ", cliente=" + cliente.getNome() + "]";
	}
	
	//Função gerar id aleatório	
	private int gerarIdRandom() {
		Random random =  new Random();
		return Math.abs(random.nextInt());
	}
}
