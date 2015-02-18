package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class IfThen extends SIf{
	
	private Exp exp;
	private SecuenciaS sec;
	
	public IfThen(Exp e, SecuenciaS s) {
		this.exp = e;
		this.sec = s;
	}

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		this.exp.analiza(tabla);
		this.sec.analiza(tabla);
	}

	@Override
	public void compruebaTipos() throws ErrorTipos {
		this.exp.compruebaTipos();
		
		if (!this.exp.getType().equalsIgnoreCase("bool"))
			throw new ErrorTipos(this.exp.getType(),"bool");
		
		this.sec.compruebaTipos();
	}

	@Override
	public String code() {
		this.sec.setInicio(this.getInicio() + this.exp.num_instr() + 1);
		int l = this.sec.getInicio() + this.sec.num_instr();
		return this.exp.codeR() + "fjp " + l + ";" + this.sec.code();
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.exp.asignaDirecciones(tabla);
		this.sec.asignaDirecciones(tabla);
	}

	@Override
	public int num_instr() {
		return this.exp.num_instr() + this.sec.num_instr() + 1;
	}
}
