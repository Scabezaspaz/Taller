package inventario.model;


/**
 * Modela un producto perteneciente al inventario.
 * Esta clase reemplaza la mala práctica de emplear Maps con datos dispersos,
 * incorporando un modelo de dominio que encapsula tanto el estado como
 * las reglas del producto. Previene antipatrones como Hard Code, Temporary Field
 * y ausencia de modelo de dominio.
 */

public class Product {

    private String id;
    private int stock;

    /**
     * Constructor utilizado para instanciar un nuevo producto.
     */

    public Product(String id, int stock) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        this.id = id;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    /**
     * Incrementa la cantidad de stock del producto.
     */

    public void addStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        this.stock += quantity;
    }

    /**
     * Disminuye el stock del producto, siempre que haya cantidad suficiente disponible.
     */

    public boolean deductStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        if (stock >= quantity) {
            stock -= quantity;
            return true;
        }
        return false;
    }
}
