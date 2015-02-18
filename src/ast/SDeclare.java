package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;

public class SDeclare extends Sentencia {
	
	private FactorId iden = null;
    
    public SDeclare(FactorId iden, String type) {
		this.iden = iden;
		this.iden.setType(type);
    }

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida {
		tabla.insertaId(iden.getIden(),iden.getType());
	}

	@Override
	public void compruebaTipos() throws ErrorTipos {}

	@Override
	public String code() {
		return "";
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.iden.setAddress(tabla.putIden(this.iden));
	}

	@Override
	public int num_instr() {
		return 0;
	}
}
