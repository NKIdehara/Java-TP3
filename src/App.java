/***************************************************************************************
 *
 * TESTE DE PERFORMANCE - TP3
 * Instituto Infnet
 * Engenharia de Software
 *
 * Fundamentos do Desenvolvimento Java
 *
 * Aluno: Nelson Kenji Idehara
 * Professor: Elberth Moraes
 * Data: 10 Dezembro 2022
 *
 ***************************************************************************************/

import java.util.Scanner;

import classes.Professor;
import classes.Aluno;

class Main {
    private static int opcao;                  // opção do menu
    private static int codigo;                 // codigo da pessoa
    private static int qtdeProfessores  = -1;  // quantidade de registros
    private static int qtdeAlunos = -1;        // quantidade de registros

    private static final int TAMANHO = 100;

    private static Professor[] professores = new Professor[TAMANHO];
    private static Aluno[] alunos = new Aluno[TAMANHO];

    public static void main(String[] args) {        
        Scanner in = new Scanner(System.in);


        do {
            System.out.println("\n");
            System.out.println("[1] Cadastar professor");
            System.out.println("[2] Cadastrar aluno");
            System.out.println("[3] Consultar situacao de um docente/discente");
            System.out.println("[4] Sair");

            System.out.print("Digite a opcao: ");
            opcao = Integer.valueOf(in.next());
            
            // verifica opção
            if (opcao < 1 || opcao > 4){
                System.out.println("Opcao inexistente!\n");                
            }
            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    cadastrarAluno();
                    break;
                case 3:
                    consultarPessoa();
                    break;
            }
        } while (opcao != 4);
        System.out.println("\nVolte sempre!");
    }

    private static void cadastrarProfessor() {
        Scanner in = new Scanner(System.in);

        if (TAMANHO == qtdeProfessores+1)
            System.out.println("\nNão é possível incluir novo professor(a).\nQuantidade máxima de professores!");            
        else {
            qtdeProfessores++;
            Professor professor = new Professor();
            System.out.println("\nCADASTRAR PROFESSOR(A)");
                
            System.out.print("Nome do Professor(a): ");
            professor.setNome(in.nextLine());
    
            System.out.print("Sala do Professor: ");
            professor.setSala(Integer.valueOf(in.next()));

            professores[qtdeProfessores] = professor;
            System.out.print("\nCodigo do Professor(a): " + qtdeProfessores);
        }
}
    
    private static void cadastrarAluno() {
        Scanner in = new Scanner(System.in);

        if (TAMANHO == qtdeAlunos+1)
            System.out.println("\nNão é possível incluir novo aluno(a).\nQuantidade máxima de alunos!");            
        else {
            qtdeAlunos++;

            Aluno aluno = new Aluno();

            System.out.println("\nCADASTRAR ALUNO(A)");
            
            System.out.print("Nome do Aluno(a): ");
            aluno.setNome(in.nextLine());

            System.out.print("Nota da Avaliacao 1: ");
            aluno.setNota1(Float.parseFloat(in.next()));
            
            System.out.print("Nota da Avaliacao 2: ");
            aluno.setNota2(Float.parseFloat(in.next()));

            alunos[qtdeAlunos] = aluno;
            System.out.print("\nCodigo do Aluno(a): " + qtdeAlunos);
        }
    }
    
    private static void consultarPessoa() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n");
            System.out.println("[1] Consultar professor");
            System.out.println("[2] Consultar aluno");
            System.out.println("[3] Retornar");

            System.out.print("Digite a opcao: ");
            opcao = Integer.valueOf(in.next());
            
            // verifica opção
            if (opcao < 1 || opcao > 3){
                System.out.println("Opcao inexistente!\n");                
            }
            switch (opcao) {
                case 1:
                    System.out.print("Digite o codigo do professor(a): ");
                    codigo = Integer.valueOf(in.next());
                    if (codigo < 0 || codigo > qtdeProfessores)
                        System.out.println("Codigo inválido!\n");                
                    else 
                        professores[codigo].consultarSituacao();
                    break;
                case 2:
                    System.out.print("Digite o codigo do aluno(a): ");
                    codigo = Integer.valueOf(in.next());
                    if (codigo < 0 || codigo > qtdeAlunos)
                        System.out.println("Codigo inválido!\n");                
                    else 
                        alunos[codigo].consultarSituacao();
                break;
            }
        } while (opcao != 3);
       
    }

}