package pl.pk.ztbdrelational.projection;

import java.math.BigDecimal;

public record AmountToPayBySubjectView(String firstName, String surname, BigDecimal amountToPay) {}
