/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmcusp.exercicio5;

import java.io.Serializable;

/**
 *
 * @author jonat
 */
public class Filmes implements Serializable {
    String sNome;
    int ano;
    Filmes(String sANome, int Aano){
        sNome = sANome;
        ano = Aano;
    }
    
    public String toString(){
        return "Filme ( Titulo: " + sNome + "Ano de lancamento: " + ano + ")";
    }
}
