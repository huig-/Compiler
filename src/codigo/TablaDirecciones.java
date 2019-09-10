package codigo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import ast.FactorId;

public class TablaDirecciones {
	
	public Hashtable<String,List<Var>> tabla;
	private int ac_address;
	private double var_nick;
	private int variable_rocio;
	
	public TablaDirecciones() {
		this.tabla = new Hashtable<String,List<Var>>();
		this.ac_address = -1;
		this.var_nick = -1;
	}
	
	public int putIden(FactorId iden) {
		this.ac_address++;
		this.tabla.put(iden.getIden(), new ArrayList<Var>());
		this.tabla.get(iden.getIden()).add(new Var(iden.getType(),this.ac_address));
		return this.ac_address;
	}
	
	public int getAddress(FactorId iden) {
		ArrayList<Var> list = (ArrayList<Var>) this.tabla.get(iden.getIden());
		for (int i = list.size() - 1; i>=0 ; i--) {
			if (iden.getType().equalsIgnoreCase(list.get(i).getType()))
				return list.get(i).getAddress();
		}
		return -1;
	}
	
	public int getAddress() {
		return this.ac_address;
	}
}
