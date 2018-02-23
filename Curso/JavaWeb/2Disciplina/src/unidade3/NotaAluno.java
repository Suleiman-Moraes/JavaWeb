package unidade3;

public class NotaAluno {
	double valor;

	<T extends Number>NotaAluno(T valor) {
		super();
		this.valor = valor.doubleValue();
	}
}
