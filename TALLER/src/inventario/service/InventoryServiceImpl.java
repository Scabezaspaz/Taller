package inventario.service;



import inventario.model.Product;
import java.util.logging.Logger;
import inventario.interfaces.IInventoryRepository;
import inventario.interfaces.IInventoryService;

/**
 * Servicio responsable de administrar el inventario.
 * Encapsula las reglas de negocio vinculadas a la gestión de productos,
 * aplicando de forma adecuada el principio de responsabilidad única (SRP).
 */

public class InventoryServiceImpl implements IInventoryService {

    private static final Logger LOGGER = Logger.getLogger(InventoryServiceImpl.class.getName());
    private final IInventoryRepository inventoryRepository;

    public InventoryServiceImpl(IInventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void addProduct(String productId, int quantity) {
        if (productId == null || productId.isBlank() || quantity <= 0) {
            LOGGER.warning("Invalid product data. Cannot add product.");
            return;
        }

        Product product = inventoryRepository.findProductById(productId);

        if (product == null) {
            product = new Product(productId, quantity);
        } else {
            product.addStock(quantity);
        }

        inventoryRepository.saveProduct(product);
        LOGGER.info("Product added/updated correctly: " + productId + " | Quantity: " + quantity);
    }

    @Override
    public int getStock(String productId) {
        Product product = inventoryRepository.findProductById(productId);

        if (product == null) {
            LOGGER.warning("Product not found: " + productId);
            return 0;
        }

        return product.getStock();
    }
}

