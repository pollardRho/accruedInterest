package domain.service.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import domain.service.settlementdate.test.SettlementDateServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ AccruedInterestServiceTest.class, EasterTest.class, SettlementDateServiceTest.class })
public class AllTests {

}
