public class BinaryTree<T extends Comparable> {

    Node<T> root;

    private Node<T> getRoot() {
        return this.root;
    }

    private void setRoot(Node<T> sRoot) {
        this.root = sRoot;
    }

    void inserir(T valor) {
        if(this.root == null) {
            setRoot(new Node<T>(valor, null));
            return;
        }

        inserirRecursivo(getRoot(), valor);
    }

    private void inserirRecursivo(Node<T> node, T valor) {
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

    private void printRecursivo(Node<T> node) {
        if(node == null) return;

        printRecursivo(node.getLeft());
        System.out.println(node.getValor());
        printRecursivo(node.getRight());
    }

    boolean find(T valor) {
        if(getRoot() == null) return false;

        return findRecursivo(getRoot(), valor) != null;
    }

    private Node<T> findRecursivo(Node<T> node, T valor) {
        if(node == null) return null;

        if(node.getValor().equals(valor)) return node;

        if(node.getValor().compareTo(valor) < 0)
            return findRecursivo(node.getRight(), valor);

        return findRecursivo(node.getLeft(), valor);
    }

    private Node<T> findMinimum(Node<T> subtree) {
        Node<T> node = subtree;
        while(node.getLeft() != null) node = node.getLeft();
        return node;
    }

    private void deleteNode(Node<T> target) {

        Node<T> targetParent = target.getParent();
        T valor = target.getValor();
        
        //Remocao da raiz
        if(target == getRoot()) {
            setRoot(target.getRight());
            getRoot().setLeft(target.getLeft());
            return;

        }

        //Remocao de folha
        if(target.getNumFilhos() == 0) {

            if(targetParent.getValor().compareTo(valor) < 0) targetParent.setRight(null);
            else targetParent.setLeft(null);

            return;
        }

        //Remocao de no com 1 filho
        if(target.getNumFilhos() == 1) {

            if(targetParent.getValor().compareTo(valor) < 0) {
                if(target.getRight() != null) targetParent.setRight(target.getRight());
                else targetParent.setRight(target.getLeft());
            } else {
                if(target.getRight() != null) targetParent.setLeft(target.getRight());
                else targetParent.setLeft(target.getLeft());
            }

            return;
        }

        //Remocao de no com 2 filhos
        Node<T> minimum = findMinimum(target.getRight());
        deleteNode(minimum);
        target.setValor(minimum.getValor());

    }

    void delete(T valor) {
        if(getRoot() == null) return;

        Node<T> target = findRecursivo(getRoot(), valor);

        if(target == null) return;

        deleteNode(target);
    }

    BinaryTree() {
        setRoot(null);
    }
}
