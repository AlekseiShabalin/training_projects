package ru.ashabalin.models;

/**
 * @author Aleksei Shabalin on 21.09.2016.
 */
public class WrongStepException extends RuntimeException {
	public WrongStepException(String message) {
		super(message);
	}
}
