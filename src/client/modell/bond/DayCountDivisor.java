package client.modell.bond;

import java.math.BigDecimal;

public enum DayCountDivisor {

	ACT(null), _360(BigDecimal.valueOf(360)), _365(BigDecimal.valueOf(365)), _366(BigDecimal.valueOf(366));
	private final BigDecimal divisor;

	DayCountDivisor(BigDecimal divisor) {
		this.divisor = divisor;
	}

	public BigDecimal getBigDecimal() {
		return this.divisor;
	}
}
