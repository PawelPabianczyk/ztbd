package pl.pk.ztbdrelational.projection;

import java.math.BigDecimal;

public class AmountToPayBySubjectView {

  private final String firstName;

  private final String surname;

  private final BigDecimal amountToPay;

  public AmountToPayBySubjectView(String firstName, String surname, BigDecimal amountToPay) {
    this.firstName = firstName;
    this.surname = surname;
    this.amountToPay = amountToPay;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurname() {
    return surname;
  }

  public BigDecimal getAmountToPay() {
    return amountToPay;
  }

  @Override
  public String toString() {
    return "AmountToPayBySubjectView{"
        + "firstName='"
        + firstName
        + '\''
        + ", surname='"
        + surname
        + '\''
        + ", amountToPay="
        + amountToPay
        + '}';
  }
}
