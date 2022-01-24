package modelo;

public interface InterfaceContas {

	void sacar(double valor);
	void depositar(double valor);
	void transferir(double valor, Conta contaDetino);
}
