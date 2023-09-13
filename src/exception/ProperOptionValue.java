package exception;

public class ProperOptionValue extends Exception {
	public ProperOptionValue() {
		
	}
	
	public ProperOptionValue(String name) {
		super(name);
	}
}
