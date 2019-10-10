package trab_poo;

import java.io.IOException;
import static java.lang.System.*;
import java.util.Scanner;

public class Trab_POO{
    public static void main(String[] args) throws IOException {
        int opt;
        String s;
        Scanner l = new Scanner(in);
        Editor ed = new Editor();
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
            out.print(">>");
            opt = l.nextInt();
            
            switch(opt)
            {
                case 1:
                    ed.clearStack();
                    ed.exibir();
                    l.nextLine();
                    s = l.nextLine();
                    ed.insereTexto(s);
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
                    ed.removeTexto();
                    break;
                    
                case 8:
                    ed.exibir();
                    System.out.print("\n");
                    break;   
            }
        }while(opt != 0);
    }
}
