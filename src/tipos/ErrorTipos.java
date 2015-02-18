package tipos;

public class ErrorTipos extends Exception {

	private static final long serialVersionUID = 1L;

	public ErrorTipos(String type1, String type2) {
		super(type1 + " no coincide con " + type2);
	}
	
	public ErrorTipos(String msg) {
		super(msg);
	}
}
