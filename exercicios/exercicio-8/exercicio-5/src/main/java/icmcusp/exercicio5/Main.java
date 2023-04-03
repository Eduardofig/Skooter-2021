/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmcusp.exercicio5;

/**
 *
 * @author jonat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileClass fcTemp = new FileClass();
        
        
        System.out.println("OS OBJETOS FORAM CRIADOS E COMPACTADOS COM SUCESSO...\n");
        System.out.println("DESCOMPACTANDO E LENDO AS INFORMACOES DOS OBJETOS:");
        fcTemp.EscritaDeObjetosCompacta("..\\POO-objects");
        fcTemp.LeituraDeObjetosCompactos("..\\POO-objects.zip");
        System.out.println("\n" + "\n" + "\n");
         
    }
}