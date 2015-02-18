package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class SecuenciaSSec extends SecuenciaS {
	
	private Sentencia s1;
	private SecuenciaS s2;
	
	public SecuenciaSSec(Sentencia s1, SecuenciaS s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		this.s1.analiza(tabla);
		if (this.s2 != null)
			this.s2.analiza(tabla);
	}

	@Override
	public void compruebaTipos() throws ErrorTipos {
		this.s1.compruebaTipos();
		if (this.s2 != null)
			this.s2.compruebaTipos();
	}

	@Override
	public String code() {
		if (this.s2 != null) {
			this.s1.setInicio(this.getInicio());
			this.s2.setInicio(this.getInicio() + this.s1.num_instr());
			return this.s1.code() + this.s2.code();
		}
		else {
			this.s1.setInicio(this.getInicio());
			return this.s1.code();
		}
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.s1.asignaDirecciones(tabla);
		if (this.s2 != null)
			this.s2.asignaDirecciones(tabla);
	}

	@Override
	public int num_instr() {
		if (this.s2 != null)
			return this.s1.num_instr() + this.s2.num_instr();
		else 
			return this.s1.num_instr();
	}
}
