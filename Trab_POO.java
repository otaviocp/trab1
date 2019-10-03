/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trab_POO;
import static java.lang.System.*;
import java.util.Scanner;

public class Trab_POO {
    public static void main(String[] args) {
        int opt;
        String s;
        Scanner l = new Scanner(in);
        Editor ed = new Editor();
        do{
            out.println("<<EDITOR DE TEXTO>>");
            out.println("1 - Inserir texto");
            out.println("2 - Desfazer");
            out.println("3 - Refazer");
            out.println("4 - Remove caractere");
            out.println("5 - Remove palavra");
            out.println("6 -  Exibir texto");
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
                    break;
                    
                case 5:
                    break;
                    
                case 6:
                    ed.exibir();
                    break;
                       
            }
            
        }while(opt != 0);
    }

}
