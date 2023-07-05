
public class Check {

  private Client customer;

  private Product product;

  private int amt;

  private double totalprice;

  public Check(Client customer, Product product, int amt) {
    setCustomer(customer);
    setProduct(product);
    setamt(amt);
    setPrise();
  }

  public Client getCustomer() {
    return customer;
  }

  public void setCustomer(Client customer) {

    this.customer = customer;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {

    this.product = product;
  }

  public int getamt() {
    return amt;
  }

  public void setamt(int amt) {
    if (amt <= 0 || amt > 200) {
      throw new IllegalArgumentException("сумма должна быть больше 0 и меньше либо равна 200");
    }
    this.amt = amt;
    setPrise();
  }

  public double getPrise() {
    return totalprice;
  }

  private void setPrise() {
    double discountedPrice = product.getPrice() * (1 - product.getDis().getValue());
    totalprice = amt * discountedPrice;
  }

  @Override
  public String toString() {
    return "Покупатель " + customer + '\n' +
        " Продукт " + product + '\n' +
        " Количество " + amt + '\n' +
        " Общая цена " + totalprice + '\n';
  }
}
