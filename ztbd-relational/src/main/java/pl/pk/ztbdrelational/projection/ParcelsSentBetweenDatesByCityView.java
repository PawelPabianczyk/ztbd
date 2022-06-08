package pl.pk.ztbdrelational.projection;

public class ParcelsSentBetweenDatesByCityView {

  private final String city;
  private final Long numberOfParcels;

  public ParcelsSentBetweenDatesByCityView(String city, Long numberOfParcels) {
    this.city = city;
    this.numberOfParcels = numberOfParcels;
  }

  public String getCity() {
    return city;
  }

  public Long getNumberOfParcels() {
    return numberOfParcels;
  }
}
