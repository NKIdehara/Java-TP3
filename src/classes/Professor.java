package classes;

public class Professor extends Pessoa{
    public int sala;
    
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}

	public void consultarSituacao(){
		System.out.println("\n");
		System.out.println("Professor(a): " + this.getNome());
		System.out.println("Sala: " + this.getSala());
	}
}