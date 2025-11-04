package inventario.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una orden de compra dentro del sistema.
 *
 * Optimiza el diseño previo al reemplazar el uso de cadenas mal estructuradas
 * y prevenir antipatrones como baja cohesión y Spaghetti Code.
 */

public class Order {

    private final List<OrderItem> items = new ArrayList<>();

    /**
     * Añade un producto a la orden.
     *
     * @param item Elemento que contiene el producto y su cantidad.
     * @throws IllegalArgumentException si el elemento es nulo.
     */

    public void addItem(OrderItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Order item cannot be null.");
        }
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
