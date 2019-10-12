
package trab_poo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Classe que lida com a criação e leitura de arquivos.
 * @author Otávio Pontes
 * @since 11/10/2019
 */
public class Arquivo{
    FileWriter outputStream = null;
    FileReader inputStream = null;
    private static File arquivo;
    private Editor edit;
   
    /**
     * Realiza a escrita em arquivo do texto inserido pelo usuário.
     * @param ed Editor - Recebe a lista com o texto inserido pelo usuário.
     * @throws FileNotFoundException - Arquivo não encontrado.
     * @throws IOException - Erro ao salvar.
     */
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
    
    /**
     * Lê do arquivo e retorna uma lista encadeada com as strings presentes nele.
     * @param arquivo File - Arquivo a ser lido.
     * @return 
     * @throws FileNotFoundException
     * @throws IOException 
     */
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

