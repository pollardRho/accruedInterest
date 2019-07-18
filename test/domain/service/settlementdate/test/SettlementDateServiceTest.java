package domain.service.settlementdate.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import client.modell.date.rolling.DateRolling;
import domain.service.settlement.business.calendar.GermanBusinessDayCalender;
import domain.service.settlementdate.SettlementDateService;

public class SettlementDateServiceTest {

	/*
	 * Test cases from chapter 1.3 of the book Michael Hamke - Stückzinsberechnung
	 * in der Praxis
	 */

	private static final LocalDate MONDAY = LocalDate.parse("2017-07-03");
	private static final LocalDate TUESDAY = LocalDate.parse("2017-07-04");
	private static final LocalDate WEDNESDAY = LocalDate.parse("2017-07-05");
	private static final LocalDate THURSDAY = LocalDate.parse("2017-07-06");
	private static final LocalDate FRIDAY = LocalDate.parse("2017-07-07");
	private static final LocalDate SATURDAY = LocalDate.parse("2017-07-08");
	private static final LocalDate NEXT_MONDAY = LocalDate.parse("2017-07-10");
	private static final LocalDate NEXT_TUESDAY = LocalDate.parse("2017-07-11");
	private static final LocalDate NEXT_WEDNESDAY = LocalDate.parse("2017-07-12");

	private DateRolling settlement = new DateRolling();

	@Before
	public void before() {
		settlement.businessDayCalendar = new GermanBusinessDayCalender();
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void businessDayReturnsTheRightValueDate_1() {
		settlement.days = BigDecimal.valueOf(2);
		assertEquals(SettlementDateService.getSettlementDate(settlement, MONDAY), WEDNESDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_2() {
		settlement.days = BigDecimal.valueOf(2);
		assertEquals(SettlementDateService.getSettlementDate(settlement, TUESDAY), THURSDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_3() {
		settlement.days = BigDecimal.valueOf(2);
		assertEquals(SettlementDateService.getSettlementDate(settlement, WEDNESDAY), FRIDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_4() {
		settlement.days = BigDecimal.valueOf(2);
		assertEquals(SettlementDateService.getSettlementDate(settlement, THURSDAY), NEXT_MONDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_5() {
		settlement.days = BigDecimal.valueOf(2);
		assertEquals(SettlementDateService.getSettlementDate(settlement, FRIDAY), NEXT_TUESDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_6() {
		settlement.days = BigDecimal.valueOf(2);
		assertEquals(SettlementDateService.getSettlementDate(settlement, NEXT_MONDAY), NEXT_WEDNESDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_7() {
		settlement.days = BigDecimal.valueOf(3);
		assertEquals(SettlementDateService.getSettlementDate(settlement, TUESDAY), FRIDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_8() {
		settlement.days = BigDecimal.valueOf(3);
		assertEquals(SettlementDateService.getSettlementDate(settlement, WEDNESDAY), NEXT_MONDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_9() {
		settlement.days = BigDecimal.valueOf(3);
		assertEquals(SettlementDateService.getSettlementDate(settlement, THURSDAY), NEXT_TUESDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_10() {
		settlement.days = BigDecimal.valueOf(5);
		assertEquals(SettlementDateService.getSettlementDate(settlement, MONDAY), NEXT_MONDAY);
	}

	@Test
	public void businessDayReturnsTheRightValueDate_11() {
		settlement.days = BigDecimal.ONE;
		assertEquals(SettlementDateService.getSettlementDate(settlement, SATURDAY), NEXT_MONDAY);
	}

	@Test
	public void noSettlementDayGivesBackTheSameBusinessDay() {
		settlement.days = BigDecimal.ZERO;
		assertEquals(SettlementDateService.getSettlementDate(settlement, MONDAY), MONDAY);
	}

	@Test
	public void noSettlementDayGivesBackTheSameNoneBusinessDay() {
		settlement.days = BigDecimal.ZERO;
		assertEquals(SettlementDateService.getSettlementDate(settlement, SATURDAY), SATURDAY);
	}

	@Test
	public void negativNumberOfSettlementDaysGivesExeption() {

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Negative number of value days");

		settlement.days = BigDecimal.ONE.negate();

		SettlementDateService.getSettlementDate(settlement, MONDAY);
	}

}
