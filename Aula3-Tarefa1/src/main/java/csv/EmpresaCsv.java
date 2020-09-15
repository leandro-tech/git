package csv;

import java.util.ArrayList;
import java.util.List;

public class EmpresaCsv {

	private String [] coluna;
	
	private String retiraAspasDuplas(String str) { 
		
		return str.replaceAll("\"", "").trim();
	}
	
	public EmpresaCsv(String linha) {
		coluna = linha.split(";");
	}

	public String getRamo() {
		return retiraAspasDuplas(coluna[0]);
	}
	
	public String getRazao() {
		return retiraAspasDuplas(coluna[1]);
	}
	
	public String getLogradouro() {
		return retiraAspasDuplas(coluna[2]);
	}
	
	public String getBairro() {
		return retiraAspasDuplas(coluna[3]);
	}
	
	public String getCep() {
		return retiraAspasDuplas(coluna[4]);
	}
	
	public String getCidade() {
		return retiraAspasDuplas(coluna[5]);
	}
	
	public String getSiglaUf() {
		return retiraAspasDuplas(coluna[6]);
	}
	
	public String getContato() {
		return retiraAspasDuplas(coluna[7]);
	}
	
	public Integer getNumFuncionarios() {
		try {
			return Integer.parseInt(retiraAspasDuplas(coluna[8]));			
		} catch (Exception e) {
			return null;
		}
	}
	
	public String getTelefone() {
		return retiraAspasDuplas(coluna[9]);
	}
	
	public String getFax() {
		return retiraAspasDuplas(coluna[10]);
	}
	
	public String getSite() {
		return retiraAspasDuplas(coluna[11]);
	}
	
	public String getEmail() {
		return retiraAspasDuplas(coluna[12]);
	}
	
	public List<String> getNomeProdutos() {
		List<String> result = new ArrayList<>();
		for(int posicao = 13; posicao < coluna.length; posicao++) {  
			result.add(retiraAspasDuplas(coluna[posicao]));
		}
		return result;
	}
	
		
}

