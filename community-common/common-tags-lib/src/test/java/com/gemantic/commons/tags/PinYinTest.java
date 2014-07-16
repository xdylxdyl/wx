package com.gemantic.commons.tags;

import java.text.ParseException;

import javax.servlet.jsp.JspException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;

public class PinYinTest {
	private static final Log log = LogFactory.getLog(PinYinTest.class);

	@Ignore
	@Test
	public void testTime() throws ParseException, JspException {
		/*
		 * String time=""; Long p = 1281542400000L; Long s= 1281542400000L;
		 * 
		 * DateDiff dd=new DateDiff(); dd.setDate1(p+""); dd.setDate2(s+"");
		 * dd.doStartTag();
		 */

		String value = "中杭重机";

		PinYin pin = new PinYin();
		pin.setValue(value);
		pin.setPattern("full");
		pin.doStartTag();

		pin.setPattern("");
		pin.doStartTag();

	}
}
