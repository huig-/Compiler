package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class SWrite extends Sentencia {
	
	private Exp exp = null;
	
    public SWrite(Exp exp) {
    	this.exp = exp;
    }
	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		this.exp.analiza(tabla);
	}
	@Override
	public void compruebaTipos() throws ErrorTipos {
		this.exp.compruebaTipos();
	}
	
	@Override
	public String code() {
		return "";
	}
	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.exp.asignaDirecciones(tabla);
	}
	@Override
	public int num_instr() {
		return this.exp.num_instr();
	}
}
