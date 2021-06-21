/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Eduardo, Jonatas
 */
public class BlocoNaoInteragivel extends Elemento {
    public BlocoNaoInteragivel(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        this.setbTransponivel(false);
    }
}
