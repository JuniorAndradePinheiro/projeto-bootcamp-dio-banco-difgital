package modelo;

public class RodarAplicacao {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
		Conta contaCorrente = new ContaCorrente();
		Conta contaPoupanca = new ContaPoupanca();
		
		contaCorrente.setCliente(new Cliente("Jose"));
		contaCorrente.setSaldo(500.00);
		
		contaPoupanca.setCliente(new Cliente("Maria"));
		
		
		banco.setListaContas(contaCorrente);		
		banco.setListaContas(contaPoupanca);
		
		banco.getListaContas().forEach(conta -> System.out.println(conta));
		
		contaCorrente.sacar(100);
		contaPoupanca.depositar(500.00);

		
		contaPoupanca.transferir(10000, contaCorrente);
		
		
		banco.getListaContas().forEach(conta -> System.out.println(conta));
		
		
	}

}
