package exception;

@SuppressWarnings("serial")
public class IllegalInfoException extends Exception {

	public IllegalInfoException(){
		super();
	}
	
	public IllegalInfoException(String msg){
		super(msg);
	}
}
