package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class SRead extends Sentencia {
	
	private FactorId iden = null;
	
    public SRead(FactorId iden) {
    	this.iden = iden;
    }
	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		String type = tabla.buscaId(this.iden.getIden());
		this.iden.setType(type);
	}
	@Override
	public void compruebaTipos() throws ErrorTipos {}
	
	@Override
	public String code() {
		return "";
	}
	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.iden.setAddress(tabla.getAddress(this.iden));
	}
	@Override
	public int num_instr() {
		return 1;
	}
}
