package lab;

import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
	//Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaSinistros = new ArrayList<Sinistro>();
	}

	//Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		return this.listaClientes.add(cliente);
		
	}	
	
	public boolean removerCliente(String cliente) {
		String identificador = "";
		for (Cliente clienteAtual : listaClientes) {
			
			if (clienteAtual instanceof ClientePF) {
				ClientePF pf = (ClientePF) clienteAtual;
				identificador = pf.getCPF();
				
			}
			if (clienteAtual instanceof ClientePJ) {
				ClientePJ pj = (ClientePJ) clienteAtual;
				identificador = pj.getCNPJ();
			}
			if (identificador == cliente) {
				listaClientes.remove(clienteAtual);
				System.out.println("Removido da lista de clientes!");
				this.removerSinistro(cliente);
				return true;
			}			
		}
		return false;
	}
	
	public void removerSinistro(String cliente) {
		String identificador = "";		
		ArrayList<Sinistro> listaReserva = new ArrayList<Sinistro>();
		
		for (Sinistro sinistroAtual : listaSinistros) {
			Cliente clienteAtual = sinistroAtual.getCliente();
			
			if (clienteAtual instanceof ClientePF) {
				ClientePF pf = (ClientePF) clienteAtual;
				identificador = pf.getCPF();				
			}
			if (clienteAtual instanceof ClientePJ) {
				ClientePJ pj = (ClientePJ) clienteAtual;
				identificador = pj.getCNPJ();
			}
			if (identificador == cliente) {
				listaReserva.add(sinistroAtual);
				System.out.println("Removido da lista de sinistros!");
			}			
		}
		
		for (Sinistro sinistroAtual : listaReserva) {
			listaSinistros.remove(sinistroAtual);
		}
	}
	
	public void listarClientes(String tipoCliente) {
		for (Cliente clienteAtual : listaClientes) {			
			if ((clienteAtual instanceof ClientePF) && tipoCliente == "CPF") {
				System.out.println(clienteAtual.toString());				
			}
			if (clienteAtual instanceof ClientePJ && tipoCliente == "CNPJ") {
				System.out.println(clienteAtual.toString());
			}		
		}
	}
	
	public boolean visualisarSinistro(String cliente) {
		String identificador = "";
		int cont = 0;
		for (Sinistro sinistroAtual : listaSinistros) {
			Cliente clienteAtual = sinistroAtual.getCliente();
			
			if (clienteAtual instanceof ClientePF) {
				ClientePF pf = (ClientePF) clienteAtual;
				identificador = pf.getCPF();
				
			}
			else if (clienteAtual instanceof ClientePJ) {
				ClientePJ pj = (ClientePJ) clienteAtual;
				identificador = pj.getCNPJ();
			}
			if (identificador == cliente) {
				System.out.println(sinistroAtual);
				cont++;
			}			
		}
		return cont > 0;
	}
	
	public void listarSinistros() {
		System.out.println(listaSinistros);
	}
	
	
	public boolean gerarSinistro(String data, Cliente cliente, Veiculo veiculo, Seguradora seguradora) {
		Sinistro sin = new Sinistro(data, cliente.getEndereco(), cliente, veiculo, seguradora);
		return this.listaSinistros.add(sin);
	}
	
	
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", listaSinistros=" + listaSinistros + ", listaClientes=" + listaClientes + "]";
	}
	
	
	
}
