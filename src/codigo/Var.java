package codigo;

public class Var {
	
	private String type;
	private int address;
	private int useless;
	
	public Var(String type, int address) {
		this.type = type;
		this.address = address;
	}
	
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
