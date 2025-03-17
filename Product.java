/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase que representa un producto de la tienda de Retail
 *  Fecha de creación: 14/03/2025
 *  Fecha de última modificación: 16/03/2025
 */

import java.util.List;

public class Product {
    private int SKU;
    private String name;
    private String description;
    private List<String> sizes;
    private String quantityPerSize;

    public Product(int SKU, String name, String description, List<String> sizes, String quantityPerSize) {
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.sizes = sizes;
        this.quantityPerSize = quantityPerSize;
    }

}