import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Point;

public class JanelaThread extends Thread {
    protected int i;
    protected boolean running;
    protected JFrame jfTela;
    protected JLabel jlTexto;

    public void run() {
        i = 0;
        running = true;
        //Criacao do JFrame
        jfTela = new JFrame();
        jfTela.setSize(new Dimension(200, 200));
        jfTela.setLayout(new BorderLayout());
        jfTela.setVisible(true);

        //Criacao do JLabel
        jlTexto = new JLabel();
        Dimension sizeFrame = jlTexto.getPreferredSize();
        jlTexto.setSize(sizeFrame);
        jlTexto.setHorizontalAlignment(SwingConstants.CENTER);
        jlTexto.setVerticalAlignment(SwingConstants.CENTER);
        jlTexto.setFont(new Font("Serif", Font.PLAIN, 200));

        //A cada 1000 millisegundos eh atualizado o contador do JFrame
        while(running) {
            try {
                jlTexto.setText(String.valueOf(i++));
                jfTela.add(jlTexto);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        running = false;
        jfTela.dispose();
    }

    public void reset() {
        i = 0;
        jlTexto.setText(String.valueOf(i++));
        jfTela.add(jlTexto);
    }

    public void setBold() {
        jlTexto.setFont(jlTexto.getFont().deriveFont(jlTexto.getFont().getStyle() ^ Font.BOLD));
        jfTela.add(jlTexto);
    }

    public JanelaThread() {
        start();
    }
}

