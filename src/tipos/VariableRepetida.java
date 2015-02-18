package tipos;

public class VariableRepetida extends Exception {
	
	private static final long serialVersionUID = 1L;

	public VariableRepetida(String iden) {
		super("La variable " + iden + " ya ha sido definida");
	}
}
