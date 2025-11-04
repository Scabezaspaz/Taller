package inventario.model;

/**
 * Modela un elemento perteneciente a una orden,
 * permitiendo gestionar varios productos dentro de un mismo pedido.
 *
 * Favorece la cohesión del sistema al dividir responsabilidades
 * que antes se encontraban combinadas en cadenas de texto sin estructura.
 */

public class OrderItem {

    private String productId;
    private int quantity;

    /**
     * @param productId ID que identifica el producto.
     * @param quantity  Número de unidades vinculadas a ese producto.
     */

    public OrderItem(String productId, int quantity) {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
