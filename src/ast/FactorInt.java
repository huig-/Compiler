package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class FactorInt extends Factor {
	
	private int num;
	
	public FactorInt(Integer number) {
		this.num = number;
		setType("int");
	}

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {}

	@Override
	public void compruebaTipos() throws ErrorTipos {}

	@Override
	public String codeR() {
		return "ldc " + this.num + ";";
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {}

	@Override
	public int num_instr() {
		return 1;
	}
}
