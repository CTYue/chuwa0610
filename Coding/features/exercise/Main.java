package features.exercise;

/**
 * description: Main
 * date: 6/21/24 7:26 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        ShoppingCart shoppingCart = new ShoppingCart();
        customer.setShoppingCart(shoppingCart);
        System.out.println(ShoppingCartUtil.getFirstItemNameWithAlternative(customer));
    }
}
