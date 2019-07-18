package domain.service.settlement.business.calendar;

import java.time.LocalDate;

public class Easter {

	private int easterSundayMonth;
	private int easterSundayDay;

	public LocalDate getEasterSunday(int year) {
		// https://de.wikipedia.org/wiki/Spencers_Osterformel

		int a = year % 19;
		int b = year / 100;
		int c = year % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = (19 * a + b - d - g + 15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;

		easterSundayMonth = (h - m + r + 90) / 25;
		easterSundayDay = (h - m + r + easterSundayMonth + 19) % 32;

		return LocalDate.parse("" + year + "-" + String.format("%2s", easterSundayMonth).replace(' ', '0') + "-"
				+ String.format("%2s", easterSundayDay).replace(' ', '0'));
	}

}
