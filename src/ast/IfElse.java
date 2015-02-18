package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class IfElse extends SIf{

	private Exp exp;
	private SecuenciaS sec_if;
	private SecuenciaS sec_else;
	
	public IfElse(Exp exp, SecuenciaS sif, SecuenciaS selse) {
		this.exp = exp;
		this.sec_if = sif;
		this.sec_else = selse;
	}

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		this.exp.analiza(tabla);
		this.sec_if.analiza(tabla);
		this.sec_else.analiza(tabla);
	}

	@Override
	public void compruebaTipos() throws ErrorTipos {
		this.exp.compruebaTipos();
		
		if (!this.exp.getType().equalsIgnoreCase("bool"))
			throw new ErrorTipos(this.exp.getType(),"bool");
		
		this.sec_if.compruebaTipos();
		this.sec_else.compruebaTipos();
	}

	@Override
	public String code() {
		this.sec_if.setInicio(this.getInicio() + this.exp.num_instr() + 1);
		this.sec_else.setInicio(this.sec_if.getInicio() + this.sec_if.num_instr() + 1);
		int l1 = this.sec_else.getInicio();
		int l2 = l1 + this.sec_else.num_instr();
		return this.exp.codeR() + "fjp " + l1 + ";" + this.sec_if.code() 
				+ "ujp " + l2 + ";" + this.sec_else.code();
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.exp.asignaDirecciones(tabla);
		this.sec_if.asignaDirecciones(tabla);
		this.sec_else.asignaDirecciones(tabla);
	}

	@Override
	public int num_instr() {
		return this.exp.num_instr() + this.sec_if.num_instr() + this.sec_else.num_instr() + 2;
	}
}
