/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase que implementa un árbol binario de búsqueda
 *  Fecha de creación: 14/03/2025
 *  Fecha de última modificación: 26/03/2025
 *  Fuentes: implementación de árbol binario de búsqueda recopilado de: https://www.geeksforgeeks.org/implementing-a-binary-tree-in-java/
 */

public class BinaryTree<K extends Comparable<K>, V> {
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

        int comparison = key.compareTo(root.getKey());

        if (comparison < 0) {
            root.setLeft(insertRec(root.getLeft(), key, value));
        } 
        
        else if (comparison > 0) {
            root.setRight(insertRec(root.getRight(), key, value));
        }

        else {
            root.setValue(value);
        }

        return root;
    }

    /**
     * Busca una clave en el árbol
     * @param key Clave a buscar
     * @return valor asociado a la clave o null si la clave no se encuentra en el árbol
     */
    public V search(K key) {
        return searchRec(root, key);
    }

    /**
     * Método recursivo para buscar una clave en el árbol
     * @param root Raíz del árbol
     * @param key Clave a buscar
     * @return valor asociado a la clave o null si la clave no se encuentra en el árbol
     */
    private V searchRec(Node<K, V> root, K key) {
        if (root == null) {
            return null;
        }

        int comparison = key.compareTo(root.getKey());

        if (comparison == 0) {
            return root.getValue();
        } 
        
        if (comparison < 0) {
            return searchRec(root.getLeft(), key);
        } 
        
        return searchRec(root.getRight(), key);
    } 

    /**
     * Recorre el árbol en orden
     */
    public void inOrder() {
        inOrderRec(root);
    }

    /**
     * Método recursivo para recorrer el árbol en orden
     * @param root Raíz del árbol
     */
    private void inOrderRec(Node<K, V> root) {
        if (root != null) {
            inOrderRec(root.getLeft());
            System.out.println(root.getKey() + " " + root.getValue());
            inOrderRec(root.getRight());
        }
    }
}