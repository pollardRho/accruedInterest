package client.modell.bond;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class CashFlow {

	/**
	 * https://en.wikipedia.org/wiki/Cash_flow
	 * 
	 * @param interval
	 *            {@link Interval}
	 * @param rate
	 *            Interest rate of the cash flow
	 */

	public CashFlow(Interval interval, BigDecimal rate) {
		this.interval = interval;
		this.rate = rate;
		this.type = CashFlowType.REGULAR;
	}

	public CashFlow(Interval interval) {
		this.interval = interval;
		this.type = CashFlowType.REGULAR;
	}

	public Interval interval;
	public BigDecimal rate;
	public CashFlowType type;

	/**
	 * @return Check if the cash flow contains the 29th of February
	 */
	public boolean containsLeapDate() {

		for (LocalDate date = this.interval.getBegin(); date
				.isBefore(this.interval.getEnd()); date = date.plusDays(1L)) {
			if (date.getMonth() == Month.FEBRUARY && date.getDayOfMonth() == 29)
				return true;
		}
		return false;
	}

}
