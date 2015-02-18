package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public abstract class Node {
	
	private int inicio;
	private int fin;

	public abstract int num_instr();
	
	public abstract void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar;
	
	public abstract void compruebaTipos() throws ErrorTipos;
	
	public abstract void asignaDirecciones(TablaDirecciones tabla);
	
	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}
	
	public String generaCodigo(int tam) {
		return "";
	}
}
