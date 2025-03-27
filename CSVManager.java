/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase que maneja la lectura de archivos CSV
 *  Fecha de creación: 22/03/2025
 *  Fecha de última modificación: 26/03/2025
 */

import java.io.*;
import java.util.Map;

public class CSVManager {

    /**
     * Lee un archivo CSV y carga los productos en dos árboles binarios
     * @param filePath Ruta del archivo CSV
     * @param btSKU Árbol binario de búsqueda por SKU
     * @param btName Árbol binario de búsqueda por nombre
     */
    public static void loadFromCSV(String filePath, BinaryTree<String, Product> btSKU, BinaryTree<String, Product> btName) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", 4);
                if (fields.length < 4) {
                    System.out.println("Error: línea con formato incorrecto");
                    continue;
                }
                String SKU = fields[0].trim();
                String name = fields[1].trim();
                String description = fields[2].trim();
                Map<String, Integer> sizes = Product.parseSizes(fields[3].trim());
                Product product = new Product(SKU, name, description, sizes);
                btSKU.insert(SKU, product);
                btName.insert(name, product);
            }
        } catch (IOException e) {
            System.out.println("Error: no se pudo leer el archivo");
        }
    }
}