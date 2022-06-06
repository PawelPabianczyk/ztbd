package pl.pk.ztbdrelational.projection;

public class ParcelsBySubjectView {

  private final String firstName;

  private final String surname;

  private final long numberOfParcels;

  public ParcelsBySubjectView(String firstName, String surname, long numberOfParcels) {
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

  @Override
  public String toString() {
    return "ParcelsBySubjectView{" +
            "firstName='" + firstName + '\'' +
            ", surname='" + surname + '\'' +
            ", numberOfParcels=" + numberOfParcels +
            '}';
  }
}
