import java.util.Random;

public class Product {

  private String name;

  private double price;

  private String category;

  private static DiscountSize discountSize;

  public Product(String name, double price, String category) {
    setName(name);
    setPrice(price);
    setCategory(category);
    Product.discountSize = DiscountSize.NO_DISCOUNT;
  }

  public static void assignRandomDiscount() {
    DiscountSize[] discounts = DiscountSize.values();
    Random random = new Random();
    int index = random.nextInt(discounts.length);
    DiscountSize randomDiscount = discounts[index];

    Product product = new Product("Продукт", 100.0,
        Category.Normal);
    try {
      product.setDis(
          randomDiscount);
    } catch (DiscountExc e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Название продукта не может быть пустым..");
    }
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Цена товара не может быть отрицательной.");
    }
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public DiscountSize getDis() {
    return discountSize;
  }

  public void setDis(DiscountSize discountSize) throws DiscountExc {
    if (discountSize == null) {
      throw new IllegalArgumentException("Размер скидки не может быть нулевым.");
    }
    if (this.category == Category.Premium && discountSize.getValue() > 0.50) {
      throw new DiscountExc(
          "Скидка более 50% не допускается для товаров премиум-класса..");
    }
    Product.discountSize = discountSize;
  }

  @Override
  public String toString() {
    return "Название " + name + '\n' +
        " Цена " + price + '\n' +
        " Категория " + category + '\n' +
        " Скидка " + discountSize + '\n';
  }
}
