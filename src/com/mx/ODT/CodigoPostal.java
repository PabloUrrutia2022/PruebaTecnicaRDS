package com.mx.ODT;

public class CodigoPostal {
	String asentamiento;
	String estado;
	String municipio;
	String ciudad;
	String tipo_asentamiento;
	String pais;

	public CodigoPostal() {
	}

	public CodigoPostal(String asentamiento, String estado, String municipio, String ciudad, String tipo_asentamiento,
			String pais) {
		this.asentamiento = asentamiento;
		this.estado = estado;
		this.municipio = municipio;
		this.ciudad = ciudad;
		this.tipo_asentamiento = tipo_asentamiento;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "CodigoPostal [asentamiento=" + asentamiento + ", estado=" + estado + ", municipio=" + municipio
				+ ", ciudad=" + ciudad + ", tipo_asentamiento=" + tipo_asentamiento + ", pais=" + pais + "]";
	}

	public String getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTipo_asentamiento() {
		return tipo_asentamiento;
	}

	public void setTipo_asentamiento(String tipo_asentamiento) {
		this.tipo_asentamiento = tipo_asentamiento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
