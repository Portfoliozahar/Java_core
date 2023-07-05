import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  private static final int max_amt = 200;

  private static final int random_bound = 4;

  private static final String cust_not = "Покупатель отсутствует";

  private static final String product_not = "Товар отсутствует";

  public static void main(String[] args) {
    List<Client> customers = createCustomers();
    List<Product> products = createProducts();

    List<Check> orders = new ArrayList<>();
    try {
      Check order1 = makeRandom(customers, products);
      addOrder(orders, order1);

      Check order2 = makeRandom(customers, products);
      addOrder(orders, order2);

      Check order3 = makeRandom(customers, products);
      addOrder(orders, order3);

      Check order4 = makeRandom(customers, products);
      addOrder(orders, order4);

    } catch (ClientExc | ProductExc | CheckExc e) {
      System.out.println(e.getMessage());
    }

    System.out.println("Количество совершенных покупок: " + orders.size());
  }

  public static List<Client> createCustomers() {
    List<Client> customers = new ArrayList<>();
    customers.add(new Client("Саватов", "Олег", 32, "712323512", Gender.male));
    customers.add(new Client("Маршина", "Наталья", 30, "73461245", Gender.female));
    return customers;
  }

  public static List<Product> createProducts() {
    List<Product> products = new ArrayList<>();
    products.add(new Product("Товар 1", 124.0, Category.Normal));
    Product.assignRandomDiscount();
    products.add(new Product("Товар 2", 140.0, Category.Premium));
    Product.assignRandomDiscount();
    products.add(new Product("Товар 3", 231.5, Category.Normal));
    Product.assignRandomDiscount();
    products.add(new Product("Товар 4", 195.0, Category.Premium));
    Product.assignRandomDiscount();
    return products;
  }

  public static void addOrder(List<Check> orders, Check order) {
    orders.stream()
        .filter(existingOrder -> existingOrder.getClient().equals(order.getClient()))
        .findFirst()
        .ifPresent(existingOrder -> {
          System.out.println(
              "Заказ для покупателя " + order.getClient().getFirstName() + " уже существует");
        });

    orders.add(order);
    System.out.println("Добавлен заказ: " + '\n' + order);
  }

  public static Check makeRandom(List<Client> customers, List<Product> products)
      throws ClientExc, ProductExc, CheckExc {
    Client randomCustomer = getRandomElement(customers);
    Product randomProduct = getRandomElement(products);
    int randomQuantity = getRandomQuantity();

    return makePurchase(randomCustomer, randomProduct, randomQuantity);
  }

  public static Check makePurchase(Client customer, Product product, int quantity)
      throws ClientExc, ProductExc, CheckExc {
    if (quantity < 0 || quantity > max_amt) {
      throw new CheckExc("Неверное количество товара");
    }

    Check order = new Check(customer, product, quantity);

    return order;
  }

  public static <T> T getRandomElement(List<T> list) {
    Random random = new Random();
    int randomIndex = random.nextInt(list.size());
    return list.get(randomIndex);
  }

  public static int getRandomQuantity() {
    Random random = new Random();
    return random.nextInt(random_bound) - 1;
  }

  public static double calculateCost(double price, int quantity) {
    return price * quantity;
  }

  public static void validateProduct(Product product) throws ProductExc {
    if (product == null) {
      throw new ProductExc(cust_not);
    }
  }

  public static void validateQuantity(int quantity) throws DiscountExc {
    if (quantity <= 0 || quantity > max_amt) {
      throw new DiscountExc(product_not);
    }
  }
}
