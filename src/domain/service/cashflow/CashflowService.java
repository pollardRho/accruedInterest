package domain.service.cashflow;

import client.modell.AccruedInterestOUT;
import client.modell.bond.Bond;
import client.modell.bond.CashFlow;

public class CashflowService {

	public static CashFlow findCashflow(Bond bond, AccruedInterestOUT accruedInterest) {
		for (CashFlow cashflow : bond.cashflows) {
			if (cashflow.interval.contains(accruedInterest.valueDate)) {
				return cashflow;
			}
		}
		return null;
	}

}
