package classes;

import exceptions.NomeInvalidoException;

public abstract class Pessoa{
    private String nomePessoal;
    private String nomeMeio;
    private String nomeUltimo;
    
	public String getNome() {
		StringBuilder nome = new StringBuilder();
		nome.append(nomePessoal).append(" ").append(nomeMeio).append(" ").append(nomeUltimo);
		return nome.toString();
	}
	public void setNome(String nome) {
		String[] str = nome.split(" ");
		this.nomePessoal = str[0];
		this.nomeMeio = str[1];
		this.nomeUltimo = str[2];
	}

	public Pessoa(String nome) throws NomeInvalidoException{
		if (nome.lastIndexOf(" ") == -1) {
			throw new NomeInvalidoException("Nome invalido!");
		}
		if (nome.indexOf(" ") == nome.lastIndexOf(" ")) {
			throw new NomeInvalidoException("Nome do meio invalido!");
		}

		this.nomePessoal = nome.substring(0, nome.indexOf(" "));
		this.nomeMeio = nome.substring(nome.indexOf(" ")+1, nome.lastIndexOf(" "));
		this.nomeUltimo = nome.substring(nome.lastIndexOf(" ")+1);
	}

	public abstract void consultarSituacao();
}