package inventario.interfaces;


import inventario.model.Order;

/**
 * Servicio responsable de enviar correos de confirmación o notificación.
 *
 * Implementa el principio de inversión de dependencias (DIP),
 * reduciendo el acoplamiento directo con la capa de infraestructura.
 */

public interface IEmailService {

    /**
     * Envía un correo electrónico para confirmar una orden.
     *
     * @param email Correo electrónico del destinatario.
     * @param order Pedido vinculado a la notificación.
     */

    void sendOrderConfirmation(String email, Order order);
}
