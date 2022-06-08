package pl.pk.ztbdrelational.projection;

import java.time.LocalDate;

public class NotDeliveredSentParcelsView {

  private final Long parcelId;
  private final String firstName;
  private final String surname;
  private final String parcelType;
  private final LocalDate postingDate;
  private final LocalDate deliveryDate;

  public NotDeliveredSentParcelsView(
      Long parcelId,
      String firstName,
      String surname,
      String parcelType,
      LocalDate postingDate,
      LocalDate deliveryDate) {
    this.parcelId = parcelId;
    this.firstName = firstName;
    this.surname = surname;
    this.parcelType = parcelType;
    this.postingDate = postingDate;
    this.deliveryDate = deliveryDate;
  }

  public Long getParcelId() {
    return parcelId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurname() {
    return surname;
  }

  public String getParcelType() {
    return parcelType;
  }

  public LocalDate getPostingDate() {
    return postingDate;
  }

  public LocalDate getDeliveryDate() {
    return deliveryDate;
  }
}
