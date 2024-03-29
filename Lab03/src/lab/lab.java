package lab;
import java.util.Date;
import java.util.Scanner;

public class lab {

	public static void main(String[] args) {
		//Criação da Seguradora
		Seguradora seg = new Seguradora("Seguro", "38421910", "v12345@dac.unicamp.br", "Germano Casellatto");
		System.out.println("Criação de " + seg.toString());
		System.out.println("-------######-------");
		
		Date today = new Date();
		Date then = new Date(117, 05, 21);
		
		//Criação do Cliente Físico e Jurídico		
		ClientePF pessoa = new ClientePF("LUIZ INACIO LULA DA SILVA", "Rua Londres", "070.680.938-68", 
				"masculino" , today, "Superior Completo", then, "Alta");
		System.out.println("Criação de " + pessoa.toString());
		System.out.println("-------######-------");
		
		ClientePJ empresa = new ClientePJ("Cereais Ltda", "Bosque Agua Branca" , 
				"56.419.013/0001-54", then);
		System.out.println("Criação de " + empresa.toString());
		System.out.println("-------######-------");
		
		Cliente pessoa2 = new ClientePF("JAIR MESSIAS BOLSONARO", "Marte", "453.178.287-91", 
				"masculino", today, "Superior Completo", then, "Alta");
		System.out.println("Criação de " + pessoa2.toString());
		System.out.println("-------######-------");
		
		//Validação do CPF e do CNPJ
		System.out.println("Validação de CPF:");
		if (pessoa.validarCPF(pessoa.getCPF())) {
			System.out.println("CPF válido!");
		}
		else {
			System.out.println("CPF inválido!");
		}
		System.out.println("-------######-------");
		
		System.out.println("Validação de CNPJ:");
		if (empresa.validarCNPJ(empresa.getCNPJ())) {
			System.out.println("CNPJ válido!");
		}
		else {
			System.out.println("CNPJ inválido!");
		}
		System.out.println("-------######-------");
		
		//Cadastro dos clientes na seguradora
		seg.cadastrarCliente(pessoa);
		seg.cadastrarCliente(empresa);
		seg.cadastrarCliente(pessoa2);
		//System.out.println(seg.toString());
		System.out.println("Pessoas Físicas cadastradas na Seguradora:");
		seg.listarClientes("CPF");
		System.out.println("-------######-------");
		System.out.println("Pessoas Jurídicas cadastradas na Seguradora:");
		seg.listarClientes("CNPJ");
		System.out.println("-------######-------");
		
		//Adicionando veiculo para cada cliente
		Veiculo carro = new Veiculo("HFH2230", "Ford", "Ka", 2017);
		Veiculo moto = new Veiculo("PUT5540", "Yamaha", "Lander 250", 2020);
		Veiculo patinete = new Veiculo("AAS5443", "Honda", "Fit", 2001);
		System.out.println("Criação de veículos:");
		System.out.println(carro.toString());
		System.out.println(moto.toString());
		System.out.println(patinete.toString());
		System.out.println("-------######-------");
		pessoa.adicionarVeiculo(carro);
		empresa.adicionarVeiculo(moto);
		pessoa2.adicionarVeiculo(patinete);
		System.out.println("Adição de Veículos:");
		System.out.println(pessoa.toString());
		System.out.println(empresa.toString());
		System.out.println(pessoa2.toString());
		System.out.println("-------######-------");
		
		//Criação de um Sinistro e utilização do seu metodo toString()
		Sinistro sinistro = new Sinistro("20/10/1999", "lugar nenhum", pessoa2, patinete, seg);
		System.out.println("Teste do metodo toString do Sinistro:");
		System.out.println(sinistro.toString());
		System.out.println("-------######-------");
		
		//Gerando Sinistro
		System.out.println("Lista de Sinistros:");
		seg.gerarSinistro("20/04/2023", empresa, moto, seg);
		seg.gerarSinistro("19/07/2022", pessoa, carro, seg);
		seg.gerarSinistro("18/09/2020", pessoa, carro, seg);	
		seg.gerarSinistro("30/01/2018", pessoa2, patinete, seg);
		seg.listarSinistros();
		System.out.println("-------######-------");
		
		//Visualizar Sinistro
		System.out.println("Visualizar Sinistros:");
		seg.visualisarSinistro("070.680.938-68");
		seg.visualisarSinistro("56.419.013/0001-54");
		System.out.println("-------######-------");
		
		//Remover ClientePF da Seguradora
		System.out.println("Remoção do ClientePF (pessoa):");
		seg.removerCliente("070.680.938-68");		
		seg.listarClientes("CPF");
		seg.listarClientes("CNPJ");
		System.out.println("-------######-------");
		System.out.println("Lista de Sinistros após remoção do cliente:");
		seg.listarSinistros();
		
		//Menu de visualização da Seguradora	
		Scanner entrada = new Scanner(System.in);
		while(true) {
			System.out.println("-------######-------");
			System.out.println("MENU DE VISUALIZAÇÃO DA SEGURADORA");
			System.out.println("Digite o determinado número para visualizar as informações listadas:");
			System.out.println("1- Nome da Seguradora");
			System.out.println("2- Telefone da Seguradora");
			System.out.println("3- Email da Seguradora");
			System.out.println("4- Endereço da Seguradora");
			System.out.println("5- Lista de Clientes Físicos na Seguradora");
			System.out.println("6- Lista de Clientes Jurídicos na Seguradora");
			System.out.println("7- Lista de Sinistros na Seguradora");
			System.out.println("8- Sair");
			System.out.println("-------######-------");			
			
			int op = entrada.nextInt();
			if (op == 1) {
				System.out.println("Nome: " + seg.getNome());
			}
			else if (op == 2) {
				System.out.println("Telefone: " + seg.getTelefone());
			}
			else if (op == 3) {
				System.out.println("Email: " + seg.getTelefone());
			}
			else if (op == 4) {
				System.out.println("Endereço: " + seg.getEndereco());
			}
			else if (op == 5) {
				System.out.println("Lista de Clientes Físicos: ");
				seg.listarClientes("CPF");
			}
			else if (op == 6) {
				System.out.println("Lista de Clientes Jurídicos: ");
				seg.listarClientes("CNPJ");
			}
			else if (op == 7) {
				System.out.println("Lista de Sinistros: ");
				seg.listarSinistros();
			}
			else if (op == 8) {
				System.out.println("Menu fechado.");
				System.out.println("-------######-------");
				
				break;
			}
		} 
		entrada.close();
				
	}

}
