# Electicity_bill_calculation_wtn
Project building implemention on electricity Bill calculation in WTN milestone 1

Project Objective:
Create a console based Java application that would allow an electricity board clerk to compute the electricity bill amount that needs to be paid by the customer for a given type of electricity connection
Details:
There are two types of electric connections available. One is Domestic Connection and the other one is Commercial Connection. The following are the formulas that are to be used for computation of Bill for each type.
Domestic
Unit Slabs	Tariff Rate
First 50 units	2.3
Next 50 units	4.2
Remaining units	5.5
 
Eg) If units consumed is 120, then amount payable is 435.
Commercial
Unit Slabs	Tariff Rate
First 50 units	5.2
Next 50 units	6.8
Remaining units	8.3
 
In Commercial Connection type, in addition to the bill amount there is an electricity duty that is applicable. The calculations for the electricity duty is as follows:
BillAmount	Electricity Duty
Bill Amount >= 10000	0.09
Bill Amount >=5000	0.06
Bill Amount < 5000	0.02
 
For example, if Bill Amount>10000 then
Electricity Duty=Bill Amount* 0.09
So the Final Amount Payable =Bill Amount + Electricity Duty
Eg) If units consumed is 120, then amount payable is 781.32 (i.e. 766 + 15.32)
Project Design:
A. System Design:
Name of the package	Usage
com.wipro.eb.entity	This package will contain the EB Connection related classes
com.wipro.eb.exception	This package will contain the user defined exception classes
com.wipro.eb.main	This package will contain the MainClass that is used to test the application
com.wipro.eb.service	This package will contain the class that is used to validate the data and invoke the respective EB Connection Classes to calculate the bill amount
Package: com.wipro.eb.exception
Class	Method and Variables	Description
InvalidReadingException	 	A user defined exception class. Details about when this exception is given in the respective methods
 	public String toString()	This function should return
“Incorrect Reading”
Package: com.wipro.eb.exception
Class	 	Description
InvalidConnectionException	 	A user defined exception class. Details about when this exception is given in the respective methods
 	public String toString()	This function should return
“Invalid ConnectionType”
Package: com.wipro.eb.entity
Class	Method and Variables	Description
Connection	 	Abstract Class
 	int previousReading;	Previous month meter reading
 	int currentReading;	Current month meter reading
 	float[] slabs;	Used to store different slab rate
 	public Connection(int currentReading, int previousReading,float slabs[])	A constructor used to initialize the member variables
 	public abstract float computeBill()	An abstract method to compute the bill for a particular month
 	Getter and Setter methods for all the member variables	Getter and Setter methods for all member variables
Package: com.wipro.eb.entity
Class	Method and Variables	Description
Domestic	 	Inherits Connection Class
 	public Domestic(int currentReading, int previousReading,float slabs[])	A parameterized constructor
 	public float computeBill()	Should compute the amount to be paid by the customer for the given reading. Use the formula that is given at the beginning of the case study
 
Package: com.wipro.eb.entity
Class	Method and Variables	Description
Commercial	 	Inherits Connection Class
 	public Commercial(int currentReading, int previousReading,float slabs[])	A parameterized constructor
 	public float computeBill()	Should compute the amount to be paid by the customer for the given reading. Use the formula that is given at the beginning of the case study
 
Package : com.wipro.eb.service
Class	Method and Variables	Description
ConnectionService	 	Class
 	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException	·         If the currentReading is less than previousReading or if any of the readings are negative then the function should throw InvalidReadingException
·         If the type is anything other than Domestic or Commercial the function should throw InvalidConnectionException
·         If all the 3 data are valid the function should return true
 	public float calculateBillAmt(int currentReading, int previousReading, String type)	·         This method will invoke the validate method to check whether all the 3 inputs received are valid
·         If the validate method throws InvalidReadingException, this function should handle it and return -1
·         If the validate method throws InvalidConnectionException, this function should handle it and return -2
·         If the validate method returns true this function should create appropriate Connection type object and invoke the computeBill method and return the computed billamount.
[If type is “Domestic”, then the Domestic object needs to be created If type is “Commercial”, then the Commercial object needs to be created.]
 	public String generateBill(int currentReading, int previousReading, String type)	·         This method should invoke the calculateBillAmt method.
·         If the return value of calculateBillAmt is -1, this method should return “Incorrect Reading”
·         If the return value of calculateBillAmt is -2, this method should return “Invalid ConnectionType”
·         Else this method should return a String in the following format. Suppose the return value of calculateBillAmt is 256, then this function should return “Amount to be paid:256”
 
Package : com.wipro.eb.main
Class	Method and Variables	Description
EBMain	 	Main Class
 	public static void main(String[] args)	Get the following input from the user
1.   	Get the previous month reading
2.   	Get the current month reading
3.   	Get the Connection Type
After receiving all this data, invoke the generateBill method of ConnectionService class present in com.wipro.eb.service package and test your program

