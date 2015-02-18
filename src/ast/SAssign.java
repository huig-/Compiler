package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class SAssign extends Sentencia {
	
	private FactorId iden = null;
    private Exp exp = null;
    
    public SAssign(FactorId iden, Exp exp) {
		this.iden = iden;
		this.exp = exp;
    }

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		String type = tabla.buscaId(this.iden.getIden());
		this.iden.setType(type);
		this.exp.analiza(tabla);
	}

	@Override
	public void compruebaTipos() throws ErrorTipos {
		this.exp.compruebaTipos();
		if (!this.iden.getType().equalsIgnoreCase(this.exp.getType()))
			throw new ErrorTipos(this.iden.getType(), this.exp.getType());
	}

	@Override
	public String code() {
		return this.iden.codeL() + this.exp.codeR() + "sto;";	
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.iden.setAddress(tabla.getAddress(this.iden));
		this.exp.asignaDirecciones(tabla);
	}

	@Override
	public int num_instr() {
		return this.iden.num_instr() - 1 + this.exp.num_instr() + 1;
	}
}
