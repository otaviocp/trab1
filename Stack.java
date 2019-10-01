/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author danielpozzan
 */
public class Stack {
    private String[] pilha;
    private int pos;
 
    public Stack()
    {
        pos = -1; // pilha vazia
        pilha = new String[1000];
    }
    
    public boolean isEmpty()
    {
        return pos == -1;
    }
    
    public int stackSize()
    {
        if(isEmpty())
            return 0;
        
        else
            return (pos+1);
    }
    
    public void push(String s)
    {
        if(pos < (stackSize() - 1))
            pilha[++pos] = s;
        
    }
    
    public String pop()
    {
        if(isEmpty())
            return null;
        
        return pilha[pos--];
    }
    
}
