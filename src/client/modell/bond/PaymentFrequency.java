package client.modell.bond;

import java.math.BigDecimal;

public enum PaymentFrequency {

	ANNUAL(BigDecimal.valueOf(12)), HALF_YEARLY(BigDecimal.valueOf(6)), QUARTERLY(BigDecimal.valueOf(3)), MONTHLY(
			BigDecimal.ONE);

	PaymentFrequency(BigDecimal frequency) {
		this.value = frequency;
	}

	private final BigDecimal value;

	public BigDecimal getNumberOfAnnualPayments() {
		return value;
	}

}
