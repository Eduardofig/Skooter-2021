package Modelo;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import Auxiliar.FasesWrapper;
import Save.*;

import Data.Fases;

/**
 *
 * @author Eduardo, Jonatas
 */

public class CaixaComandos extends JFrame implements ActionListener{
  private FasesWrapper fWrapper;

  JButton bt1 = new JButton("Iniciar/Pausar");
  JButton bt2 = new JButton("Salvar");
  JButton bt3 = new JButton("Carregar");
  JButton bt4 = new JButton("Quit");

  public void recebeFases(FasesWrapper sWrapper){
    this.fWrapper = sWrapper;
  }

  public void run(){
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    bt3.addActionListener(this);
    bt4.addActionListener(this);
    setLayout(null); //define que nenhum layout vai ser usado
    bt1.setBounds(0,0,224,60);
    bt2.setBounds(0,60,224,60);
    bt3.setBounds(0,120,224,60);
    bt4.setBounds(0,180,224,60);
    add(bt1);
    add(bt2);
    add(bt3);
    add(bt4);
    setTitle("POO2021");
    setSize(240,279);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
  }

  Salvar sJogo = new Salvar();
  ChamaAutoSave asJogo = new ChamaAutoSave();



  public void actionPerformed(ActionEvent e){
    if(e.getSource()==bt1){

      this.fWrapper.getFases().togglePause();
      //asJogo.iniciaAutoSave(this.fWrapper.getFases());
      //asJogo.run();
    }else if(e.getSource()==bt2){ //salvar
      //FileClass fcTemp = new FileClass();

      sJogo.salvarFase(this.fWrapper.getFases());

      //if(fFase.getFaseAtual==0){}
    }else if(e.getSource()==bt3){ //carregar
      sJogo.carregarFase(this.fWrapper);

    }else if(e.getSource()==bt4){
      //aSave.encerrarAutoSave();
      System.exit(0);
    }
  }
}
