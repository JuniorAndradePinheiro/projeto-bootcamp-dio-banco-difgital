package modelo;

public class ContaPoupanca extends Conta{
	protected static final String tipo = "POUPAN�A";
	
	@Override
	public String toString() {
		return "Conta " + tipo + ": " + "Cliente: " + cliente + ", Numero: " + numero + ", Agencia: " + agencia
				+ ", Saldo: " + saldo;	}
}
