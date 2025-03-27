/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase principal que ejecuta el programa
 *  Fecha de creación: 22/03/2025
 *  Fecha de última modificación: 26/03/2025
 */

import java.util.Scanner;

public class StoreManager {
    private BinaryTree<String, Product> btSKU;
    private BinaryTree<String, Product> btName;
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor de la clase StoreManager
     * @param btSKU Árbol binario de búsqueda por SKU
     * @param btName Árbol binario de búsqueda por nombre
     */
    public StoreManager(BinaryTree<String, Product> btSKU, BinaryTree<String, Product> btName) {
        this.btSKU = btSKU;
        this.btName = btName;
    }

    /**
     * Busca un producto en los árboles binarios
     */
    public void searchProduct() {
        System.out.println("¿Cómo deseas buscar el producto?");
        System.out.println("1. Por SKU");
        System.out.println("2. Por nombre");
        String option = scanner.nextLine();
        
        if (option.equals("1")) {
            System.out.print("Ingresa el SKU del producto: ");
            String SKU = scanner.nextLine();
            Product product = btSKU.search(SKU);
            if (product != null) {
                System.out.println("Producto encontrado: " + product);
            } 
            
            else {
                System.out.println("Producto no encontrado");
            }
        } 
        
        else if (option.equals("2")) {
            System.out.print("Ingresa el nombre del producto: ");
            String name = scanner.nextLine();
            Product product = btName.search(name);
            if (product != null) {
                System.out.println("Producto encontrado: " + product);
            } 
            
            else {
                System.out.println("Producto no encontrado");
            }
        } 
        
        else {
            System.out.println("Opción inválida");
        }
    }

    /**
     * Agrega un nuevo producto a los árboles binarios
     */
    public void addProduct() {
        System.out.print("Ingresa el SKU del producto: ");
        String SKU = scanner.nextLine();
        if (btSKU.search(SKU) != null) {
            System.out.println("El SKU ya existe");
            return;
        }
        System.out.print("Ingresa el nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Ingresa la descripción del producto: ");
        String description = scanner.nextLine();
        System.out.print("Ingresa las tallas del producto: ");
        String sizes = scanner.nextLine();
        Product product = new Product(SKU, name, description, Product.parseSizes(sizes));
        btSKU.insert(SKU, product);
        btName.insert(name, product);
    }

    /**
     * Edita un producto existente en los árboles binarios
     */
    public void editProduct() {
        System.out.print("Ingresa el SKU del producto a editar: ");
        String SKU = scanner.nextLine();
        Product product = btSKU.search(SKU);

        if (product != null) {
            System.out.println("¿Qué deseas editar?");
            System.out.println("1. Descripción");
            System.out.println("2. Tallas Disponibles");
            System.out.println("3. Cantidad por talla");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Ingresa la nueva descripción: ");
                    String description = scanner.nextLine();
                    product.setDescription(description);
                    System.out.println("Descripción actualizada");
                    break;
                
                case "2":
                    System.out.print("Ingresa las nuevas tallas en formato (xs:10|s:20|m:30|l:40|xl:50): ");
                    String sizes = scanner.nextLine();
                    product.setSizes(Product.parseSizes(sizes));
                    System.out.println("Tallas actualizadas");
                    break;
                
                case "3":
                    System.out.print("Ingresa la talla a modificar: ");
                    String size = scanner.nextLine();
                    if (product.getSizes().containsKey(size)) {
                        System.out.print("Ingresa la nueva cantidad");
                        int quantity = scanner.nextInt();
                        product.updateSizeQuantity(size, quantity);
                        System.out.println("Cantidad actualizada");
                    } 
                    
                    else {
                        System.out.println("Talla no encontrada");
                    }
                    break;
                    
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }   
    }

    /**
     * Lista los productos ordenados por SKU o por nombre
     */
    public void listProducts() {
        System.out.println("¿Por qué campo deseas ordenar los productos?");
        System.out.println("1. SKU");
        System.out.println("2. Nombre");
        String option = scanner.nextLine();

        if (option.equals("1")) {
            btSKU.inOrder();
        } 
        
        else if (option.equals("2")) {
            btName.inOrder();
        } 
        
        else {
            System.out.println("Opción inválida");
        }
    }   
}
