package main;

import leitor.Leitor;
import leitor.ProcessadorLinha;
import processador.ProcessaLinha;

public class Principal {

	private static String arquivoCsv = "C:\\Users\\zordon\\Documents\\Faculdade\\Java\\1200-Empresas.csv";
	 
	public static void main(String[] args) {
		ProcessadorLinha processador = new ProcessaLinha();
		Leitor empresaCsv = new Leitor();		
		empresaCsv.executa(arquivoCsv, processador);
	}

}
