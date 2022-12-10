package classes;

import exceptions.NomeInvalidoException;
import exceptions.SalaInvalidaException;

public class Professor extends Pessoa{
    public int sala;
    
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}

	public Professor (String nome, int sala) throws SalaInvalidaException, NomeInvalidoException{
		super(nome);
		if (sala <= 0 || sala >= 100) {
			throw new SalaInvalidaException("Numero da sala invalida!");
		}
		this.sala = sala;
	}

	public void consultarSituacao(){
		System.out.println("\n");
		System.out.println("Professor(a): " + this.getNome());
		System.out.println("Sala: " + this.getSala());
	}
}