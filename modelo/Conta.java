package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta{
	private static int SEQUENCIAL = 1;
	protected static  int AGENCIA_PADRAO = 1;
	
	protected Cliente cliente;
	protected int numero;
	protected int agencia;
	protected double saldo;
	
	protected List<Operacao> extrato = new ArrayList<>();
	
	public Conta() {
		this.numero = SEQUENCIAL++;
		this.agencia = AGENCIA_PADRAO;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getNumero() {
		return numero;
	}
	
	
	public int getAgencia() {
		return agencia;
	}
	
	
	public double getSaldo() {
		return saldo;
	}
	

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	protected List<Operacao> getExtrato() {
		return this.extrato;
	}
	
	public void imprimirEtrato() {
		System.out.println("********** Extrato da Conta **********");
		System.out.println("Conta " + this.getNumero() + " | Agencia " + this.getAgencia());
		this.extrato.forEach(opr -> System.out.println(opr));
		System.out.println("**********  Fim do Extrato  **********");
	}

	
	public void sacar(double valor) {
		this.setSaldo(getSaldo() - valor);
		
		Operacao opr = new Operacao();
		opr.setDescricao("Saque");
		opr.setValor(valor);
		this.extrato.add(opr);
	}
	
	
	
	public void depositar(double valor){
		this.setSaldo(getSaldo() + valor);
		
		Operacao opr = new Operacao();
		opr.setDescricao("Deposito");
		opr.setValor(valor);
		this.extrato.add(opr);
	}
	
	
	
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		
		Operacao opr = new Operacao();
		opr.setDescricao("Transferencia");
		opr.setValor(valor);
		this.extrato.add(opr);

	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + numero;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia != other.agencia)
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (numero != other.numero)
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Conta: " + "Cliente: " + cliente + ", Numero: " + numero + ", Agencia: " + agencia
				+ ", Saldo: " + saldo;
	}

	
}
