package inventario.service;

import inventario.model.Order;
import java.util.logging.Logger;
import inventario.interfaces.IOrderRepository;
import inventario.interfaces.IOrderService;

/**
 * Servicio encargado de la administración de las órdenes de compra.
 *
 * Conserva una alta cohesión al enfocarse únicamente
 * en la lógica relacionada con el ciclo de vida de las órdenes.
 */

public class OrderServiceImpl implements IOrderService {

    private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class.getName());
    private final IOrderRepository orderRepository;

    public OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Order order) {
        if (order == null) {
            LOGGER.warning("Cannot create order: order is null.");
            return;
        }

        orderRepository.saveOrder(order);
        LOGGER.info("Order saved successfully.");
    }
}
