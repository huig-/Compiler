package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class SRepeat extends Sentencia {
	
	private SecuenciaS sec = null;
    private Exp exp = null;
    
    public SRepeat(Exp exp, SecuenciaS s) {
		this.sec = s;
		this.exp = exp;
    }
	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		this.exp.analiza(tabla);
		this.sec.analiza(tabla);
	}
	@Override
	public void compruebaTipos() throws ErrorTipos {
		this.exp.compruebaTipos();
		this.sec.compruebaTipos();
	}
	@Override
	public String code() {
		int l = this.getInicio();
		this.sec.setInicio(this.getInicio());
		return this.sec.code() + this.exp.codeR() + "fjp " + l + ";";
	}
	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.sec.asignaDirecciones(tabla);
		this.exp.asignaDirecciones(tabla);
	}
	@Override
	public int num_instr() {
		return this.sec.num_instr() + this.exp.num_instr() + 1;
	}
}
