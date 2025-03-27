/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase principal que ejecuta el programa
 *  Fecha de creación: 22/03/2025
 *  Fecha de última modificación: 26/03/2025
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree<String, Product> btSKU = new BinaryTree<>();
        BinaryTree<String, Product> btName = new BinaryTree<>();
        CSVManager.loadFromCSV("inventario_ropa_deportiva_100.csv", btSKU, btName);
        StoreManager storeManager = new StoreManager(btSKU, btName);

        String option = "";
        Scanner scanner = new Scanner(System.in);

        while (!option.equals("5")) {
            System.out.println("\nSistema de inventario de productos\n");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Editar producto");
            System.out.println("3. Listar productos");
            System.out.println("4. Buscar producto");
            System.out.println("5. Salir");

            System.out.print("\nIngresa una opción: ");

            option = scanner.nextLine();

            switch (option) {
                case "1":
                    storeManager.addProduct();
                    break;
                case "2":
                    storeManager.editProduct();
                    break;
                case "3":
                    storeManager.listProducts();
                    break;
                case "4":
                    storeManager.searchProduct();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }    
        }
        scanner.close();
    }
}