package br.com.augusto.models;

public class Token {
	private String chave;
	private String valor;
	public Token(String chave, String valor) {
		super();
		this.chave = chave;
		this.valor = valor;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Token [chave=" + chave + ", valor=" + valor + "]";
	}
	

}
