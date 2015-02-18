package ast;

import tipos.ErrorTipos;

public class EQ extends ExpOp {
	
	public EQ(Exp e1, Exp e2) {
		super(e1,"=",e2);
	}
	
	@Override
	public void compruebaTipos() throws ErrorTipos {
		super.compruebaTipos();
		String t_s1 = getFirst().getType();
		String t_s2 = getSnd().getType();
		
		if (!t_s1.equalsIgnoreCase(t_s2))
			throw new ErrorTipos(t_s1,t_s2);
		
		setType("bool");
	}
	
	@Override
	public String codeR() {
		return  super.codeR() + "equ;";
	}
}
