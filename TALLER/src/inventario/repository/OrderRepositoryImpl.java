package inventario.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import inventario.interfaces.IOrderRepository;
import inventario.model.Order;
/**
 * Repositorio encargado de administrar las órdenes mediante almacenamiento en memoria.
 *
 * Este enfoque sigue el principio de responsabilidad única (SRP)
 * y previene el antipatrón de baja cohesión al mantener una función claramente definida.
 */

public class OrderRepositoryImpl implements IOrderRepository {

    private static final Logger LOGGER = Logger.getLogger(OrderRepositoryImpl.class.getName());
    private final List<Order> orderStorage = new ArrayList<>();

    @Override
    public void saveOrder(Order order) {
        if (order == null) {
            LOGGER.warning("Cannot save null order.");
            return;
        }
        orderStorage.add(order);
        LOGGER.info("Order saved successfully.");
    }

    /**
     * Método auxiliar para depuración y pruebas.
     *
     * @return Lista de órdenes almacenadas en memoria.
     */

    public List<Order> getAllOrders() {
        return orderStorage;
    }
}
