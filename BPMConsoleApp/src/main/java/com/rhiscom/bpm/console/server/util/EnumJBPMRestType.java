package com.rhiscom.bpm.console.server.util;

public enum EnumJBPMRestType {

	POST ("POST"),
	GET	 ("GET"),
	MULTIPART ("MULTIPART"),
	GET_BYTE ("GET_BYTE")
	;
	public String codigo;

	private EnumJBPMRestType(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
