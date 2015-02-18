package alex;

import errors.GestionErroresTiny;

%%
%line
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode
%public
%cup

%{
  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}


separador = [ \t\r\b\n]
comentario = #[^\n]* 
operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = /
PAP = \(
PCierre = \)
bloqueAP = newblock
semi = ;
bloqueCierre = endblock
if = if
then = then
else = else
end_if = end
repeat = repeat
until = until
igual = :=
read = read
write = write
int = int
bool = bool
menor = <
eq = =
true = true
false = false
digito = [0-9]
letra  = ([A-Z]|[a-z])
identificador = {letra}({letra}|{digito})*
number = [\-]?{digito}+


%%
{separador}               {}
{comentario}              {}
{number}		  {return ops.unidadNum();}			  
{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{PAP}		          {return ops.unidadPAP();}
{PCierre}	          {return ops.unidadPCierre();} 
{bloqueAP}	  	  {return ops.unidadBloqueAP();}	
{bloqueCierre}		  {return ops.unidadBloqueCierre();}
{semi}		  	  {return ops.unidadSemi();}
{if}			  {return ops.unidadIf();}
{then}			  {return ops.unidadThen();}
{else}			  {return ops.unidadElse();}
{end_if}		  {return ops.unidadEnd();}
{repeat}		  {return ops.unidadRepeat();}
{until}			  {return ops.unidadUntil();}
{igual}		  	  {return ops.unidadIgual();}
{read}			  {return ops.unidadRead();}
{write}			  {return ops.unidadWrite();}
{int}			  {return ops.unidadInt();}
{bool}			  {return ops.unidadBool();}
{menor}			  {return ops.unidadMenor();}
{eq}			  {return ops.unidadEQ();}
{true}			  {return ops.unidadTrue();}
{false}			  {return ops.unidadFalse();}
{identificador}           {return ops.unidadId();}
[^]                       {errores.errorLexico(fila(),lexema());}  
