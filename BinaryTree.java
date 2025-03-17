/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase que implementa un árbol binario de búsqueda
 *  Fecha de creación: 14/03/2025
 *  Fecha de última modificación: 16/03/2025
 *  Fuentes: implementación de árbol binario de búsqueda recopilado de: https://www.geeksforgeeks.org/implementing-a-binary-tree-in-java/
 */

public class BinaryTree<K, V> {
    private Node<K, V> root;

    public BinaryTree() {
        root = null;
    }

    /**
     * Inserta un nuevo nodo en el árbol
     * @param key Clave del nodo
     * @param value Valor del nodo
     */
    public void insert(K key, V value) {
        root = insertRec(root, key, value);
    }

    /**
     * Método recursivo para insertar una clave en el árbol
     * @param root Raíz del árbol
     * @param key Clave del nodo
     * @param value Valor del nodo
     * @return Raíz del árbol
     */
    private Node<K, V> insertRec(Node<K, V> root, K key, V value) {
        if (root == null) {
            root = new Node<K, V>(key, value);
            return root;
        }

        if (key.hashCode() < root.getKey().hashCode()) {
            root.setLeft(insertRec(root.getLeft(), key, value));
        } 
        
        else if (key.hashCode() > root.getKey().hashCode()) {
            root.setRight(insertRec(root.getRight(), key, value));
        }

        return root;
    }

    /**
     * Busca una clave en el árbol
     * @param key Clave a buscar
     * @return true si la clave se encuentra en el árbol, false en caso contrario
     */
    public boolean search(K key) {
        return searchRec(root, key);
    }

    /**
     * Método recursivo para buscar una clave en el árbol
     * @param root Raíz del árbol
     * @param key Clave a buscar
     * @return true si la clave se encuentra en el árbol, false en caso contrario
     */
    private boolean searchRec(Node<K, V> root, K key) {
        if (root == null) {
            return false;
        }

        if (key.hashCode() == root.getKey().hashCode()) {
            return true;
        }

        if (key.hashCode() < root.getKey().hashCode()) {
            return searchRec(root.getLeft(), key);
        }
        
        else {
            return searchRec(root.getRight(), key);
        }
    } 
}