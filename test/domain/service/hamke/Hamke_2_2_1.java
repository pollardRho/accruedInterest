package domain.service.hamke;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import client.modell.AccruedInterestIN;
import client.modell.AccruedInterestOUT;
import client.modell.bond.Bond;
import client.modell.bond.DayCountConvention;
import client.modell.bond.PaymentFrequency;
import client.modell.date.rolling.DateRolling;
import domain.service.AccruedInterestService;
import domain.service.test.BondExampleFactory;
import domain.service.validator.ModellCheckException;

public class Hamke_2_2_1 {

	private static final DateRolling STANDARD_DATE_ROLLING = BondExampleFactory.getStandardDateRolling();

	AccruedInterestService service = new AccruedInterestService();

	AccruedInterestIN in = new AccruedInterestIN();

	@Before
	public void before() {
		Bond bond = new Bond();
		bond.dayCountConvention = DayCountConvention.GERMAN_METHOD;
		bond.paymentFrequency = PaymentFrequency.ANNUAL;
		bond.cashflows = BondExampleFactory.getCashflow(PaymentFrequency.ANNUAL, 30, LocalDate.parse("2000-03-17"));
		bond.setRate(BigDecimal.ZERO);

		in.bond = bond;
		in.rolling = STANDARD_DATE_ROLLING;
	}

	@Test
	public void beispiel_1() throws ModellCheckException {

		in.tradeDate = LocalDate.of(2000, 7, 12);

		AccruedInterestOUT out = service.getAccruedInterest(in);

		assertEquals(BigDecimal.valueOf(116), out.interestDays);
	}

	@Test
	public void beispiel_2() throws ModellCheckException {

		in.tradeDate = LocalDate.of(2000, 7, 13);

		AccruedInterestOUT out = service.getAccruedInterest(in);

		assertEquals(BigDecimal.valueOf(117), out.interestDays);
	}

	@Test
	public void beispiel_3() throws ModellCheckException {

		in.tradeDate = LocalDate.of(2000, 7, 16);

		AccruedInterestOUT out = service.getAccruedInterest(in);

		assertEquals(BigDecimal.valueOf(120), out.interestDays);
	}

	@Test
	public void beispiel_4() throws ModellCheckException {

		in.tradeDate = LocalDate.of(2000, 7, 17);

		AccruedInterestOUT out = service.getAccruedInterest(in);

		assertEquals(BigDecimal.valueOf(121), out.interestDays);
	}

}
