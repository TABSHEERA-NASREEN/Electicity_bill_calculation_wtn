package com.wipro.eb.service;

import com.wipro.eb.entity.Domestic;
import com.wipro.eb.entity.*;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {

	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		try {
		if(currentReading<previousReading||previousReading<0||currentReading<0)
		{
			throw new InvalidReadingException("invalid");
			//return false;
		}
		else if(!(type.equalsIgnoreCase("domestic")||type.equalsIgnoreCase("commercial")))
		{
			throw new InvalidConnectionException("invalid connection");
			
		}
		else
		{
			return true;
		}
	}
		finally
		{
			
		}
	}
	

	public float calculateBillAmt(int currentReading, int previousReading, String type){
    try{
        boolean status = validate(currentReading, previousReading, type);
        if(type.equalsIgnoreCase("Domestic")){
            float[] slabs = {2.3f, 4.2f, 5.5f};
            Domestic d = new Domestic(currentReading, previousReading, slabs);
           
            return d.computeBill();
        } 
        else
        {
           
            float[] slabs = {5.2f, 6.8f, 8.3f};
            Commercial c = new Commercial(currentReading,previousReading, slabs);
           
            return c.computeBill();
        }
    }
    catch(InvalidReadingException e){
        return -1;
    } 
    catch(InvalidConnectionException e){
        return -2;
    }
}
		
		
	public String generateBill(int currentReading, int previousReading, String type)
	{
		ConnectionService cs=new ConnectionService();
		float a=cs.calculateBillAmt(currentReading, previousReading, type);
		if(a==-1)
		{
			return "Incorrect Reading";
		}
		else if(a==-2)
		{
			 return "Invalid Connection Type";
		}
		else 
		{
			String ans="Amount to be paid is:"+a;
			return ans;
		}
	}
}
