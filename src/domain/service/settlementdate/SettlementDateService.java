package domain.service.settlementdate;

import java.math.BigDecimal;
import java.time.LocalDate;

import client.modell.date.rolling.BusinessDayCalendar;
import client.modell.date.rolling.DateRolling;

public class SettlementDateService {

	/**
	 * Returns the value date for a given contraction date dependent on the given
	 * calendar.
	 */
	public static LocalDate getSettlementDate(final DateRolling settlement, final LocalDate valuationDate) {

		if (settlement.days.longValue() < 0) {
			throw new RuntimeException("Negative number of value days");
		}

		if (settlement.days.equals(BigDecimal.ZERO)) {
			return valuationDate;
		}

		LocalDate valueDate = valuationDate;
		for (int d = 0; d < settlement.days.intValue(); ++d) {
			valueDate = getNextBusinessDay(settlement.businessDayCalendar, valueDate);
		}
		return valueDate;
	}

	/*
	 * Return the next business day due to to the given calendar.
	 */
	private static LocalDate getNextBusinessDay(BusinessDayCalendar calendar, LocalDate date) {
		while (true) {
			date = date.plusDays(1);
			if (calendar.isBusinessDay(date)) {
				return date;
			}
		}
	}

}
