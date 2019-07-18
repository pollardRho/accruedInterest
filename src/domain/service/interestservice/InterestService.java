package domain.service.interestservice;

import java.math.BigDecimal;
import java.math.RoundingMode;

import client.modell.AccruedInterestOUT;

public class InterestService {

	public static BigDecimal getInterest(AccruedInterestOUT accruedInterest, BigDecimal nominal) {

		BigDecimal interest = nominal.multiply(accruedInterest.cashflow.rate)
				.multiply(accruedInterest.interestDays.divide(accruedInterest.daysInYear, 10, RoundingMode.HALF_UP));

		return InterestRoundingService.round(interest, null);

	}

}
