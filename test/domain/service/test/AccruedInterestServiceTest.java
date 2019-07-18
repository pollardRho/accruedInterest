package domain.service.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import client.modell.AccruedInterestIN;
import client.modell.AccruedInterestOUT;
import client.modell.date.rolling.DateRolling;
import domain.service.AccruedInterestService;
import domain.service.validator.ModellCheckException;

public class AccruedInterestServiceTest {

	private static final DateRolling STANDARD_DATE_ROLLING = BondExampleFactory.getStandardDateRolling();

	private AccruedInterestService service = new AccruedInterestService();

	@Test
	public void test() throws ModellCheckException {

		AccruedInterestIN in = new AccruedInterestIN();
		in.tradeDate = LocalDate.parse("2017-10-05");
		in.bond = BondExampleFactory.getBond(BondExampleFactory.GERMAN_BOND);
		in.rolling = STANDARD_DATE_ROLLING;
		in.tradedNominalValue = BigDecimal.valueOf(1000);

		AccruedInterestOUT out = service.getAccruedInterest(in);

		assertEquals(out.daysInYear, BigDecimal.valueOf(365));
		assertEquals(out.tradeDate, LocalDate.parse("2017-10-05"));
		assertEquals(out.interestValueDate, LocalDate.parse("2017-10-09"));
		assertEquals(out.valueDate, LocalDate.parse("2017-10-08"));
		assertEquals(BigDecimal.valueOf(97), out.interestDays);
		assertEquals(out.interest, BigDecimal.valueOf(1727.3973));

	}

	@Test
	public void test2() throws ModellCheckException {

		AccruedInterestIN in = new AccruedInterestIN();
		in.tradeDate = LocalDate.of(2017, 10, 5);
		in.bond = BondExampleFactory.getBond(BondExampleFactory.US_BOND);
		in.rolling = STANDARD_DATE_ROLLING;
		in.tradedNominalValue = BigDecimal.valueOf(1000);

		AccruedInterestOUT out = service.getAccruedInterest(in);

		assertEquals(out.daysInYear, BigDecimal.valueOf(182.5));
		assertEquals(out.tradeDate, LocalDate.parse("2017-10-05"));
		assertEquals(out.interestValueDate, LocalDate.parse("2017-10-09"));
		assertEquals(out.valueDate, LocalDate.parse("2017-10-08"));
		assertEquals(BigDecimal.valueOf(147), out.interestDays);
		assertEquals(out.interest, BigDecimal.valueOf(1.35925));

	}

}
