package domain.service.daysinyear;

import java.math.BigDecimal;

import client.modell.AccruedInterestOUT;
import client.modell.bond.Bond;
import client.modell.bond.DayCountDivisor;

public class DaysInYearService {

	public static BigDecimal getDaysInYear(Bond bond, AccruedInterestOUT accruedInterest) {

		BigDecimal freqeuncyFactor = BigDecimal.valueOf(12).divide(bond.paymentFrequency.getNumberOfAnnualPayments());

		if (DayCountDivisor.ACT.equals(bond.dayCountConvention.getDivisor())) {
			if (accruedInterest.cashflow.containsLeapDate()) {
				return DayCountDivisor._366.getBigDecimal().divide(freqeuncyFactor);
			}
			return DayCountDivisor._365.getBigDecimal().divide(freqeuncyFactor);
		}

		return bond.dayCountConvention.getDivisor().getBigDecimal().divide(freqeuncyFactor);
	}

}
