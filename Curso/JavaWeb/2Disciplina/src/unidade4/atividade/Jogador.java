package unidade4.atividade;

public class Jogador implements Comparable<Jogador>{

	private String nome;
	private float pontuacao;
	private String clube;
	private String pais;
	
	
	public Jogador() {}
	public Jogador(String nome, float pontuacao, String clube, String pais) {
		this.nome = nome;
		this.pontuacao = pontuacao;
		this.clube = clube;
		this.pais = pais;
	}
	public Jogador(Jogador objeto) {
		this.nome = objeto.nome;
		this.pontuacao = objeto.pontuacao;
		this.clube = objeto.clube;
		this.pais = objeto.pais;
	}
	
	@Override
	public int compareTo(Jogador objeto) {
		if(this.pontuacao == objeto.pontuacao) return 0;
		else if(this.pontuacao < objeto.pontuacao) return -1;
		else return 1;
	}
	
	public String getNome() {
		return nome;
	}
	public float getPontuacao() {
		return pontuacao;
	}
	public String getClube() {
		return clube;
	}
	public String getPais() {
		return pais;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPontuacao(float pontuacao) {
		this.pontuacao = pontuacao;
	}
	public void setClube(String clube) {
		this.clube = clube;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Jogador " + nome + "\nPontuação = " + pontuacao + "\nClube = " + clube + "\nPaís = " + pais + "\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Jogador other = (Jogador) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
