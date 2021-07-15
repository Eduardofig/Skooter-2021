public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> t = new BinaryTree<Integer>();

        for(int i = 5; i < 15; ++i) {
            t.inserir(i);
        }

        t.printOrdenado();

        System.out.println(t.find(5));
        System.out.println(t.find(9));
        System.out.println(t.find(11));
        System.out.println(t.find(12));
        System.out.println(t.find(1));

        t.delete(14);

        t.printOrdenado();
    }
}
