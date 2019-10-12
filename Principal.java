package trab_poo;

import java.io.File;
import java.io.IOException;
import static java.lang.System.*;
import java.util.Scanner;

/**Classe principal do trabalho; contém menu principal.
 * @author Daniel Pozzan
 * @author Otávio Pontes
 * @since 11/10/2019
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        int opt;
        String opt1;
        String s;
        Scanner l = new Scanner(in);//utilizado para ler inteiros
        Scanner l1 = new Scanner(in);//utilizado para ler strings
        Editor ed = new Editor();
        Arquivo arq = new Arquivo();
        File arquivo = new File("texto.txt");

        System.out.println("Deseja carregar um arquivo?");
        System.out.println("Sim - 1");
        System.out.println("Nao - Outra tecla");

        opt1 = l1.nextLine();

        if(opt1.equals("1"))
            ed.setText(arq.ler(arquivo));

        do{
            out.println("<<EDITOR DE TEXTO>>");
            out.println("1 - Inserir texto");
            out.println("2 - Desfazer");
            out.println("3 - Refazer");
            out.println("4 - Inserir caractere");
            out.println("5 - Remove caractere");
            out.println("6 - Inserir quebra de linha");
            out.println("7 - Remove palavra");
            out.println("8 -  Exibir texto");
            out.println("0 - Sair");
            out.print(">>");
            opt = l.nextInt();

            switch(opt)
            {
                case 1:
                    ed.clearStack();//a pilha de desfazer/refazer sempre é limpa antes de inserir mais texto
                    System.out.println("******************************EDITOR*****************************");
                    ed.exibir();
                    l.nextLine();
                    s = l.nextLine();
                    ed.insereTexto(s);
                    System.out.println("*****************************************************************");
                    break;

                case 2:
                    ed.desfazer();
                    break;

                case 3:
                    ed.refazer();
                    break;

                case 4:
                    l.nextLine();
                    s = l.nextLine();
                    ed.insereC(s);
                    break;

                case 5:
                    ed.removeC();
                    break;

                case 6:
                    ed.insereEnter();
                    break;
                    
                case 7:
                    ed.removePalavra();
                    break;

                case 8:
                    System.out.println("******************************TEXTO*****************************");
                    ed.exibir();
                    System.out.println("");
                    System.out.println("*****************************************************************");
                    System.out.print("\n");
                    System.out.println("Deseja salvar o texto?");
                    System.out.println("Sim - 1");
                    System.out.println("Nao - Outra tecla");

                    opt1 = l1.nextLine();

                    if(opt1.equals("1"))
                         arq.gravar(ed);

                    break;   
            }
        }while(opt != 0);//repete enquanto o usuário não apertar a tecla de sair
    }
}