import java.util.Scanner;
import java.util.ArrayList;

public class Afazeres {
    public static void main(String[] args) throws InterruptedException {

        /*Lista de tarefas:
         * Adicionar novas tarefas
         * Visualizar tarefas
         * Deletar tarefas
         * Atualizar tarefas(marcar como concluídas)*/

        ArrayList<String> tarefas = new ArrayList<>();
        Scanner scan = new Scanner(System.in);


        int option;
        do {
            System.out.println("  LISTA DE TAREFAS   ");
            System.out.println("---------------------");
            System.out.println("Selecione uma opção: ");
            System.out.println("1- Adicionar tarefas ");
            System.out.println("2- Visualizar a lista");
            System.out.println("3- Atualizar tarefas ");
            System.out.println("4- Deletar uma tarefa");
            System.out.println("5- Sair");
            System.out.println("---------------------");

            while (!scan.hasNextInt()) {  // valida entrada de opção
                System.out.println("Opção inválida, por favor digite um número: ");
                scan.next();
            }
            option = scan.nextInt();
            scan.nextLine(); // limpa o buffer

            switch (option) {
                case 1:
                    System.out.println("Digite uma tarefa para adicionar: ");
                    String addTarefa = scan.nextLine();
                    tarefas.add(addTarefa);
                    System.out.println("Tarefa adicionada com sucesso: " + addTarefa);
                    break;
                case 2:
                    System.out.println("Número de tarefas: " + tarefas.size());
                    System.out.println("==========================");
                    /*função para printar as tarefas*/
                    for (String tarefa : tarefas) {
                        System.out.println(tarefa);
                    }
                /* for(int i =0; i < tarefas.size(); i++){
                    System.out.println(tarefas.get(i));
                }*/
                    break;
                case 3:
                    System.out.println("Digite o índice da tarefa que deseja marcar como concluída (de 0 a " + (tarefas.size() - 1) + "): ");
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa disponível para atualizar.");
                    } else {
                        while (!scan.hasNextInt()) {
                            System.out.println("Por favor, digite um número válido: ");
                            scan.next();
                        }
                        int idx = scan.nextInt();
                        scan.nextLine(); // limpa o buffer
                        if (idx >= 0 && idx < tarefas.size()) {
                            System.out.println("Tarefa \"" + tarefas.get(idx) + "\" marcada como concluída!");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;
                case 4:
                    //Adicionar validaçao se existe o indice
                    System.out.println("Digite o índice da tarefa que deseja deletar (de 0 a " + (tarefas.size() - 1) + "): ");
                    if(tarefas.isEmpty()){
                        System.out.println("Nenhuma tarefa disponível para deletar");
                    } else {
                        while (!scan.hasNextInt()){
                            System.out.println("Digite um número válido: ");
                        }
                        int deletarTarefa = scan.nextInt();
                        scan.nextLine();
                        if (deletarTarefa >= 0 && deletarTarefa < tarefas.size()){
                            System.out.println("Tarefa deletada: "+tarefas.remove(deletarTarefa));
                        }else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    Thread.sleep(500);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (option != 5);


        scan.close();
    }
}
