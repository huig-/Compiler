package tipos;

public class VariableSinDeclarar extends Exception {

	private static final long serialVersionUID = 1L;

	public VariableSinDeclarar(String iden) {
		super("La variable " + iden + " no ha sido declarada");
	}
}
