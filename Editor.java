package trab_poo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

/** Classe que lida com os principais comandos de um editor de texto.
* @author Daniel Pozzan
* @author Otavio Pontes
*/
public class Editor{
    private LinkedList<String> text;
    private Stack<String> buff;
    private StringBuilder sb;
    
    /** O construtor cria a lista que contém o texto inserido pelo usuário e a pilha que contém o texto que recebe a ação de desfazer por parte do usuário. */
    public Editor(){
        text = new LinkedList<>();
        buff = new Stack<>();
    }
    
    /**Método para inserir texto na lista encadeada
    * @param s String - Texto a ser inserido
    */
    public void insereTexto(String s){
        text.add(s);
    }
    
    /**Método para remover uma palavra da lista encadeada*/
    public void removePalavra(){
        String aux = text.removeLast();
        
        aux = aux.substring(0, aux.lastIndexOf(" ")) + "";
        
        insereTexto(aux);
    }
    
    /**Método para desfazer a última ação efetuada pelo usuário, inserindo a string na pilha.*/
    public void desfazer(){
        String s;
        s = text.removeLast();
        buff.push(s);
    }
    
    /**Método para refazer a última ação desfeita, removendo a string da pilha.*/
    public void refazer(){
        String s;
        if(!buff.isEmpty()){
                 s = buff.pop();
                 insereTexto(s);   
        }else{
            System.out.println("Não é possível refazer!");
        }
    }
    
    /**Método para exibir o texto.*/
    public void exibir(){
        for(int i = 0; i < text.size(); i++)
            System.out.print(text.get(i));
        
    }
    
    /**Método para limpar a pilha de desfazer/refazer.*/
    public void clearStack(){
        buff.clear();
    }
    
    /**Método para inserir um caractere na última posição do texto.
    * @param c String - Caractere a ser inserido
    * @throws IOException - Se a string a ser inserida for maior que só um caractere
    */
    public void insereC(String c) throws IOException{
        if(c.length()>1)
            throw new IOException("Nao eh caractere!");
        String aux = text.removeLast();
        sb = new StringBuilder(aux);
        sb.append(c);
        String res = sb.toString();
        
        insereTexto(res);
    }
    
    /**Método para inserir uma quebra de linha no texto.*/
    public void insereEnter(){
        insereTexto("\n");
    }
    
    /**Método para remover um caractere da última posição do texto.*/
    public void removeC(){
        String aux = text.removeLast();
        sb = new StringBuilder(aux);
        sb.deleteCharAt(aux.length()-1);
        
        String res = sb.toString();
        
        if(!res.isEmpty())
            insereTexto(res);
    }

    public String retorna(int aux){
        if(aux < text.size())
            return text.get(aux);
        else
            return null;
    }
    
    public LinkedList<String> getText() {
        return text;
    }

    public void setText(LinkedList<String> text) {
        this.text = text;
    }
    
    
    
}
