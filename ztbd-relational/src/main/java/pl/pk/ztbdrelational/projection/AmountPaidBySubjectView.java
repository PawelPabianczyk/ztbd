package pl.pk.ztbdrelational.projection;

import java.math.BigDecimal;

public record AmountPaidBySubjectView(String firstName, String surname, BigDecimal amount) {
}
