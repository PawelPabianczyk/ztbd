package pl.pk.ztbdrelational.projection;

public class ParcelsByCityView {
  private final String city;

  private final long numberOfParcels;

  public ParcelsByCityView(String city, long numberOfParcels) {
    this.city = city;
    this.numberOfParcels = numberOfParcels;
  }

  public String getCity() {
    return city;
  }

  public long getNumberOfParcels() {
    return numberOfParcels;
  }

  @Override
  public String toString() {
    return "ParcelsByCityView{" +
            "city='" + city + '\'' +
            ", numberOfParcels=" + numberOfParcels +
            '}';
  }
}
