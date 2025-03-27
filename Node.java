/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase que representa un nodo de un árbol binario de búsqueda
 *  Fecha de creación: 14/03/2025
 *  Fecha de última modificación: 26/03/2025
 */


public class Node<K,V> {

    private K key;
    private V value;
    private Node<K,V> left;
    private Node<K,V> right;

    /**
     * Constructor de la clase Node
     * @param key Clave del nodo
     * @param value Valor del nodo
     */
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Obtiene la clave del nodo
     * @return Clave del nodo
     */
    public K getKey() {
        return key;
    }

    /**
     * Obtiene el valor del nodo
     * @return Valor del nodo
     */
    public V getValue() {
        return value;
    }

    /**
     * Obtiene el hijo izquierdo del nodo
     * @return Hijo izquierdo del nodo
     */
    public Node<K,V> getLeft() {
        return left;
    }

    /**
     * Obtiene el hijo derecho del nodo
     * @return Hijo derecho del nodo
     */
    public Node<K,V> getRight() {
        return right;
    }

    /**
     * Establece la clave del nodo
     * @param key Clave del nodo
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Establece el valor del nodo
     * @param value Valor del nodo
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Establece el hijo izquierdo del nodo
     * @param left Hijo izquierdo del nodo
     */
    public void setLeft(Node<K,V> left) {
        this.left = left;
    }

    /**
     * Establece el hijo derecho del nodo
     * @param right Hijo derecho del nodo
     */
    public void setRight(Node<K,V> right) {
        this.right = right;
    }

}