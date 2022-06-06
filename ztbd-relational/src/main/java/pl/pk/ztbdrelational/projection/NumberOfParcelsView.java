package pl.pk.ztbdrelational.projection;

public class NumberOfParcelsView {

  private final String firstName;

  private final String surname;

  private final long numberOfParcels;

  public NumberOfParcelsView(String firstName, String surname, long numberOfParcels) {
    this.firstName = firstName;
    this.surname = surname;
    this.numberOfParcels = numberOfParcels;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurname() {
    return surname;
  }

  public long getNumberOfParcels() {
    return numberOfParcels;
  }
}
