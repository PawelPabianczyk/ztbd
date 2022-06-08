package pl.pk.ztbdrelational.projection;

import java.time.LocalDate;

public record NotDeliveredSentParcelsView(Long parcelId, String firstName, String surname, String parcelType,
                                          LocalDate postingDate, LocalDate deliveryDate) {}
