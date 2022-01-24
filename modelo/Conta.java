package modelo;

public abstract class Conta implements InterfaceContas{
	private static int SEQUENCIAL = 1;
	protected static  int AGENCIA_PADRAO = 1;
	
	protected Cliente cliente;
	protected int numero;
	protected int agencia;
	protected double saldo;
	
	
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
	
	
	@Override
	public void sacar(double valor) {
		this.setSaldo(getSaldo() - valor);
	}
	
	
	@Override
	public void depositar(double valor){
		this.setSaldo(getSaldo() + valor);
	}
	
	
	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);

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
