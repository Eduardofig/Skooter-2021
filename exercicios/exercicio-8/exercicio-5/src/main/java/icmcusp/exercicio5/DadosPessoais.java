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
public class DadosPessoais implements Serializable{
    String rua;
    int numero;
    String cep;
    String cidade;
    String uf;
    DadosPessoais(String arua, int anumero, String acep, String acidade, String auf){
        rua = arua;;
        numero = anumero;
        cep = acep;
        cidade = acidade;
        uf = auf;
    }
    
    public String toString(){
        return "Dados pessoais ( Rua: "+ rua + "," + numero + "," + cep + "," + cidade + "-" + uf + ")";
    }
}
