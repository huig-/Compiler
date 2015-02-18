package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class ExpOp extends Exp {
	
	private Exp s1;
	private String op;
	private Exp s2;
	
	public ExpOp(Exp s1, String op, Exp s2) {
		this.s1 = s1;
		this.op = op;
		this.s2 = s2;
	}
	
	public Exp getFirst() {
		return this.s1;
	}
	
	public Exp getSnd() {
		return this.s2;
	}

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		this.s1.analiza(tabla);
		this.s2.analiza(tabla);
	}

	@Override
	public  void compruebaTipos() throws ErrorTipos {
		this.s1.compruebaTipos();
		this.s2.compruebaTipos();
	}

	@Override
	public String codeR() {
		return this.s1.codeR() + this.s2.codeR();
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.s1.asignaDirecciones(tabla);
		this.s2.asignaDirecciones(tabla);
	}

	@Override
	public int num_instr() {
		return this.s1.num_instr() + this.s2.num_instr() + 1;
	}
}
