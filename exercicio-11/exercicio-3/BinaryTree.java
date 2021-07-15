public class BinaryTree<T extends Comparable> {
    Node<T> root;

    Node<T> getRoot() {
        return this.root;
    }

    void setRoot(Node<T> sRoot) {
        this.root = sRoot;
    }

    void inserir(T valor) {
        if(this.root == null) {
            setRoot(new Node<T>(valor, null));
            return;
        }

        inserirRecursivo(getRoot(), valor);
    }

    void inserirRecursivo(Node<T> node, T valor) {
        if(valor.compareTo(node.getValor()) == 0) return;

        if(valor.compareTo(node.getValor()) > 0) {
            if(node.getRight() == null) {
                node.setRight(new Node<T>(valor, node));
                return;
            }
            inserirRecursivo(node.getRight(), valor);
            return;
        }

        if(node.getLeft() == null) {
            node.setLeft(new Node<T>(valor, node));
            return;
        }

        inserirRecursivo(node.getLeft(), valor);
    }

    void printOrdenado() {
        if(getRoot() == null) return;
        
        printRecursivo(getRoot());
    }

    void printRecursivo(Node<T> node) {
        if(node == null) return;

        printRecursivo(node.getLeft());
        System.out.println(node.getValor());
        printRecursivo(node.getRight());
    }

    boolean find(T valor) {
        if(getRoot() == null) return false;

        return findRecursivo(getRoot(), valor) != null;
    }

    Node<T> findRecursivo(Node<T> node, T valor) {
        if(node == null) return null;

        if(node.getValor().equals(valor)) return node;

        if(node.getValor().compareTo(valor) < 0)
            return findRecursivo(node.getRight(), valor);

        return findRecursivo(node.getLeft(), valor);
    }

    BinaryTree() {
        setRoot(null);
    }
}
