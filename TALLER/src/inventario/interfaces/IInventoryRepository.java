package inventario.interfaces;

import inventario.model.Product;

/**
 * Declara las operaciones para el acceso a datos del inventario.
 * Esta interfaz facilita el desacoplamiento entre la capa de datos y la lógica de negocio,
 * previniendo el uso de estructuras fuera del modelo de dominio y evitando antipatrones
 * como God Object o Spaghetti Code.
 */

public interface IInventoryRepository {

    /**
     * Recupera un producto utilizando su identificador único.
     */

    Product findProductById(String productId);

    /**
     * Registra o modifica un producto dentro del inventario.
     */

    void saveProduct(Product product);
}
