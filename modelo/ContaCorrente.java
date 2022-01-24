package modelo;

public class ContaCorrente extends Conta{
	protected static final String tipo = "CORRENTE";

	@Override
	public String toString() {
		return "Conta " + tipo + ": " + "Cliente: " + cliente + ", Numero: " + numero + ", Agencia: " + agencia
				+ ", Saldo: " + saldo;	}

		
}

