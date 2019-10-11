
package trab_poo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class Arquivo{
    FileWriter outputStream = null;
    FileReader inputStream = null;
    private static File arquivo;
    private Editor edit;
   
    public void gravar(Editor ed) throws FileNotFoundException, IOException{        
        try {
            arquivo = new File ("texto.txt");
            if (!arquivo.exists()) {
                //cria um arquivo (vazio)
                arquivo.createNewFile();
                }
             outputStream = new FileWriter(arquivo);
             String l;
             int aux = 0;
             while (ed.retorna(aux) != null) {
                outputStream.write(ed.retorna(aux));
                aux++;
            }
        } catch (IOException ex) {
            System.err.println("Erro ao salvar!");
        
        } finally {
            if (outputStream != null) {
            outputStream.close();
            }
        }
    }
    
     public LinkedList ler(File arquivo) throws FileNotFoundException, IOException{
         edit = new Editor();
         try {
            inputStream = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(inputStream);
            String linha;

            while (br.ready()) {
             linha = br.readLine();
             if(!linha.isEmpty())
                 edit.insereTexto(linha);
            } 
                return edit.getText();    
        }catch (IOException e) {
            System.err.println("Erro na leitura!");
            return null;
        }finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        
    }
} 

