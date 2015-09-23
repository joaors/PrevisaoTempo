package com.previsao.dto;

public class Erro {
	
	private String mensagem;
	private String erro;
	
	Erro(){}
	
	public static Erro create(String mensagem, String erro) {
		Erro e = new Erro();
		e.mensagem = mensagem;
		e.erro = erro;
		return e;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
