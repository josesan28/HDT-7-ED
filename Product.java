/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase que representa un producto de la tienda de Retail
 *  Fecha de creación: 14/03/2025
 *  Fecha de última modificación: 26/03/2025
 */

import java.util.Map;
import java.util.HashMap;

public class Product {
    private String SKU;
    private String name;
    private String description;
    private Map<String, Integer> sizes;    

    public Product(String SKU, String name, String description, Map<String, Integer> sizes) {
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.sizes = new HashMap<>(sizes);
    }

    /**
     * Obtiene el SKU del producto
     * @return SKU del producto
     */
    public String getSKU() {
        return SKU;
    }

    /**
     * Establece el SKU del producto
     * @param SKU SKU del producto
     */
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    /**
     * Obtiene el nombre del producto
     * @return Nombre del producto
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del producto
     * @param name Nombre del producto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la descripción del producto
     * @return Descripción del producto
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del producto
     * @param description Descripción del producto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene los tamaños disponibles del producto
     * @return Tamaños disponibles del producto
     */
    public Map<String, Integer> getSizes() {
        return sizes;
    }

    /**
     * Establece los tamaños disponibles del producto
     * @param sizes Tamaños disponibles del producto
     */
    public void setSizes(Map<String, Integer> sizes) {
        this.sizes = sizes;
    }

    /**
     * Actualiza la cantidad de una talla
     * @param size Talla
     * @param quantity Cantidad
     */
    public void updateSizeQuantity(String size, int quantity) {
        sizes.put(size, quantity);
    }

    public static Map<String, Integer> parseSizes (String sizes) {
        Map<String, Integer> sizesMap = new HashMap<>();
        String[] pairs = sizes.split("\\|");
        for (String pair : pairs) {
            String[] data = pair.split(":");
            if (data.length == 2) {
                sizesMap.put(data[0], Integer.parseInt(data[1]));
            }
        }
        return sizesMap;
    }

    
    /**
     * Método toString de la clase Product
     * @return String con la información del producto
     */
    @Override
    public String toString() {
        return "SKU: " + SKU + ", Nombre: " + name + ", Descripción: " + description + ", Tallas disponibles: " + sizes;
    }

}