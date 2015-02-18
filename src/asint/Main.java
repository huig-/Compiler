package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import codigo.TablaDirecciones;
import tipos.Tabla;
import alex.AnalizadorLexicoTiny;
import ast.Node;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream("input.txt"));
		AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		AnalizadorSintactico asint = new AnalizadorSintactico();
		asint.setScanner(alex);
		Node root = (Node) asint.parse().value;
		Tabla tabla = new Tabla();
		root.analiza(tabla);
		root.compruebaTipos();
		
		TablaDirecciones tab_dir = new TablaDirecciones();
		root.asignaDirecciones(tab_dir);
		int tam_mem = tab_dir.getAddress() + 1;
		System.out.println(root.generaCodigo(tam_mem));
	}
}
