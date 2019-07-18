package domain.service.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import client.modell.bond.Bond;
import client.modell.bond.CashFlow;
import client.modell.bond.CouponMethode;
import client.modell.bond.DayCountConvention;
import client.modell.bond.Interval;
import client.modell.bond.PaymentFrequency;
import client.modell.date.rolling.DateRolling;
import domain.service.settlement.business.calendar.GermanBusinessDayCalender;

public class BondExampleFactory {

	public static final String US_BOND = "A1ZHW3";
	public static final String GERMAN_BOND = "113504";

	public static Bond getBond(String id) {
		Bond bond = new Bond();

		if (id == GERMAN_BOND) {
			bond.dayCountConvention = DayCountConvention.ICMA;
			bond.paymentFrequency = PaymentFrequency.ANNUAL;
			bond.cashflows = getCashflow(PaymentFrequency.ANNUAL, 30, LocalDate.parse("1997-07-04"));
			bond.couponMethode = CouponMethode.VARIABLE_COUPON_DATE;
			bond.setRate(BigDecimal.valueOf(6.5));
		}

		if (id == US_BOND) {
			bond.dayCountConvention = DayCountConvention.ICMA;
			bond.paymentFrequency = PaymentFrequency.HALF_YEARLY;
			bond.cashflows = getCashflow(PaymentFrequency.HALF_YEARLY, 60, LocalDate.parse("2014-05-15"));
			bond.couponMethode = CouponMethode.VARIABLE_COUPON_DATE;
			bond.setRate(BigDecimal.valueOf(3.375));
		}

		return bond;
	}

	public static DateRolling getStandardDateRolling() {
		GermanBusinessDayCalender calendar = new GermanBusinessDayCalender();
		DateRolling settlement = new DateRolling();
		settlement.businessDayCalendar = calendar;
		settlement.days = BigDecimal.valueOf(2);
		return settlement;

	}

	public static ArrayList<CashFlow> getCashflow(PaymentFrequency frequency, int num, LocalDate start) {
		ArrayList<CashFlow> cashflows = new ArrayList<CashFlow>();

		LocalDate begin = start;
		for (int i = 0; i < num; ++i) {
			LocalDate end = begin.plusMonths(frequency.getNumberOfAnnualPayments().longValue());
			cashflows.add(new CashFlow(new Interval(begin, end)));
			begin = end;
		}

		return cashflows;
	}
}
