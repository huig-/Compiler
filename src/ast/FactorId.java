package ast;

import codigo.TablaDirecciones;
import tipos.ErrorTipos;
import tipos.Tabla;
import tipos.VariableRepetida;
import tipos.VariableSinDeclarar;

public class FactorId extends Factor {

	private String name;
	private int address;
	
	public FactorId(String iden) {
		this.name = iden;
	}

	public String getIden() {
		return name;
	}
	
	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	@Override
	public void analiza(Tabla tabla) throws VariableRepetida, VariableSinDeclarar {
		String type = tabla.buscaId(this.name);
		setType(type);
	}

	@Override
	public void compruebaTipos() throws ErrorTipos {}
	
	public String codeL() {
		return "ldc "+ this.getAddress() + ";";
	}
	
	@Override
	public String codeR() {
		return this.codeL() + "ind;";
	}

	@Override
	public void asignaDirecciones(TablaDirecciones tabla) {
		this.setAddress(tabla.getAddress(this));
	}

	//Se utiliza para el caso de una exp en la parte derecha
	@Override
	public int num_instr() {
		return 2;
	}
}
