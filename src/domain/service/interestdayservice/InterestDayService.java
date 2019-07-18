package domain.service.interestdayservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import client.modell.AccruedInterestOUT;
import client.modell.bond.Bond;
import client.modell.bond.DayCountDenominator;

public class InterestDayService {

	public static BigDecimal getAccruedInterestDays(Bond bond, AccruedInterestOUT accruedInterest) {

		LocalDate begin = accruedInterest.cashflow.interval.getBegin();
		LocalDate end = accruedInterest.valueDate;
		DayCountDenominator denominalor = bond.dayCountConvention.getDenominalor();

		if (DayCountDenominator.ACT.equals(denominalor)) {
			return BigDecimal.valueOf(ChronoUnit.DAYS.between(begin, end)).add(BigDecimal.ONE);
		}

		if (DayCountDenominator._30.equals(denominalor)) {
			int dy = end.getYear() - begin.getYear();
			int my = end.getMonth().getValue() - begin.getMonth().getValue();
			int d1 = Math.min(end.getDayOfMonth(), 30);
			int d2 = begin.getDayOfMonth();
			if (d1 == 30) {
				d2 = Math.min(d2, 30);
			}

			return BigDecimal.valueOf(360 * dy + 30 * my + (d2 - d1));
		}

		return null;
	}

}
