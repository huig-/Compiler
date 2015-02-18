package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class SBloque extends Sentencia {
	
	private SecuenciaS sec;
	
	public SBloque(SecuenciaS sec) {
		this.sec = sec;
	}

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		tabla.abreBloque();
		this.sec.analiza(tabla);
		tabla.cierraBloque();
	}

	@Override
	public void compruebaTipos() throws ErrorTipos {
		this.sec.compruebaTipos();
	}

	@Override
	public String code() {
		this.sec.setInicio(this.getInicio());
		return this.sec.code();
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.sec.asignaDirecciones(tabla);
	}

	@Override
	public int num_instr() {
		return this.sec.num_instr();
	}
}
