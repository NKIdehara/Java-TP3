package classes;
    
public class Aluno extends Pessoa{
	public float nota1;
    public float nota2;
    
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
    public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}

	public void consultarSituacao(){
		System.out.println("\n");
		System.out.println("Aluno(a): " + this.getNome());
		System.out.println("Nota 1: " + this.getNota1());
		System.out.println("Nota 2: " + this.getNota2());
	}

}