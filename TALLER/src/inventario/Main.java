package inventario;

import inventario.interfaces.*;
import inventario.model.Order;
import inventario.model.OrderItem;
import inventario.repository.InventoryRepositoryImpl;
import inventario.repository.OrderRepositoryImpl;
import inventario.service.*;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal del sistema de inventario.
 *
 * <p>Permite interactuar con el usuario mediante consola para:
 * <ul>
 *     <li>Agregar productos al inventario</li>
 *     <li>Registrar ventas</li>
 *     <li>Crear órdenes</li>
 *     <li>Consultar stock disponible</li>
 *     <li>Enviar confirmaciones por correo electrónico</li>
 * </ul>
 *
 * <p>Los mensajes se manejan a través de {@link java.util.logging.Logger}
 * en lugar de impresiones estándar, para facilitar la trazabilidad
 * y mantenimiento del sistema.
 *
 * @author
 * @version 2.0
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Inyección manual de dependencias
        IInventoryRepository inventoryRepository = new InventoryRepositoryImpl();
        IOrderRepository orderRepository = new OrderRepositoryImpl();

        IInventoryService inventoryService = new InventoryServiceImpl(inventoryRepository);
        ISaleService saleService = new SaleServiceImpl(inventoryRepository);
        IOrderService orderService = new OrderServiceImpl(orderRepository);
        IEmailService emailService = new EmailServiceImpl();

        int option;

        do {
            LOGGER.info("""
                    ===============================
                    ==== SISTEMA DE INVENTARIO ====
                    ===============================
                    1. Agregar producto
                    2. Registrar venta
                    3. Crear orden
                    4. Consultar stock
                    5. Enviar confirmación de orden
                    0. Salir
                    Seleccione una opción:
                    """);

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (option) {
                    case 1 -> agregarProducto(scanner, inventoryService);
                    case 2 -> registrarVenta(scanner, saleService);
                    case 3 -> crearOrden(scanner, orderService);
                    case 4 -> consultarStock(scanner, inventoryService);
                    case 5 -> enviarConfirmacion(scanner, emailService);
                    case 0 -> LOGGER.info("Sistema finalizado correctamente.");
                    default -> LOGGER.warning("Opción inválida. Intente nuevamente.");
                }

            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error: Entrada inválida o fallo en la operación.", e);
                scanner.nextLine(); // limpiar buffer si ocurre error
                option = -1; // para continuar el ciclo
            }

        } while (option != 0);

        scanner.close();
    }

    // --- Métodos auxiliares para claridad y mantenimiento ---

    private static void agregarProducto(Scanner scanner, IInventoryService inventoryService) {
        LOGGER.info("Ingrese ID del producto: ");
        String pId = scanner.nextLine();
        LOGGER.info("Cantidad: ");
        int qty = scanner.nextInt();
        scanner.nextLine();
        inventoryService.addProduct(pId, qty);
        LOGGER.info(" Producto agregado correctamente.");
    }

    private static void registrarVenta(Scanner scanner, ISaleService saleService) {
        LOGGER.info("ID producto vendido: ");
        String pId = scanner.nextLine();
        LOGGER.info("Cantidad vendida: ");
        int qty = scanner.nextInt();
        scanner.nextLine();
        saleService.registerSale(pId, qty);
        LOGGER.info(" Venta registrada correctamente.");
    }

    private static void crearOrden(Scanner scanner, IOrderService orderService) {
        Order order = new Order();
        String more;
        do {
            LOGGER.info("ID producto: ");
            String pId = scanner.nextLine();
            LOGGER.info("Cantidad: ");
            int qty = scanner.nextInt();
            scanner.nextLine();
            order.addItem(new OrderItem(pId, qty));

            LOGGER.info("¿Agregar otro producto? (s/n): ");
            more = scanner.nextLine();
        } while (more.equalsIgnoreCase("s"));
        orderService.createOrder(order);
        LOGGER.info(" Orden creada correctamente.");
    }

    private static void consultarStock(Scanner scanner, IInventoryService inventoryService) {
        LOGGER.info("ID producto: ");
        String pId = scanner.nextLine();
        int stock = inventoryService.getStock(pId);
        LOGGER.log(Level.INFO, " Stock actual de {0}: {1}", new Object[]{pId, stock});
    }

    private static void enviarConfirmacion(Scanner scanner, IEmailService emailService) {
        LOGGER.info("Correo destinatario: ");
        String email = scanner.nextLine();
        Order order = new Order();
        order.addItem(new OrderItem("TEMP", 1)); // Simulación mínima
        emailService.sendOrderConfirmation(email, order);
        LOGGER.log(Level.INFO, "Confirmación enviada a: {0}", email);
    }
}
