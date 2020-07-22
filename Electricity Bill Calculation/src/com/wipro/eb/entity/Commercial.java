package com.wipro.eb.entity;

public class Commercial extends Connection{
	
	public Commercial(int currentReading,int previousReading,float slabs[])
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
		}
		float elecduty=0.0f;
		if(cost<5000)
		{
			elecduty=cost*0.02f;
		}
		else if(cost<10000)
		{
			elecduty=cost*0.06f;
		}
		else
		{
			elecduty=cost*0.09f;
		}
		
		//System.out.println("cost at computebill in comm is "+(cost+elecduty));
		return cost+elecduty;
	}
}
