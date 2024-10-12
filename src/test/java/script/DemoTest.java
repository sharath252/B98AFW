package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



import generic.BaseTest;
import generic.Utility;

public class DemoTest extends BaseTest
{
	@Test
	public void testValidLogin()
	{
		String v = Utility.getExcelData(XL_PATH,"sheet1", 0, 0);
		test.info("xl data:"+v);
		String title=driver.getTitle();
		Reporter.log(title,true);
		test.info("title:"+title);
		Assert.assertEquals("abc","xyz");
	}
}
