package inventario.interfaces;


import inventario.model.Order;

/**
 * Especifica las funciones relacionadas con la creación y gestión de órdenes.
 */

public interface IOrderService {

    /**
     * Genera una nueva orden y la guarda dentro del sistema.
     */

    void createOrder(Order order);
}
