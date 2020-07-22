package com.wipro.eb.exception;

public class InvalidConnectionException extends Exception {

	public String toString()
	{
		return "Invalid ConnectionType";
	}
	public InvalidConnectionException(String str)
	{
		super(str);
	}
}