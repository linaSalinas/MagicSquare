package exception;

public class NotOddNumberException extends Exception {
	
    private int order;
	
	public NotOddNumberException(int order) {
		this.order = order;
	}
	
	public String getMessage() {
		return "The number is not odd";
	}


}
