package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class Programa extends Node {
	
	private SecuenciaS secuenciaS = null;
    public Programa(SecuenciaS secuenciaS) {
    	this.secuenciaS = secuenciaS;
    	this.secuenciaS.setInicio(1);
    }
    
	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		secuenciaS.analiza(tabla);
	}

	@Override
	public void compruebaTipos() throws ErrorTipos {
		this.secuenciaS.compruebaTipos();
	}
	
	@Override
	public String generaCodigo(int tam) {
		return "ssp " + tam + ";" + this.secuenciaS.code() + "stp;";
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.secuenciaS.asignaDirecciones(tabla);
	}

	@Override
	public int num_instr() {
		return this.secuenciaS.num_instr() + 1;
	}
}
