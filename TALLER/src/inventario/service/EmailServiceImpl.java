package inventario.service;

import inventario.interfaces.IEmailService;
import inventario.model.Order;
import java.util.logging.Logger;

/**
 * Implementación del servicio encargado del envío de notificaciones.
 *
 * Aplica el principio de inversión de dependencias (DIP),
 * desacoplando completamente el proceso de envío de los clientes que lo utilizan.
 */

public class EmailServiceImpl implements IEmailService {

    private static final Logger LOGGER = Logger.getLogger(EmailServiceImpl.class.getName());

    @Override
    public void sendOrderConfirmation(String email, Order order) {
        if (email == null || email.isBlank() || order == null) {
            LOGGER.warning("Email or order invalid. Cannot send notification.");
            return;
        }

        LOGGER.info("Order confirmation sent to: " + email);
    }
}

