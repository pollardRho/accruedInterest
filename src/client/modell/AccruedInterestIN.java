package client.modell;

import java.math.BigDecimal;
import java.time.LocalDate;

import client.modell.bond.Bond;
import client.modell.date.rolling.DateRolling;

public class AccruedInterestIN {

	/** Day the trade is made. (https://en.wikipedia.org/wiki/Trade_date) **/
	public LocalDate tradeDate;

	public Bond bond;

	public DateRolling rolling;

	public BigDecimal tradedNominalValue;

}
