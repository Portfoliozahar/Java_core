
public class Check {

  private Client client;

  private Product product;

  private int quantity;

  private double totalPrice;

  public Check(Client client, Product product, int quantity) {
    setClient(client);
    setProduct(product);
    setQuantity(quantity);
    calculateTotalPrice();
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    if (client == null) {
      throw new IllegalArgumentException("Клиент не может быть нулевым.");
    }
    this.client = client;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    if (product == null) {
      throw new IllegalArgumentException("Продукт не может быть нулевым.");
    }
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    if (quantity <= 0 || quantity > 100) {
      throw new IllegalArgumentException("Количество должно быть больше 0 и меньше либо равно 100.");
    }
    this.quantity = quantity;
    calculateTotalPrice();
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  private void calculateTotalPrice() {
    double discountedPrice = product.getPrice() * (1 - product.getDis().getValue());
    totalPrice = quantity * discountedPrice;
  }

  @Override
  public String toString() {
    return "Покупатель " + client + '\n' +
        " Продукт " + product + '\n' +
        " Количество " + quantity + '\n' +
        " Общая цена " + totalPrice + '\n';
  }
}
