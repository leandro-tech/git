package leitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

public class Leitor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public void executa(String arquivoCsv, ProcessadorLinha processador) {
		String linha = "";		
		BufferedReader conteudoCsv = null;
						
		try {
			conteudoCsv = new BufferedReader(new FileReader(arquivoCsv));
			while ((linha = conteudoCsv.readLine()) != null){
				processador.processa(linha);
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
	}
	
}