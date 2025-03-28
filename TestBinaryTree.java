import org.junit.Test;
import static org.junit.Assert.*;

public class TestBinaryTree {
    
    @Test
    public void testInsertAndSearch() {
        BinaryTree<String, Product> binaryTree = new BinaryTree<>();
        
        Product product1 = new Product("001", "Jersey Deportivo", "Playera de tela con absorción de sudor", Product.parseSizes("xs:10|s:15|m:25|l:10|xl:8"));
        
        Product product2 = new Product("002", "Chumpa Impermeable", "Chumpa ligera de nylon para ejercicio en exterior", Product.parseSizes("s:10|m:30|l:12"));
        
        binaryTree.insert(product1.getSKU(), product1);
        binaryTree.insert(product2.getSKU(), product2);
        
        assertEquals("Búsqueda de producto 1 por SKU debe coincidir", 
            product1, binaryTree.search(product1.getSKU()));
        assertEquals("Búsqueda de producto 2 por SKU debe coincidir", 
            product2, binaryTree.search(product2.getSKU()));
    }
    
    @Test
    public void testSearchNonExistentProduct() {
        BinaryTree<String, Product> binaryTree = new BinaryTree<>();
        
        Product product = new Product("001", "Jersey Deportivo", "Playera de tela con absorción de sudor", Product.parseSizes("xs:10|s:15|m:25|l:10|xl:8"));
        
        binaryTree.insert(product.getSKU(), product);
        
        assertNull("Búsqueda de SKU no existente debe devolver null", 
            binaryTree.search("999"));
    }
    
    @Test
    public void testInsertMultipleProducts() {
        BinaryTree<String, Product> binaryTree = new BinaryTree<>();
        
        Product[] products = {
            new Product("001", "Jersey Deportivo", "Playera de tela con absorción de sudor", Product.parseSizes("xs:10|s:15|m:25|l:10|xl:8")),
            new Product("002", "Chumpa Impermeable", "Chumpa ligera de nylon para ejercicio en exterior", Product.parseSizes("s:10|m:30|l:12")),
            new Product("003", "Pants Deportivo", "Pantalón cómodo para entrenamiento", Product.parseSizes("s:20|m:35|l:15|xl:10"))
        };
        
        for (Product product : products) {
            binaryTree.insert(product.getSKU(), product);
        }
        
        for (Product product : products) {
            assertEquals("Búsqueda de producto debe coincidir", 
                product, binaryTree.search(product.getSKU()));
        }
    }
    
    @Test
    public void testInsertDuplicateKey() {
        BinaryTree<String, Product> binaryTree = new BinaryTree<>();
        
        Product originalProduct = new Product("001", "Jersey Deportivo", "Playera de tela con absorción de sudor", Product.parseSizes("xs:10|s:15|m:25|l:10|xl:8"));
        
        Product updatedProduct = new Product("001", "Jersey Deportivo Actualizado", "Nueva descripción", Product.parseSizes("xs:15|s:20|m:30|l:15|xl:10"));
        
        binaryTree.insert(originalProduct.getSKU(), originalProduct);
        binaryTree.insert(updatedProduct.getSKU(), updatedProduct);
        
        assertEquals("Último producto insertado debe reemplazar al anterior", 
            updatedProduct, binaryTree.search("001"));
    }
}