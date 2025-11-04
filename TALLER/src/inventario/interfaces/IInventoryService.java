package inventario.interfaces;

/**
 * Especifica los servicios responsables de la gestión del inventario.
 */

public interface IInventoryService {

    /**
     * Incrementa la cantidad disponible en el stock de un producto.
     */

    void addProduct(String productId, int quantity);

    /**
     * Recupera la cantidad de stock disponible de un producto.
     */

    int getStock(String productId);
}
