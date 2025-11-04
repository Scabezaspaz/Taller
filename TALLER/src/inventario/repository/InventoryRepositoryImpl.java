package inventario.repository;

import inventario.model.Product;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Logger;
import inventario.interfaces.IInventoryRepository;


/**
 * Implementación del repositorio de inventario basada en almacenamiento en memoria.
 *
 * Esta clase evita antipatrones como Hard Code y God Object
 * al mantener separadas la lógica de datos y la lógica de negocio.
 */

public class InventoryRepositoryImpl implements IInventoryRepository {

    private static final Logger LOGGER = Logger.getLogger(InventoryRepositoryImpl.class.getName());
    private final Map<String, Product> productStorage = new HashMap<>();

    @Override
    public Product findProductById(String productId) {
        if (productId == null || productId.isBlank()) {
            LOGGER.warning("Product ID cannot be null or empty.");
            return null;
        }
        return productStorage.get(productId);
    }

    @Override
    public void saveProduct(Product product) {
        if (product == null) {
            LOGGER.warning("Cannot save null product.");
            return;
        }
        productStorage.put(product.getId(), product);
        LOGGER.info("Product saved/updated: " + product.getId());
    }
}

