
package alex;

import asint.ClaseLexica;

public class ALexOperations {
	private AnalizadorLexicoTiny alex;

	public ALexOperations(AnalizadorLexicoTiny alex) {
		this.alex = alex;
	}

	public UnidadLexica unidadId() {
		return new UnidadLexica(alex.fila(), ClaseLexica.IDEN, alex.lexema());
	}

	public UnidadLexica unidadIf() {
		return new UnidadLexica(alex.fila(), ClaseLexica.IF,"if");
	}

	public UnidadLexica unidadThen() {
		return new UnidadLexica(alex.fila(), ClaseLexica.THEN,"then");
	}

	public UnidadLexica unidadElse() {
		return new UnidadLexica(alex.fila(), ClaseLexica.ELSE,"else");
	}

	public UnidadLexica unidadEnd() {
		return new UnidadLexica(alex.fila(), ClaseLexica.END,"end");
	}

	public UnidadLexica unidadRepeat() {
		return new UnidadLexica(alex.fila(), ClaseLexica.REPEAT,"repeat");
	}

	public UnidadLexica unidadUntil() {
		return new UnidadLexica(alex.fila(), ClaseLexica.UNTIL,"until");
	}

	public UnidadLexica unidadRead() {
		return new UnidadLexica(alex.fila(), ClaseLexica.READ,"read");
	}

	public UnidadLexica unidadWrite() {
		return new UnidadLexica(alex.fila(), ClaseLexica.WRITE,"write");
	}

	public UnidadLexica unidadNum() {
		return new UnidadLexica(alex.fila(), ClaseLexica.NUMBER, alex.lexema());
	}

	public UnidadLexica unidadSemi() {
		return new UnidadLexica(alex.fila(), ClaseLexica.SEMI,";");
	}

	public UnidadLexica unidadEQ() {
		return new UnidadLexica(alex.fila(), ClaseLexica.EQ,"=");
	}

	public UnidadLexica unidadSuma() {
		return new UnidadLexica(alex.fila(), ClaseLexica.MAS,"+");
	}

	public UnidadLexica unidadResta() {
		return new UnidadLexica(alex.fila(), ClaseLexica.MENOS,"-");
	}

	public UnidadLexica unidadMul() {
		return new UnidadLexica(alex.fila(), ClaseLexica.PROD,"*");
	}

	public UnidadLexica unidadDiv() {
		return new UnidadLexica(alex.fila(), ClaseLexica.DIV,"/");
	}

	public UnidadLexica unidadPAP() {
		return new UnidadLexica(alex.fila(), ClaseLexica.PAP,"(");
	}

	public UnidadLexica unidadPCierre() {
		return new UnidadLexica(alex.fila(), ClaseLexica.PCIERRE,")");
	}

	public UnidadLexica unidadIgual() {
		return new UnidadLexica(alex.fila(), ClaseLexica.IGUAL,":=");
	}

	public UnidadLexica unidadMenor() {
		return new UnidadLexica(alex.fila(), ClaseLexica.MENOR,"<");
	}

	public UnidadLexica unidadEof() {
		return new UnidadLexica(alex.fila(), ClaseLexica.EOF,"<EOF>");
	}

	public UnidadLexica unidadBloqueAP() {
		return new UnidadLexica(alex.fila(), ClaseLexica.NEW_BLOCK,"newblock");
	}

	public UnidadLexica unidadBloqueCierre() {
		return new UnidadLexica(alex.fila(), ClaseLexica.END_BLOCK,"endblock");
	}

	public UnidadLexica unidadInt() {
		return new UnidadLexica(alex.fila(), ClaseLexica.INT,"int");
	}

	public UnidadLexica unidadTrue() {
		return new UnidadLexica(alex.fila(), ClaseLexica.TRUE,"true");
	}

	public UnidadLexica unidadFalse() {
		return new UnidadLexica(alex.fila(), ClaseLexica.FALSE,"false");
	}

	public UnidadLexica unidadBool() {
		return new UnidadLexica(alex.fila(), ClaseLexica.BOOL,"bool");
	}

	public UnidadLexica unidadOr() {
		return new UnidadLexica(alex.fila(), ClaseLexica.OR,"or");
	}
	
	public UnidadLexica unidadAnd() {
		return new UnidadLexica(alex.fila(), ClaseLexica.AND, "and");
	}
}
