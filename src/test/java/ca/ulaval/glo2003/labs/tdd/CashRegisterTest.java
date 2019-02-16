package ca.ulaval.glo2003.labs.tdd;

import static com.google.common.truth.Truth.*;

import org.junit.Before;
import org.junit.Test;

public class CashRegisterTest {

  private static final String A_PRODUCT_NAME = "a";
  private static final String ANOTHER_PRODUCT_NAME = "b";

  private static final double PRODUCT_PRICE_WITH_TAXES = 2.875;
  private static final double PRODUCT_PRICE = 2.50;
  private static final double PRODUCT_PRICES_SUM = PRODUCT_PRICE + PRODUCT_PRICE;

  private static final boolean TAXABLE = true;
  private static final boolean NON_TAXABLE = false;

  private static final double ZERO = 0.0d;

  private CashRegister cashRegister;

  @Before
  public void setUpCashRegister() {
    cashRegister = new CashRegister();
  }

  @Test
  public void noProductScanned_calculateSubtotal_shouldReturnZero() {
    double subtotal = cashRegister.calculateSubtotal();

    assertThat(subtotal).isEqualTo(ZERO);
  }

  @Test
  public void someProductsScanned_calculateSubtotal_shouldSumProductPrices() {
    cashRegister.scanProduct(A_PRODUCT_NAME, PRODUCT_PRICE, NON_TAXABLE);
    cashRegister.scanProduct(ANOTHER_PRODUCT_NAME, PRODUCT_PRICE, NON_TAXABLE);

    double subtotal = cashRegister.calculateSubtotal();

    assertThat(subtotal).isEqualTo(PRODUCT_PRICES_SUM);
  }

  @Test
  public void noProductScanned_calculateTotal_shouldReturnZero() {
    double total = cashRegister.calculateTotal();

    assertThat(total).isEqualTo(ZERO);
  }

  @Test
  public void oneTaxableProductScanned_calculateTotal_shouldApplyTaxesToProductPrice() {
    cashRegister.scanProduct(A_PRODUCT_NAME, PRODUCT_PRICE, TAXABLE);

    double total = cashRegister.calculateTotal();

    assertThat(total).isEqualTo(PRODUCT_PRICE_WITH_TAXES);
  }

  @Test
  public void oneNonTaxableProductScanned_calculateTotal_shouldNotApplyTaxesToProductPrice() {
    cashRegister.scanProduct(A_PRODUCT_NAME, PRODUCT_PRICE, NON_TAXABLE);

    double total = cashRegister.calculateTotal();

    assertThat(total).isEqualTo(PRODUCT_PRICE);
  }

}
