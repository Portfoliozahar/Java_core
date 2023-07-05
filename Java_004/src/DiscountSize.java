
public enum DiscountSize {

  NO_DISCOUNT(0),

  DISCOUNT_5(0.05),

  DISCOUNT_15(0.15),

  DISCOUNT_30(0.30),

  DISCOUNT_50(0.50);

  private final double value;

  DiscountSize(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }

}
