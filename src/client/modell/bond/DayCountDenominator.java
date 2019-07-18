package client.modell.bond;

import java.math.BigDecimal;

public enum DayCountDenominator {

	ACT(null), _30(BigDecimal.valueOf(30));

	private final BigDecimal denominator;

	DayCountDenominator(BigDecimal denominator) {
		this.denominator = denominator;
	}

	public BigDecimal getBigDecimal() {
		return this.denominator;
	}
}
