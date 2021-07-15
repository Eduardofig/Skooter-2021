import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Double> t = new BinaryTree<Double>();

        for(int i = 0; i < 10; ++i) {
            t.inserir(new Double(Math.random()));
        }

        t.printOrdenado();
    }
}
