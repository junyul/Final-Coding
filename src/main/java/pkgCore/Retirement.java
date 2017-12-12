package main.java.pkgCore;

import org.junit.Test;
import org.apache.poi.ss.formula.functions.*;

/**
 * Description: The class to handler the calculation
 * <p>
 * User: admin
 * Date: 2017-12-10
 * JDK: 1.8
 * <p>
 *
 * @author admin
 * @version 1.0
 */
public class Retirement {
    private int iYearsToWork;
    private double dAnnualReturnWorking;
    private int iYearsRetired;
    private double dAnnualReturnRetired;
    private double dRequiredIncome;
    private double dMonthlySSI;

    //TODO: Build the constructor, getters and setters for the attributes above.

    /**
     * constrictor
     * @param iYearsToWork years to work
     * @param dAnnualReturnWorking annual return working
     * @param iYearsRetired years retired
     * @param dAnnualReturnRetired annual return retired
     * @param dRequiredIncome required income
     * @param dMonthlySSI monthly ssi
     */
    public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired, double dRequiredIncome, double dMonthlySSI) {
        this.iYearsToWork = iYearsToWork;
        this.dAnnualReturnWorking = dAnnualReturnWorking;
        this.iYearsRetired = iYearsRetired;
        this.dAnnualReturnRetired = dAnnualReturnRetired;
        this.dRequiredIncome = dRequiredIncome;
        this.dMonthlySSI = dMonthlySSI;
    }

    /**
     * get the years worked
     * @return years
     */
    public int getiYearsToWork() {
        return iYearsToWork;
    }

    /**
     * set the years to work
     * @param iYearsToWork years to work
     */
    public void setiYearsToWork(int iYearsToWork) {
        this.iYearsToWork = iYearsToWork;
    }

    /**
     * get annual return working
     * @return annual return working
     */
    public double getdAnnualReturnWorking() {
        return dAnnualReturnWorking;
    }

    /**
     * set annual return working
     * @param dAnnualReturnWorking annual return working
     */
    public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
        this.dAnnualReturnWorking = dAnnualReturnWorking;
    }

    /**
     * get years retired
     * @return years retired
     */
    public int getiYearsRetired() {
        return iYearsRetired;
    }

    /**
     * set years retired
     * @param iYearsRetired years retired
     */
    public void setiYearsRetired(int iYearsRetired) {
        this.iYearsRetired = iYearsRetired;
    }

    /**
     * get annual return retired
     * @return annual return retired
     */
    public double getdAnnualReturnRetired() {
        return dAnnualReturnRetired;
    }

    /**
     * set annual return retired
     * @param dAnnualReturnRetired annual return retired
     */
    public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
        this.dAnnualReturnRetired = dAnnualReturnRetired;
    }

    /**
     * get required income
     * @return required income
     */
    public double getdRequiredIncome() {
        return dRequiredIncome;
    }

    /**
     * set required income
     * @param dRequiredIncome required income
     */
    public void setdRequiredIncome(double dRequiredIncome) {
        this.dRequiredIncome = dRequiredIncome;
    }

    /**
     * get monthly ssi
     * @return monthly ssi
     */
    public double getdMonthlySSI() {
        return dMonthlySSI;
    }

    /**
     * set monthly ssi
     * @param dMonthlySSI monthly ssi
     */
    public void setdMonthlySSI(double dMonthlySSI) {
        this.dMonthlySSI = dMonthlySSI;
    }

    /**
     * to calculate amount to save
     * @return the amount to save
     */
    @Test
    public double AmountToSave()
    {
        //TODO: Determine the amount to save each month based on TotalAmountSaved, YearsToWork
        //		and Annual return while working
        double rAnnualReturnRetired = dAnnualReturnRetired / 12;
        double dMonthsRetired = iYearsRetired * 12;
        double rAnnualReturnWorking = dAnnualReturnWorking / 12;
        double dMonthsToWork = iYearsToWork * 12;
        double pv = FinanceLib.pv(rAnnualReturnRetired, dMonthsRetired, dRequiredIncome - dMonthlySSI, 0, false);

        double pmt = FinanceLib.pmt(rAnnualReturnWorking, dMonthsToWork, 0, pv, false);
//        System.out.println(pmt);
        return pmt;

    }

    /**
     * to calculate total amount
     * @return total amount
     */
    @Test
    public double TotalAmountSaved()
    {
        //	TODO: Determine amount to be saved based on Monthly SSI, Required Income, Annual return during retirement
        //		and number of years retired.
        //
        double rAnnualReturnRetired = dAnnualReturnRetired / 12;
        double dMonthsRetired = iYearsRetired * 12;
        double pv = FinanceLib.pv(rAnnualReturnRetired, dMonthsRetired, dRequiredIncome - dMonthlySSI, 0, false);
//        System.out.println(-pv);
        return (-pv);
    }
}
