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
public class Editor {
    private Stack text;
    private Stack buff;
    
    public Editor()
    {
        text = new Stack();
        buff = new Stack();
    }
    
    public void insereTexto(String s)
    {
        text.push(s);
    }
    
    public void desfazer()
    {
        String s;
        s = text.pop();
        buff.push(s);
    }
    
    public void refazer()
    {
        String s;
        s = buff.pop();
        insereTexto(s);
    }
}
