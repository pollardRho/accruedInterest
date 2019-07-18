package client.modell.bond;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import domain.service.validator.ModellCheckException;

public class Bond {

	/**
	 * https://en.wikipedia.org/wiki/Bond_(finance)
	 */

	public List<CashFlow> cashflows;
	public DayCountConvention dayCountConvention;
	public PaymentFrequency paymentFrequency;

	public CouponMethode couponMethode;

	public LocalDate getStartDate() {
		return cashflows.iterator().next().interval.getBegin();
	}

	public void validate() throws ModellCheckException {
		validateModell(this);
	}

	public void setRate(BigDecimal rate) {
		for (CashFlow cf : cashflows) {
			cf.rate = rate;
		}
	}

	private void validateModell(Bond bond) throws ModellCheckException {
		if (bond.cashflows == null || bond.cashflows.isEmpty()) {
			throw new ModellCheckException("No Cashflow found");
		}

		if (bond.dayCountConvention == null) {
			throw new ModellCheckException("No day count convention found");
		}
	}
}
