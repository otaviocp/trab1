package trab_poo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

/** Classe que lida com os principais comandos de um editor de texto.
* @author Daniel Pozzan
* @author Otavio Pontes
*/
public class Editor{
    private LinkedList<String> text;//o texto todo é guardado em uma lista encadeada
    private Stack<String> buff;//o 'buffer' é uma pilha que guarda as strings que receberem o comando desfazer.
    private StringBuilder sb;
    
    /** Cria a lista que contém o texto inserido pelo usuário e a pilha que contém o texto que recebe a ação de desfazer por parte do usuário. */
    public Editor(){
        text = new LinkedList<>();
        buff = new Stack<>();
    }
    
    /**Insere texto na lista encadeada
    * @param s String - Texto a ser inserido
    */
    public void insereTexto(String s){
        text.add(s);
    }
    
    /**Remove uma palavra da lista encadeada
     */
    public void removePalavra(){
        String aux = text.removeLast();//remove a string da lista
        
        aux = aux.substring(0, aux.lastIndexOf(" ")) + "";//remove a última palavra da string
        
        insereTexto(aux);//reinsere a string na lista
    }
    
    /**desfaz a última ação efetuada pelo usuário, inserindo a string na pilha.*/
    public void desfazer(){
        String s;
        s = text.removeLast();//retira a string da lista
        buff.push(s);//e a insere na pilha
    }
    
    /**Refaz a última ação desfeita, removendo a string da pilha.*/
    public void refazer(){
        String s;
        if(!buff.isEmpty()){
                 s = buff.pop();//retira a string da pilha
                 insereTexto(s);//e a insere na lista
        }else{
            System.out.println("Não é possível refazer!");
        }
    }
    
    /**Exibe o texto.*/
    public void exibir(){
        if(!text.isEmpty()){
        for(int i = 0; i < text.size(); i++)
            System.out.print(text.get(i));
        }
        
    }
    
    /**Limpa a pilha de desfazer/refazer.*/
    public void clearStack(){
        buff.clear();
    }
    
    /**Insere um caractere na última posição do texto.
    * @param c String - Caractere a ser inserido
    * @throws IOException - Se a string a ser inserida for maior que só um caractere.
    */
    public void insereC(String c) throws IOException{
        if(c.length()>1)
            throw new IOException("Nao eh caractere!");//utiliza-se string pela dificuldade de trabalhar com o tipo char
        String aux = text.removeLast();//retira a string da pilha
        sb = new StringBuilder(aux);
        sb.append(c);//utiliza-se o StringBuilder para concatenar o novo caractere
        String res = sb.toString();
        
        insereTexto(res);//e a reinsere com o novo caractere
    }
    
    /**Insere uma quebra de linha no texto.*/
    public void insereEnter(){
        insereTexto("\n");
    }
    
    /**Remove um caractere da última posição do texto.*/
    public void removeC(){
        String aux = text.removeLast();//remove a string da lista
        sb = new StringBuilder(aux);
        sb.deleteCharAt(aux.length()-1);//utiliza-se o StringBuilder para remover o ultimo caractere
        
        String res = sb.toString();
        if(!res.isEmpty())//se a string retornada não for vazia
            insereTexto(res);//ela é reinserida na lista
    }

    /**
     * Retorna o texto presente no nó presente no índice "aux" da lista encadeada.
     * @param aux int - Índice da lista.
     * @return Texto presente no nó.
     */
    public String retorna(int aux){
        if(aux < text.size())
            return text.get(aux);
        else
            return null;
    }
    
    /**
     * Retorna a lista encadeada que contém o texto do editor.
     * @return Lista encadeada com o texto do editor.
     */
    public LinkedList<String> getText() {
        return text;
    }

    /**
     * Coloca no editor uma lista encadeada com strings de texto.
     * @param text LinkedList - Recebe uma lista encadeada com o texto do editor.
     */
    public void setText(LinkedList<String> text) {
        this.text = text;
    }
    
    
    
}
