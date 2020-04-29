package library;

public class CustomException extends Exception {
	
	private static final long serialVersionUID=1L;
	
	public CustomException(Object obj) {
		Log.error(obj.toString());
		
	}
	
	public CustomException(String errorName) {
		super(errorName);
		Log.error(errorName);
	}
	

}
