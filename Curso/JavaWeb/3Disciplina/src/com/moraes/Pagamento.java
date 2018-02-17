package com.moraes;

import java.sql.Date;

public class Pagamento {
	private long cpf;
	private long cdCurso;
	private Date data;
	
	public Pagamento(long cpf, long cdCurso, Date data) throws Exception {
		this.cpf = cpf;
		this.cdCurso = cdCurso;
		this.data = data;
	}
	public Pagamento() {}
	public Pagamento(Pagamento objeto) throws Exception {
		this.cpf = objeto.cpf;
		this.cdCurso = objeto.cdCurso;
		this.data = objeto.data;
	}
	public long getCpf() {
		return cpf;
	}
	public long getCdCurso() {
		return cdCurso;
	}
	public Date getData() {
		return data;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public void setCdCurso(long cdCurso) {
		this.cdCurso = cdCurso;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdCurso ^ (cdCurso >>> 32));
		result = prime * result + (int) (cpf ^ (cpf >>> 32));
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (cdCurso != other.cdCurso)
			return false;
		if (cpf != other.cpf)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pagamento Data == " + data + ", CPF == " + cpf + ", C�digo do Curso == " + cdCurso;
	}
}
