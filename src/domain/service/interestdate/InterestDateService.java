package domain.service.interestdate;

import java.time.LocalDate;

import client.modell.bond.Bond;
import client.modell.bond.DayCountConvention;

public class InterestDateService {

	public static LocalDate getInterestDate(Bond bond, LocalDate settlementDate) {

		if (bond.dayCountConvention.equals(DayCountConvention.GERMAN_METHOD)) {
			if (settlementDate.getDayOfMonth() == 1 || settlementDate.getDayOfMonth() == 31) {
				return settlementDate.minusDays(2);
			}
		}
		return settlementDate.minusDays(1);
	}

}
