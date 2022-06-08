package pl.pk.ztbdrelational.projection;

import java.math.BigDecimal;

public record MaxAmountBySubjectView(String firstName, String surname, BigDecimal maxAmount) {
}
