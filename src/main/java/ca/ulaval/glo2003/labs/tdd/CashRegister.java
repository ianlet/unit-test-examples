package ca.ulaval.glo2003.labs.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 *  DISCLAIMER:
 *    Ceci n'est pas nécessairement un design idéal puisqu'il ne respecte pas certaines bonnes pratiques OO.
 *    Il s'agit simplement d'un exemple de tests unitaires pour un problème relativement simple.
 *
 *    Il pourrait manquer certains cas de tests, mais il y en a suffisamment pour montrer des exemples
 *    de tests qui vérifient les comportements attendus par le client et non pas des méthodes ou des
 *    détails d'implémentation.
 *
 *  FONCTIONNALITÉS:
 *    - Scanner un produit
 *    - Calculer le sous-total en aditionnant le prix de chaque produit scanné
 *    - Calculer le total en aditionnant le prix de chaque produit scanné et en appliquant les taxes (15%)
 *      sur les produits taxables
 */
public class CashRegister {

  private static final double TAXES = 0.15;

  private List<Product> products = new ArrayList<>();

  public void scanProduct(String name, double price, boolean taxable) {
    Product product = new Product(name, price, taxable);
    products.add(product);
  }

  public double calculateSubtotal() {
    double subtotal = 0.0;
    for (Product product : products) {
      subtotal += product.calculatePrice();
    }
    return subtotal;
  }

  public double calculateTotal() {
    double total = 0.0;
    for (Product product : products) {
      total += product.calculatePriceWithTaxes(TAXES);
    }
    return total;
  }

}
