public class Node<T> {
    private Node<T> right;
    private Node<T> left;
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

    void setRight(T sRight)
    {
        this.right = sRight;
    }

    Node<T> getLeft() {
        return this.left;
    }

    void setLeft(T sLeft)
    {
        this.left = sLeft;
    }

    Node(T sValor)
    {
        setValor(sValor);
        setRight(null);
        setLeft(null);
    }
}
