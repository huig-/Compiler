package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class FactorBool extends Factor {

	private boolean bool;
	
	public FactorBool(boolean bool) {
		this.bool = bool;
		setType("bool");
	}

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {}

	@Override
	public void compruebaTipos() throws ErrorTipos {}

	@Override
	public String codeR() {
		return "ldc " + this.bool + ";";
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {}

	@Override
	public int num_instr() {
		return 1;
	}
}
