package unidade2.persistencia;

import unidade2.model.Cliente;

public interface CriaCliente {
	public default Cliente criacao(long cpf, String nome, String email)throws Exception{
		return new Cliente(cpf, nome, email);
	}
}
