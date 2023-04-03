public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> t = new BinaryTree<Integer>();

        t.inserir(Integer.valueOf(15));
        t.inserir(Integer.valueOf(7));
        t.inserir(Integer.valueOf(29));
        t.inserir(Integer.valueOf(9));
        t.inserir(Integer.valueOf(21));
        t.inserir(Integer.valueOf(40));
        t.inserir(Integer.valueOf(20));
        t.inserir(Integer.valueOf(12));
        t.inserir(Integer.valueOf(39));

        System.out.println("\nPrint da arvore antes das remocoes:");
        t.printOrdenado();

        System.out.println("\nBuscas antes das remocoes:");
        System.out.println(t.find(Integer.valueOf(15)));
        System.out.println(t.find(Integer.valueOf(7)));
        System.out.println(t.find(Integer.valueOf(9)));
        System.out.println(t.find(Integer.valueOf(12)));
        System.out.println(t.find(Integer.valueOf(1)));


        t.delete(Integer.valueOf(7));
        t.delete(Integer.valueOf(15));
        t.delete(Integer.valueOf(21));
        t.delete(Integer.valueOf(40));
        t.delete(Integer.valueOf(20));
        t.delete(Integer.valueOf(39));

        System.out.println("\nPrint da arvore depois das remocoes:");
        t.printOrdenado();

        System.out.println("\nBuscas depois das remocoes:");
        System.out.println(t.find(Integer.valueOf(15)));
        System.out.println(t.find(Integer.valueOf(7)));
        System.out.println(t.find(Integer.valueOf(9)));
        System.out.println(t.find(Integer.valueOf(12)));
        System.out.println(t.find(Integer.valueOf(1)));
    }
}
