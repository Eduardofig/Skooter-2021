public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> t = new BinaryTree<Integer>();

        t.inserir(15);
        t.inserir(7);
        t.inserir(29);
        t.inserir(9);
        t.inserir(15);
        t.inserir(21);
        t.inserir(40);
        t.inserir(20);
        t.inserir(12);
        t.inserir(39);
        

        t.printOrdenado();

        System.out.println(t.find(15));
        System.out.println(t.find(7));
        System.out.println(t.find(9));
        System.out.println(t.find(12));
        System.out.println(t.find(1));

        t.delete(7);
        t.delete(21);
        t.delete(40);
        t.delete(20);
        t.delete(39);

        t.printOrdenado();
    }
}
