package alex;
import errors.GestionErroresTiny;


public class AnalizadorLexicoTiny implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public AnalizadorLexicoTiny (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public AnalizadorLexicoTiny (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private AnalizadorLexicoTiny () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;

  ops = new ALexOperations(this);
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"3:8,4:2,1,3:2,4,3:18,4,3:2,2,3:4,15,16,8,7,3,5,3,9,6:10,31,23,33,32,3:3,34:" +
"26,3:6,12,19,21,14,17,25,34,27,24,34,22,20,34,13,10,29,34,11,28,26,30,34,18" +
",34:3,3:65413,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,80,
"0,1:2,2,1,3:2,1:3,4,1:5,5:2,1,5,6,5:12,7,8,9,10,11,12,13,14,15,16,17,18,19," +
"20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44," +
"45,46,5,47,48,49,50,51,52")[0];

	private int yy_nxt[][] = unpackFromString(53,35,
"1,2,3,4,2,5,6,7,8,9,10,34,50,71,73,11,12,51,74,75,73:3,13,35,76,77,73:3,78," +
"33,14,15,73,-1:37,3:33,-1:6,6,-1:34,73,-1:3,73,16,73:3,-1:2,73:6,-1,73:7,-1" +
":3,73,-1:6,73,-1:3,73:5,-1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:2,73" +
":2,79,73:3,-1,73:7,-1:3,73,-1:32,18,-1:8,73,-1:3,73:5,-1:2,52,73:5,-1,73:7," +
"-1:3,73,-1:6,73,-1:3,73:3,38,73,-1:2,73:6,-1,73,17,73:5,-1:3,73,-1:6,73,-1:" +
"3,73:4,19,-1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73:4,20,-1:2,73:6,-1,73:7," +
"-1:3,73,-1:6,73,-1:3,73:5,-1:2,73:6,-1,73:2,21,73:4,-1:3,73,-1:6,73,-1:3,73" +
":4,22,-1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:2,23,73:5,-1,73:7,-1:3" +
",73,-1:6,73,-1:3,73:5,-1:2,73:3,24,73:2,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-" +
"1:2,25,73:5,-1,73:7,-1:3,73,-1:6,73,-1:3,73:3,26,73,-1:2,73:6,-1,73:7,-1:3," +
"73,-1:6,73,-1:3,73:5,-1:2,27,73:5,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:2,28" +
",73:5,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:2,73:3,29,73:2,-1,73:7,-1:3,73,-" +
"1:6,73,-1:3,73:5,-1:2,73:6,-1,73:2,30,73:4,-1:3,73,-1:6,73,-1:3,73:5,-1:2,7" +
"3:5,31,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:2,73:5,32,-1,73:7,-1:3,73,-1:6," +
"73,-1:3,73:3,36,73,-1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73:3,37,73,-1:2,7" +
"3:3,54,73:2,-1,73:7,-1:3,73,-1:6,73,-1:3,73:2,39,73:2,-1:2,73:6,-1,73:5,61," +
"73,-1:3,73,-1:6,73,-1:3,73:5,-1:2,73,62,73:4,-1,73:7,-1:3,73,-1:6,73,-1:3,7" +
"3:5,-1:2,73:6,-1,73:4,40,73:2,-1:3,73,-1:6,73,-1:3,73:5,-1:2,73:6,-1,63,73:" +
"6,-1:3,73,-1:6,73,-1:3,41,73:4,-1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5," +
"-1:2,73:3,64,73:2,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:2,73:6,-1,73:6,42,-1" +
":3,73,-1:6,73,-1:3,73:5,-1:2,43,73:5,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:2" +
",73:6,-1,73:2,65,73:4,-1:3,73,-1:6,73,-1:3,73:5,-1:2,66,73:5,-1,73:7,-1:3,7" +
"3,-1:6,73,-1:3,73:5,-1:2,73:2,67,73:3,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:" +
"2,73:6,-1,73:2,44,73:4,-1:3,73,-1:6,73,-1:3,73:5,-1:2,73:6,-1,73:4,45,73:2," +
"-1:3,73,-1:6,73,-1:3,73:5,-1:2,73:6,-1,46,73:6,-1:3,73,-1:6,73,-1:3,73:2,47" +
",73:2,-1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:2,73:3,68,73:2,-1,73:7" +
",-1:3,73,-1:6,73,-1:3,69,73:4,-1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-" +
"1:2,73:4,48,73,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5,-1:2,73:4,49,73,-1,73:7,-1" +
":3,73,-1:6,73,-1:3,73:5,-1:2,53,73:5,-1,73:7,-1:3,73,-1:6,73,-1:3,70,73:4,-" +
"1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73,55,73:3,-1:2,73:6,-1,73:7,-1:3,73," +
"-1:6,73,-1:3,56,73:4,-1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73:2,57,73:2,-1" +
":2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73,58,73:3,-1:2,73:6,-1,73:3,59,73:3,-" +
"1:3,73,-1:6,73,-1:3,73:3,60,73,-1:2,73:6,-1,73:7,-1:3,73,-1:6,73,-1:3,73:5," +
"-1:2,73:3,72,73:2,-1,73:7,-1:3,73");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return ops.unidadEof();
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{}
					case -3:
						break;
					case 3:
						{}
					case -4:
						break;
					case 4:
						{errores.errorLexico(fila(),lexema());}
					case -5:
						break;
					case 5:
						{return ops.unidadResta();}
					case -6:
						break;
					case 6:
						{return ops.unidadNum();}
					case -7:
						break;
					case 7:
						{return ops.unidadSuma();}
					case -8:
						break;
					case 8:
						{return ops.unidadMul();}
					case -9:
						break;
					case 9:
						{return ops.unidadDiv();}
					case -10:
						break;
					case 10:
						{return ops.unidadId();}
					case -11:
						break;
					case 11:
						{return ops.unidadPAP();}
					case -12:
						break;
					case 12:
						{return ops.unidadPCierre();}
					case -13:
						break;
					case 13:
						{return ops.unidadSemi();}
					case -14:
						break;
					case 14:
						{return ops.unidadEQ();}
					case -15:
						break;
					case 15:
						{return ops.unidadMenor();}
					case -16:
						break;
					case 16:
						{return ops.unidadOr();}
					case -17:
						break;
					case 17:
						{return ops.unidadIf();}
					case -18:
						break;
					case 18:
						{return ops.unidadIgual();}
					case -19:
						break;
					case 19:
						{return ops.unidadAnd();}
					case -20:
						break;
					case 20:
						{return ops.unidadEnd();}
					case -21:
						break;
					case 21:
						{return ops.unidadInt();}
					case -22:
						break;
					case 22:
						{return ops.unidadRead();}
					case -23:
						break;
					case 23:
						{return ops.unidadElse();}
					case -24:
						break;
					case 24:
						{return ops.unidadBool();}
					case -25:
						break;
					case 25:
						{return ops.unidadTrue();}
					case -26:
						break;
					case 26:
						{return ops.unidadThen();}
					case -27:
						break;
					case 27:
						{return ops.unidadWrite();}
					case -28:
						break;
					case 28:
						{return ops.unidadFalse();}
					case -29:
						break;
					case 29:
						{return ops.unidadUntil();}
					case -30:
						break;
					case 30:
						{return ops.unidadRepeat();}
					case -31:
						break;
					case 31:
						{return ops.unidadBloqueAP();}
					case -32:
						break;
					case 32:
						{return ops.unidadBloqueCierre();}
					case -33:
						break;
					case 33:
						{errores.errorLexico(fila(),lexema());}
					case -34:
						break;
					case 34:
						{return ops.unidadId();}
					case -35:
						break;
					case 35:
						{return ops.unidadId();}
					case -36:
						break;
					case 36:
						{return ops.unidadId();}
					case -37:
						break;
					case 37:
						{return ops.unidadId();}
					case -38:
						break;
					case 38:
						{return ops.unidadId();}
					case -39:
						break;
					case 39:
						{return ops.unidadId();}
					case -40:
						break;
					case 40:
						{return ops.unidadId();}
					case -41:
						break;
					case 41:
						{return ops.unidadId();}
					case -42:
						break;
					case 42:
						{return ops.unidadId();}
					case -43:
						break;
					case 43:
						{return ops.unidadId();}
					case -44:
						break;
					case 44:
						{return ops.unidadId();}
					case -45:
						break;
					case 45:
						{return ops.unidadId();}
					case -46:
						break;
					case 46:
						{return ops.unidadId();}
					case -47:
						break;
					case 47:
						{return ops.unidadId();}
					case -48:
						break;
					case 48:
						{return ops.unidadId();}
					case -49:
						break;
					case 49:
						{return ops.unidadId();}
					case -50:
						break;
					case 50:
						{return ops.unidadId();}
					case -51:
						break;
					case 51:
						{return ops.unidadId();}
					case -52:
						break;
					case 52:
						{return ops.unidadId();}
					case -53:
						break;
					case 53:
						{return ops.unidadId();}
					case -54:
						break;
					case 54:
						{return ops.unidadId();}
					case -55:
						break;
					case 55:
						{return ops.unidadId();}
					case -56:
						break;
					case 56:
						{return ops.unidadId();}
					case -57:
						break;
					case 57:
						{return ops.unidadId();}
					case -58:
						break;
					case 58:
						{return ops.unidadId();}
					case -59:
						break;
					case 59:
						{return ops.unidadId();}
					case -60:
						break;
					case 60:
						{return ops.unidadId();}
					case -61:
						break;
					case 61:
						{return ops.unidadId();}
					case -62:
						break;
					case 62:
						{return ops.unidadId();}
					case -63:
						break;
					case 63:
						{return ops.unidadId();}
					case -64:
						break;
					case 64:
						{return ops.unidadId();}
					case -65:
						break;
					case 65:
						{return ops.unidadId();}
					case -66:
						break;
					case 66:
						{return ops.unidadId();}
					case -67:
						break;
					case 67:
						{return ops.unidadId();}
					case -68:
						break;
					case 68:
						{return ops.unidadId();}
					case -69:
						break;
					case 69:
						{return ops.unidadId();}
					case -70:
						break;
					case 70:
						{return ops.unidadId();}
					case -71:
						break;
					case 71:
						{return ops.unidadId();}
					case -72:
						break;
					case 72:
						{return ops.unidadId();}
					case -73:
						break;
					case 73:
						{return ops.unidadId();}
					case -74:
						break;
					case 74:
						{return ops.unidadId();}
					case -75:
						break;
					case 75:
						{return ops.unidadId();}
					case -76:
						break;
					case 76:
						{return ops.unidadId();}
					case -77:
						break;
					case 77:
						{return ops.unidadId();}
					case -78:
						break;
					case 78:
						{return ops.unidadId();}
					case -79:
						break;
					case 79:
						{return ops.unidadId();}
					case -80:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
