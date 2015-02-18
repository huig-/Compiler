package ast;

public abstract class Exp extends Node {
	
	protected String type;
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public abstract String codeR();
}
