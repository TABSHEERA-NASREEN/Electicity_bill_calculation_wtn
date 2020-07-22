package com.wipro.eb.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionServiceTest1 {


	ConnectionService cs;
	Domestic d;
	Commercial c;
	@Before 
	public void setup()
	{
		cs=new ConnectionService();
		
	}
	@Test
	public void testValidate() throws InvalidReadingException, InvalidConnectionException  {
		//fail("Not yet implemented");

			assertEquals(true,cs.validate(120, 0,"domestic"));
	        assertEquals(true,cs.validate(120,30,"commercial"));

			try {
				assertEquals("Incorrect Reading",cs.validate(-9, 120,"domestic"));
			} catch (InvalidReadingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
			assertEquals("Invalid Connection Type",cs.validate(120,0,"comm"));
			}
			catch (InvalidReadingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

   @Test
	public void testCalculateBillAmt() {
		//fail("Not yet implemented");
	   assertEquals(435.0,cs.calculateBillAmt(240,120,"domestic"),0.0);
	   assertEquals(781.3200073242188,cs.calculateBillAmt(120,0,"commercial"),0.0);
	   assertEquals(-1.0,cs.calculateBillAmt(0,120,"domestic"),0.0);
	   assertEquals(-2.0,cs.calculateBillAmt(2000,120,"dome"),0.0);
	}

	@Test
	public void testGenerateBill() {
		//fail("Not yet implemented");
		assertEquals("Amount to be paid is:435.0",cs.generateBill(120,0,"domestic"));
		assertEquals("Amount to be paid is:781.32",cs.generateBill(240,120,"commercial"));
		assertEquals("Incorrect Reading",cs.generateBill(0,12,"domestic"));
		assertEquals("Invalid Connection Type",cs.generateBill(20,12,"dom"));
	} 

}
