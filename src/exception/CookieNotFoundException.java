package exception;

@SuppressWarnings("serial")
public class CookieNotFoundException extends Exception {

	public CookieNotFoundException(){
		super();
	}
	
	public CookieNotFoundException(String msg){
		super(msg);
	}
}
