package inventario.interfaces;

import inventario.model.Order;

/**
 * Interfaz que abstrae la administración del almacenamiento de órdenes.
 *
 * Contribuye a evitar el antipatrón de baja cohesión al organizar
 * adecuadamente la gestión de pedidos.
 */

public interface IOrderRepository {

    /**
     * Registra una nueva orden en el repositorio.
     *
     * @param order Pedido que se desea almacenar.
     */

    void saveOrder(Order order);
}