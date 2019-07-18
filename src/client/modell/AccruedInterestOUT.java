package client.modell;

import java.math.BigDecimal;
import java.time.LocalDate;

import client.modell.bond.CashFlow;

public class AccruedInterestOUT {

	/**
	 * https://en.wikipedia.org/wiki/Accrued_interest
	 */

	/** Day the trade is made. (https://en.wikipedia.org/wiki/Trade_date) **/
	public LocalDate tradeDate;

	/** Last day the buyer has to pay the accrued interest **/
	public LocalDate interestValueDate;

	/** https://en.wikipedia.org/wiki/Value_date **/
	public LocalDate valueDate;

	/** The corresponding cash flow to the relevant coupon **/
	public CashFlow cashflow;

	/**
	 * When a security is sold between interest payment dates, the seller is
	 * eligible to this number of days of the the coupon amount.
	 **/
	public BigDecimal interestDays;

	public BigDecimal daysInYear;

	public BigDecimal interest;

	public String toString() {
		return "Interest Days: " + interestDays + "/" + daysInYear + ", Interest: " + interest;
	}

}
