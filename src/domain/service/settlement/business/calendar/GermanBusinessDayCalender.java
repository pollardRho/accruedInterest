package domain.service.settlement.business.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import client.modell.date.rolling.BusinessDayCalendar;

public class GermanBusinessDayCalender implements BusinessDayCalendar {

	private Easter easter = new Easter();

	public boolean isBusinessDay(LocalDate day) {

		// Weekend
		if (day.getDayOfWeek() == DayOfWeek.SATURDAY || day.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return false;
		}

		// New Year
		if (day.getMonth() == Month.JANUARY && day.getDayOfMonth() == 1) {
			return false;
		}

		// International Workers' Day
		if (day.getMonth() == Month.MAY && day.getDayOfMonth() == 1) {
			return false;
		}

		// German Unity Day
		if (day.getMonth() == Month.OCTOBER && day.getDayOfMonth() == 3) {
			return false;
		}

		// Christmas
		if (day.getMonth() == Month.DECEMBER) {
			if (day.getDayOfMonth() == 25 || day.getDayOfMonth() == 25) {
				return false;
			}
		}

		// Easter
		LocalDate easterSunday = easter.getEasterSunday(day.getYear());
		if (easterSunday.minusDays(2) == day || easterSunday.plusDays(1) == day) {
			return false;
		}

		return true;
	}
}
