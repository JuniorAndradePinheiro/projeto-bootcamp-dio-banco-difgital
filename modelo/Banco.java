package modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> listaContas = new ArrayList<>();
	

	public Banco() {
		
	}
		
	public Banco(String nome, List<Conta> listaContas) {
		super();
		this.nome = nome;
		this.listaContas = listaContas;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setListaContas(Conta conta) {
		this.listaContas.add(conta);
	}
	
	public List<Conta> getListaContas(){
		return this.listaContas;
	}
}
