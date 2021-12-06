package fr.eni.papeterie.bll;

public class BLLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BLLException() {
		super();
	}

	public BLLException(String message) {
		super(message);
	}

	public BLLException(String message, Throwable cause) {
		super(message, cause);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
