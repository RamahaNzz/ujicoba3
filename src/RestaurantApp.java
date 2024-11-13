import java.util.ArrayList;

class FoodItem {
    private String itemName;
    private double itemPrice;

    public FoodItem(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return itemName + ": Rp" + itemPrice;
    }
}

class CartItem {
    private FoodItem foodItem;
    private int quantity;

    public CartItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return foodItem.getItemPrice() * quantity;
    }

    @Override
    public String toString() {
        return foodItem.toString() + " x" + quantity + " - Rp" + getTotalPrice();
    }
}

class FoodOrder {
    private ArrayList<CartItem> cartItems;
    private double discountRate;

    public FoodOrder(double discountRate) {
        this.cartItems = new ArrayList<>();
        this.discountRate = discountRate;
    }

    public void addFoodItem(FoodItem foodItem, int quantity) {
        cartItems.add(new CartItem(foodItem, quantity));
    }

    public double calculateTotal() {
        double total = 0;
                for (CartItem item : cartItems) {
                    total += item.getTotalPrice();
                }

        // Menerapkan diskon jika total di atas Rp50,000
        if (total > 50000) {
            total -= total * discountRate;
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Order Summary:\n");
        for (CartItem item : cartItems) {
            orderDetails.append(item.toString()).append("\n");
        }
        orderDetails.append("\nTotal (with discount if applicable): Rp").append(calculateTotal());
        return orderDetails.toString();
    }
}

// Main Class untuk menjalankan aplikasi
public class RestaurantApp {
    public static void main(String[] args) {
        // Membuat item menu
        FoodItem mieGoreng = new FoodItem("Mie Goreng", 20000);
        FoodItem bakso = new FoodItem("Bakso", 30000);

        // Membuat pesanan dengan diskon 10% jika total lebih dari Rp50,000
        FoodOrder order = new FoodOrder(0.10); // 10% diskon
        order.addFoodItem(mieGoreng, 3);  // 3 porsi mie goreng
        order.addFoodItem(bakso, 1);      // 1 porsi bakso

        // Cetak nota pesanan
        System.out.println(order);
    }
}

