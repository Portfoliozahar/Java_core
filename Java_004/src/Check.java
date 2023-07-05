
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
      throw new IllegalArgumentException("Customer cannot be null.");
    }
    this.client = client;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    if (product == null) {
      throw new IllegalArgumentException("Product cannot be null.");
    }
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  /**
   * Устанавливает количество заказанного продукта. Если количество меньше или
   * равно нулю,
   * выбрасывается исключение IllegalArgumentException.
   *
   * @param quantity Количество заказанного продукта.
   */
  public void setQuantity(int quantity) {
    if (quantity <= 0 || quantity > 100) {
      throw new IllegalArgumentException("Quantity must be greater than zero and less than or equal to 100");
    }
    this.quantity = quantity;
    calculateTotalPrice();
  }

  /**
   * Возвращает общую цену заказа.
   *
   * @return Общая цена заказа.
   */
  public double getTotalPrice() {
    return totalPrice;
  }

  /**
   * Вычисляет общую цену заказа на основе количества и цены продукта с учетом
   * скидки.
   */
  private void calculateTotalPrice() {
    double discountedPrice = product.getPrice() * (1 - product.getDis().getValue());
    totalPrice = quantity * discountedPrice;
  }

  /**
   * Возвращает строковое представление объекта заказа.
   *
   * @return Строковое представление объекта заказа.
   */
  @Override
  public String toString() {
    return "Покупатель " + client + '\n' +
        " Продукт " + product + '\n' +
        " Количество " + quantity + '\n' +
        " Цена итого " + totalPrice + '\n';
  }
}
