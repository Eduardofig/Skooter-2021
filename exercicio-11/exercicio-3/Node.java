public class Node<T extends Comparable> {
    private Node<T> right;
    private Node<T> left;
    private Node<T> parent;
    private T valor;
    
    T getValor() {
        return this.valor;
    }

    void setValor(T sValor)
    {
        this.valor = sValor;
    }

    Node<T> getRight() {
        return this.right;
    }

    void setRight(Node<T> sRight)
    {
        this.right = sRight;
    }

    Node<T> getLeft() {
        return this.left;
    }

    void setLeft(Node<T> sLeft)
    {
        this.left = sLeft;
    }

    Node<T> getParent() {
        return this.parent;
    }

    void setParent(Node<T> sParent)
    {
        this.parent = sParent;
    }

    Node(T sValor, Node<T> sParent)
    {
        setValor(sValor);
        setRight(null);
        setLeft(null);
        setParent(sParent);
    }
}
