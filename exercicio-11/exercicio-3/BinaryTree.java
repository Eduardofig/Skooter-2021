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
            setRoot(new Node<T>(valor));
            return;
        }

        inserirRecursivo(getRoot(), valor);
    }

    void inserirRecursivo(Node<T> node, T valor) {
        if(valor.compareTo(node.getValor()) == 0) return;

        if(valor.compareTo(node.getValor()) > 0) {
            if(node.getRight() == null) {
                node.setRight(new Node<T>(valor));
                return;
            }
            inserirRecursivo(node.getRight(), valor);
            return;
        }

        if(node.getLeft() == null) {
            node.setLeft(new Node<T>(valor));
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

    BinaryTree() {
        setRoot(null);
    }
}
