/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpoo;
import java.io.IOException;
import static java.lang.System.*;
import java.util.Scanner;

public class Trab_POO {
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
            out.println("6 - Remove palavra");
            out.println("7 -  Exibir texto");
            out.println(">>");
            opt = l.nextInt();
            
            switch(opt)
            {
                case 1:
                    ed.clear_list();
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
                    ed.removeTexto();
                    break;
                    
                case 7:
                    ed.exibir();
                    break;   
            }
        }while(opt != 0);
    }
}
