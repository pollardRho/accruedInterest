package client.modell.bond;

public enum DayCountConvention {

	/*
	 * See https://en.wikipedia.org/wiki/Day_count_convention
	 */

	ICMA(DayCountDenominator.ACT, DayCountDivisor.ACT),

	ISDA(DayCountDenominator.ACT, DayCountDivisor.ACT),

	ACT_365(DayCountDenominator.ACT, DayCountDivisor._365),

	FRENCH_METHOD(DayCountDenominator.ACT, DayCountDivisor._360),

	GERMAN_METHOD(DayCountDenominator._30, DayCountDivisor._360),

	_30_365(DayCountDenominator._30, DayCountDivisor._365),

	ENGLISH_METHOD(DayCountDenominator.ACT, DayCountDivisor.ACT);

	private final DayCountDenominator denominator;
	private final DayCountDivisor divisor;

	DayCountConvention(DayCountDenominator denominator, DayCountDivisor divisor) {
		this.denominator = denominator;
		this.divisor = divisor;
	}

	public DayCountDenominator getDenominalor() {
		return this.denominator;
	}

	public DayCountDivisor getDivisor() {
		return this.divisor;
	}

}
