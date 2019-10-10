package trabpoo;
import java.io.IOException;
import java.util.*;

public class Editor{
    private LinkedList<String> text;
    private Stack<String> buff;
    private StringBuilder sb;
    
    public Editor(){
        text = new LinkedList<>();
        buff = new Stack<>();
    }
    
    
    public void insereTexto(String s){
        text.add(s);
    }
    
    public void removeTexto(){
        text.removeLast();
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
            System.out.println("Não é possível refazer!");
        }
    }
    
    public void exibir(){
        for(int i = 0; i<text.size();i++)
            System.out.print(text.get(i));
        
        System.out.println("");
    }
    
    public void clear_list(){
        buff.clear();
    }
    
    public void insereC(String c) throws IOException{
        if(c.length()>1)
            throw new IOException("Nao e caractere!");
        String aux = text.removeLast();
        sb = new StringBuilder(aux);
        sb.append(c);
        String res = sb.toString();
        
        insereTexto(res);
    }
    
    public void removeC(){
        String aux = text.removeLast();
        sb = new StringBuilder(aux);
        sb.deleteCharAt(aux.length()-1);
        
        String res = sb.toString();
        
        insereTexto(res);
    }
}
