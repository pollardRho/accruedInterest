package client.modell.date.rolling;

import java.time.LocalDate;

public interface BusinessDayCalendar {

	public boolean isBusinessDay(LocalDate day);

}
