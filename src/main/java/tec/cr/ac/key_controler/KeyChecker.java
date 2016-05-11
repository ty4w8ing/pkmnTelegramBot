package tec.cr.ac.key_controler;

public class KeyChecker {
	Boolean valid = false;
	
	
	
	public Boolean isValid() {
		return valid;
	}

	private void setValid(Boolean valid) {
		this.valid = valid;
	}

	public void check(String key){
		switch (key){
			case "a": 
				setValid(true);
				break;
			case "b": 
				setValid(true);
				break;
			case "up":
				setValid(true);
				break;
			case "down": 
				setValid(true);
				break;
			case "left": 
				setValid(true);
				break;
			case "right": 
				setValid(true);
				break;
			case "start": 
				setValid(true);
				break;
			case "select":
				setValid(true);
				break;
			default:
				setValid(false);
				break;
		}
	}

}
