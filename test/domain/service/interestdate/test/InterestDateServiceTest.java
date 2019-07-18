package domain.service.interestdate.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import client.modell.bond.Bond;
import client.modell.bond.DayCountConvention;
import domain.service.interestdate.InterestDateService;
import domain.service.test.BondExampleFactory;

public class InterestDateServiceTest {

	private static final LocalDate MONDAY = LocalDate.parse("2017-07-03");
	private static final LocalDate TUESDAY = LocalDate.parse("2017-07-04");

	private static final Bond BOND = BondExampleFactory.getBond("113504");

	@Test
	public void test() {
		assertEquals(InterestDateService.getInterestDate(BOND, TUESDAY), MONDAY);
	}

	@Test
	public void test2() {

		BOND.dayCountConvention = DayCountConvention.GERMAN_METHOD;
		assertEquals(InterestDateService.getInterestDate(BOND, LocalDate.of(2017, 10, 31)), LocalDate.of(2017, 10, 29));
	}

	@Test
	public void test3() {

		BOND.dayCountConvention = DayCountConvention.GERMAN_METHOD;
		assertEquals(InterestDateService.getInterestDate(BOND, LocalDate.of(2017, 11, 1)), LocalDate.of(2017, 10, 30));
	}

}
