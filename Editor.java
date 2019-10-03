package Trab_POO;
import java.util.*;

public class Editor {
    private LinkedList<String> text;
    private Stack<String> buff;
    
    public Editor(){
        text = new LinkedList<>();
        buff = new Stack<>();
    }
    
    public void insereTexto(String s){
        text.add(s);
    }
    
    public void desfazer(){
        String s;
        s = text.removeLast();
        buff.push(s);
    }
    
    public void refazer(){
        String s;
        if(!buff.isEmpty()){
                 s = buff.pop();
                 insereTexto(s);   
        }else{
            System.out.println("nao eh possivel refazer!");
        }
    }
    
    public void exibir(){
        for(int i = 0; i<text.size();i++)
            System.out.print(text.get(i));
    }
    
    public void clear_list(){
        buff.clear();
    }
}
