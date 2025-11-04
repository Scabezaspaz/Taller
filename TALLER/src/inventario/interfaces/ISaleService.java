package inventario.interfaces;

/**
 * Especifica los servicios vinculados al registro de ventas,
 * separando la lógica del inventario original para mantener una mejor organización.
 */

public interface ISaleService {

    /**
     * Registra una transacción de venta en el sistema.
     *
     * @param productId Identificador del producto.
     * @param quantity  Cantidad de unidades vendidas.
     * @return true si la venta se completa con éxito, false si el stock es insuficiente.
     */

    boolean registerSale(String productId, int quantity);
}
