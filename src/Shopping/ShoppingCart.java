package Shopping;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart {
    Map<ProductInterface, Integer> products = new HashMap<ProductInterface, Integer>();

    // getters
    public Map<ProductInterface, Integer> getProducts() {
        return products;
    }

    // setters
    public void setProducts(Map<ProductInterface, Integer> products) {
        this.products = products;
    }

    public void addProduct(ProductInterface product, int quantity)
    {
        products.put(product, quantity);
    }

    // removing product from the cart
    public void removeProduct(ProductInterface prod)
    {
        products.remove(prod);
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();
        content.append("ShoppingCart<br/>");
        Iterator<Entry<ProductInterface, Integer>> prod = products.entrySet().iterator();
        while (prod.hasNext())
        {
            content.append(prod.next().toString());
        }
        return content.toString();
    }

    public BigDecimal totalCost()// calculate the total cost in the cart
    {
        BigDecimal total = new BigDecimal(0);
        Iterator<Entry<ProductInterface, Integer>> product = products.entrySet().iterator();
        double cost = 0;
        Entry<ProductInterface, Integer> current;
        while (product.hasNext())
        {
            current = product.next();
            cost = current.getKey().getCost().doubleValue() * current.getValue();// get the total cost for the current product or service
            total = total.add(BigDecimal.valueOf(cost));// adding the product's cost to the total cost of the cart
        }
        total = total.setScale(2, BigDecimal.ROUND_CEILING);// adding precision
        return total;
    }

}
