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

import src.Professor;
import src.Aluno;

class Main {
    private static int opcao; // opção do menu
    private static int qtde = 0;  // quantidade de registros

    private static final int TAMANHO = 100;

    public static void main(String[] args) {        
        Scanner in = new Scanner(System.in);

        Professor[] professores = new Professor[TAMANHO];
        Aluno[] alunos = new Aluno[TAMANHO];

        do {
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
                    consultarSituacao();
                    break;
            }
        } while (opcao != 4);
        System.out.println("\nVolte sempre!");
    }

    private static void cadastrarProfessor() {
    }
    
    private static void cadastrarAluno() {
    }
    
    private static void consultarSituacao() {
    }

}