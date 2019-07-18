package client.modell.date.rolling;

import java.math.BigDecimal;

public class DateRolling {

	/**
	 * See https://en.wikipedia.org/wiki/Date_rolling
	 */

	/** Number of days to roll backwards so that it falls in a business day **/
	public BigDecimal days;

	/** The underlying business day calendar **/
	public BusinessDayCalendar businessDayCalendar;

}
