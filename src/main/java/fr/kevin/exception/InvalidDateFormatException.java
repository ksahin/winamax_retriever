package fr.kevin.exception;

public class InvalidDateFormatException extends Exception{
	public InvalidDateFormatException(String message){
		super("Date must match dd/MM/yyyy pattern, sent : "+message);
	}
}
