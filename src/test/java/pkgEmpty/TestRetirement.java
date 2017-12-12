package test.java.pkgEmpty;

import org.junit.Test;
import org.junit.Assert;
import main.java.pkgCore.Retirement;

/**
 * Description: test class for retirement
 * <p>
 * User: admin
 * Date: 2017-12-11
 * JDK: 1.8
 * <p>
 *
 * @version 1.0
 */
public class TestRetirement {
    @Test
    public void testAmountToSave() {
        Retirement retirement = new Retirement(40, 0.07,20, 0.02, 10000.00, 2642.00);
        Assert.assertEquals(554.1291237405718,retirement.AmountToSave(),0.0);

    }

    @Test
    public void testTotalAmountSaved() {
        Retirement retirement = new Retirement(40, 0.07,20, 0.02, 10000.00, 2642.00);
        Assert.assertEquals(1454485.5484009797,retirement.TotalAmountSaved(),0.0);
    }

}
