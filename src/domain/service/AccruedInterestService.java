package domain.service;

import client.modell.AccruedInterestIN;
import client.modell.AccruedInterestOUT;
import domain.service.cashflow.CashflowService;
import domain.service.daysinyear.DaysInYearService;
import domain.service.interestdate.InterestDateService;
import domain.service.interestdayservice.InterestDayService;
import domain.service.interestservice.InterestService;
import domain.service.settlementdate.SettlementDateService;
import domain.service.validator.ModellCheckException;

public class AccruedInterestService {

	public AccruedInterestOUT getAccruedInterest(AccruedInterestIN in) throws ModellCheckException {

		in.bond.validate();

		AccruedInterestOUT out = new AccruedInterestOUT();

		out.tradeDate = in.tradeDate;
		out.interestValueDate = SettlementDateService.getSettlementDate(in.rolling, in.tradeDate);
		out.valueDate = InterestDateService.getInterestDate(in.bond, out.interestValueDate);
		out.cashflow = CashflowService.findCashflow(in.bond, out);
		out.interestDays = InterestDayService.getAccruedInterestDays(in.bond, out);
		out.daysInYear = DaysInYearService.getDaysInYear(in.bond, out);
		out.interest = InterestService.getInterest(out, in.tradedNominalValue);

		return out;
	}

}
