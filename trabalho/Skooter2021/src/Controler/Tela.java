package Controler;

import Modelo.*;
import Auxiliar.*;
import Data.Fases;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.util.zip.*;
import javax.swing.JFileChooser;

/**
 *
 * @author Eduardo, Jonatas
 */

 public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

     private FasesWrapper fWrapper;
     private ControleDeJogo cControle = new ControleDeJogo();
     private Graphics g2;
     private Hero hHero;
     private CaixaComandos cComandos;
     private ChamaAutoSave asJogo;
     /**
      * Creates new form
      */
     public Tela() {
         this.fWrapper = new FasesWrapper();
         this.fWrapper.loadFases(new Fases());
         this.cComandos = new CaixaComandos();
         this.cComandos.recebeFases(this.fWrapper);
         //this.asJogo = new ChamaAutoSave(this.fWrapper,2000);


         Desenhador.setCenario(this); /*Desenhador funciona no modo estatico*/
         initComponents();

         this.addMouseListener(this); /*mouse*/
         this.addKeyListener(this);   /*teclado*/

         /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
         this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                 Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

     }

/*--------------------------------------------------*/
    public Graphics getGraphicsBuffer(){
        return g2;
    }

    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/
    public void paint(Graphics gOld) {
        Fases fFases = this.fWrapper.getFases();
        Graphics g = this.getBufferStrategy().getDrawGraphics();

        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    /*Linha para alterar o background*/
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "background.png");
                    g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        /*Aqui podem ser inseridos novos processamentos de controle*/
        this.cControle.processaTudo(fFases);
        this.cControle.desenhaTudo(fFases);

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };

        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    public void keyPressed(KeyEvent e) {
        this.hHero = this.fWrapper.getFases().getHeroAtual();
        /*Movimento do heroi via teclado*/
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.hHero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.hHero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.hHero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.hHero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            this.fWrapper.getFases().getFaseAtual().reset();
        } else if(e.getKeyCode() == KeyEvent.VK_Z) {
            if(this.hHero.removerBloco(this.fWrapper.getFases().getFaseAtual().getBlocosInteragiveis(), this.fWrapper.getFases().getFaseAtual().getElementos()))
                this.cControle.sSoundFx.destroiBlocoSound();
        } else if(e.getKeyCode() == KeyEvent.VK_P) {
            this.fWrapper.getFases().togglePause();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.cComandos.run();
        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            this.fWrapper.getFases().passarDeFase();
        }


        this.setTitle("-> Cell: " + (this.hHero.getPosicao().getColuna()) + ", " + (this.hHero.getPosicao().getLinha()));
    }

    public void mousePressed(MouseEvent e) {
         //Movimento via mouse
         int x = e.getX();
         int y = e.getY();

         this.setTitle("X: "+ x + ", Y: " + y +
                 " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));

         //this.hHero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);

         /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
         //Processa as colisoes dos blocos interagiveis e dos inimigos

         repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 561, Short.MAX_VALUE)
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 500, Short.MAX_VALUE)
                );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        Posicao pPosicao = new Posicao(e.getY()/Consts.CELL_SIDE, e.getX()/Consts.CELL_SIDE);
        this.fWrapper.getFases().getFaseAtual().removerElementoPosicao(pPosicao);

        this.fWrapper.getFases().togglePause();

        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                FileInputStream ifStream = new FileInputStream(chooser.getSelectedFile());
                ObjectInputStream oStream = new ObjectInputStream(ifStream);

                ElementoGenerico eGenerico = (ElementoGenerico)oStream.readObject();
                //Checar se funciona
                eGenerico.setPosicao(e.getY()/Consts.CELL_SIDE, e.getX()/Consts.CELL_SIDE);

                this.fWrapper.getFases().getFaseAtual().addElementoGenerico(eGenerico);

                System.out.println(eGenerico.getClass().getName() + " Adicionado ao jogo em (" +
                        String.valueOf(eGenerico.getPosicao().getColuna()) + "," + String.valueOf(eGenerico.getPosicao().getLinha()) + ")");

                this.fWrapper.getFases().togglePause();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
