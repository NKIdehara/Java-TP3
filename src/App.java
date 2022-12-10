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

import javax.lang.model.util.ElementScanner14;

import classes.Professor;
import exceptions.SalaInvalidaException;
import exceptions.NomeInvalidoException;
import exceptions.NotaInvalidaException;
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

        Teste();

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
        String nome;
        int sala;
        boolean novoProfessor = false;

        if (TAMANHO == qtdeProfessores+1)
            System.out.println("\nNão é possível incluir novo professor(a).\nQuantidade máxima de professores!");
        else {
            System.out.println("\nCADASTRAR PROFESSOR(A)");
            
            System.out.print("Nome do Professor(a): ");
            nome = in.nextLine();
    
            System.out.print("Sala do Professor: ");
            sala = Integer.valueOf(in.next());

            try {
                qtdeProfessores++;
                professores[qtdeProfessores] = new Professor(nome, sala);
                novoProfessor = true;
            } catch (NomeInvalidoException | SalaInvalidaException e) {
                System.out.println("[ERROR] " + e.getMessage());
                qtdeProfessores--; // ERRO: professor não incluído
            } finally {
                if (novoProfessor) 
                    System.out.print("\nCodigo do Professor(a): " + qtdeProfessores);
                else 
                    System.out.print("\nProfessor(a) nao cadastrado(a)!");
            }
        }
}
    
    private static void cadastrarAluno() {
        Scanner in = new Scanner(System.in);
        String nome;
        float nota1;
        float nota2;
        boolean novoAluno = false;

        if (TAMANHO == qtdeAlunos+1)
            System.out.println("\nNão é possível incluir novo aluno(a).\nQuantidade máxima de alunos!");            
        else {
            System.out.println("\nCADASTRAR ALUNO(A)");
            
            System.out.print("Nome do Aluno(a): ");
            nome = in.nextLine();

            System.out.print("Nota da Avaliacao 1: ");
            nota1 = Float.parseFloat(in.next());
            
            System.out.print("Nota da Avaliacao 2: ");
            nota2 = Float.parseFloat(in.next());

            try {
                qtdeAlunos++;
                alunos[qtdeAlunos] = new Aluno(nome, nota1, nota2);
                novoAluno = true;
            } catch (NomeInvalidoException | NotaInvalidaException e) {
                System.out.println("[ERROR] " + e.getMessage());
                qtdeAlunos--; // ERRO: aluno não incluído
            } finally {
                if (novoAluno) 
                    System.out.print("\nCodigo do Aluno(a): " + qtdeAlunos);
                else 
                    System.out.print("\nAluno(a) nao cadastrado(a)!");
            }
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

    // somente para testes
    private static void Teste(){
        try {
            professores[0] = new Professor("André Lima Santos", 54);
            professores[1] = new Professor("Bárbara Oliveira Monteiro",14); 
            professores[2] = new Professor("Beatriz Pereira Albuquerque",23); 
            professores[3] = new Professor("Bianca Souza Cardoso",05); 
            professores[4] = new Professor("Breno Ramos Carmo",76); 
            professores[5] = new Professor("Bruna Olívia Mesquita",32); 
            professores[6] = new Professor("Bruno Moura Carvalho",19); 
            professores[7] = new Professor("Caio Botelho Machado",26); 
            professores[8] = new Professor("Camila Martins Ribeiro",31); 
            professores[9] = new Professor("Carolina Stella Silva",52); 
        } catch (NomeInvalidoException | SalaInvalidaException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
        qtdeProfessores = 9;

        try {
            alunos[0] = new Aluno("Catarina Sara Moraes",5.6f,8.7f); 
            alunos[1] = new Aluno("Cecília Milena Gomes",6.2f,9.6f); 
            alunos[2] = new Aluno("Clara Batista Ramos",6.8f,9.0f); 
            alunos[3] = new Aluno("Clarice Ferreira Cruz",6.8f,7.8f); 
            alunos[4] = new Aluno("Daniel Andrade Souza",6.6f,8.3f); 
            alunos[5] = new Aluno("Danilo Bernardes Dias",9.3f,8.7f); 
            alunos[6] = new Aluno("Eduarda Letícia Mendes",7.3f,6.6f); 
            alunos[7] = new Aluno("Erick Vitor Costa",5.9f,7.5f); 
            alunos[8] = new Aluno("Esther Figueiredo Pereira",9.4f,6.7f); 
            alunos[9] = new Aluno("Henrique Freitas Couto",7.5f,7.1f); 
        } catch (NomeInvalidoException | NotaInvalidaException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
        qtdeAlunos = 9;
    }

}