package domain.service.interestservice;

import java.math.BigDecimal;

import client.modell.bond.Bond;

public class InterestRoundingService {

	static BigDecimal round(BigDecimal interest, Bond bond) {

		return interest.setScale(4, BigDecimal.ROUND_HALF_UP);

	}

}
