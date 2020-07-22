package com.wipro.eb.entity;

public class Domestic extends Connection
{
	public Domestic (int currentReading, int previousReading,float slabs[])
	{
		
		super(currentReading,previousReading,slabs);
	}

	public float computeBill()
	{
		float cost=0.f;
		int units=currentReading-previousReading;
		if(units<50)
		{
			cost=units*slabs[0];
		}
		else if(units<100)
		{
			cost=50*slabs[0]+(units-50)*slabs[1];
		}
		else 
		{
			cost=50*slabs[0]+50*slabs[1]+(units-100)*slabs[2];
			//System.out.println("cost at computebill is "+cost+"units ="+units);
		}
		
		return cost;
	}
}
