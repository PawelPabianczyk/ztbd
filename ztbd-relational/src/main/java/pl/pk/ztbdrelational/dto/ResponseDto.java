package pl.pk.ztbdrelational.dto;

public class ResponseDto {

  private final long time;

  private final long numberOfRecords;

  public ResponseDto(long time, long numberOfRecords) {
    this.time = time;
    this.numberOfRecords = numberOfRecords;
  }

  public long getTime() {
    return time;
  }

  public long getNumberOfRecords() {
    return numberOfRecords;
  }
}
