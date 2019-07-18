package domain.service.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import domain.service.settlement.business.calendar.Easter;

public class EasterTest {

	private Easter easter = new Easter();

	@Test
	public void checkEasterDates() {

		assertEquals(easter.getEasterSunday(2017), LocalDate.parse("2017-04-16"));

		assertEquals(easter.getEasterSunday(2018), LocalDate.parse("2018-04-01"));

		assertEquals(easter.getEasterSunday(2019), LocalDate.parse("2019-04-21"));

		assertEquals(easter.getEasterSunday(2020), LocalDate.parse("2020-04-12"));

		assertEquals(easter.getEasterSunday(2021), LocalDate.parse("2021-04-04"));

	}

}
