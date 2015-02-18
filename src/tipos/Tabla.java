package tipos;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class Tabla {
	
	//tabla de pilas donde apilamos el bloque en el que aparece la variable
	
	private Hashtable<String,Stack<String>> tabla = new Hashtable<String,Stack<String>>();
	private int bloque = 0;
	private List<Ambito> ambito = new ArrayList<Ambito>();
	
	public Tabla() {
		this.inic();
	}
	
	public void inic() {
		tabla = new Hashtable<String,Stack<String>>();
		this.bloque = 0;
		ambito = new ArrayList<Ambito>();
		ambito.add(new Ambito());
		
	}
	
	public void abreBloque() {
		
		this.bloque++;
		this.ambito.add(new Ambito());
	}
	
	public void cierraBloque() {
		
		for (String s : ambito.get(bloque)) 
			tabla.get(s).pop();
		
		this.ambito.remove(this.bloque);
		this.bloque--;
	}
	
	public void insertaId(String id, String type) throws VariableRepetida {
		
		if (!ambito.get(bloque).add(id))
			throw new VariableRepetida(id);
		
		if (!this.tabla.containsKey(id))
			this.tabla.put(id, new Stack<String>());
		
		this.tabla.get(id).push(type);
	}
	
	public String buscaId(String id) throws VariableSinDeclarar {
		
		if (!this.tabla.containsKey(id))
			throw new VariableSinDeclarar(id);
		
		return this.tabla.get(id).peek();
	}
}
