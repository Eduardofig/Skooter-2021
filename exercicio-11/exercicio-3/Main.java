import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> t = new BinaryTree<Integer>();

        for(int i = 0; i < 10; ++i) {
            t.inserir(Integer.valueOf(i));
        }

        t.printOrdenado();

        System.out.println(t.find(5));
        System.out.println(t.find(8));
        System.out.println(t.find(11));
        System.out.println(t.find(12));
        System.out.println(t.find(1));
    }
}
