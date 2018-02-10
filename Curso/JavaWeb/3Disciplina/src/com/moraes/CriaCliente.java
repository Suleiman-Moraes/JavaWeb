package com.moraes;

public interface CriaCliente {
	public default Cliente criacao(long cpf, String nome, String email)throws Exception{
		return new Cliente(cpf, nome, email);
	}
}
