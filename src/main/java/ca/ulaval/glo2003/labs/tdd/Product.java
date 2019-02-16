package ca.ulaval.glo2003.labs.tdd;

class Product {

  private final String name;
  private final double price;
  private final boolean taxable;

  public Product(String name, double price, boolean taxable) {
    this.name = name;
    this.price = price;
    this.taxable = taxable;
  }

  public Double calculatePrice() {
    return price;
  }

  public double calculatePriceWithTaxes(double taxes) {
    return taxable ? price + price * taxes : price;
  }

}
