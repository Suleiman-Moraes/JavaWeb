package unidade3;

public class Exercicio {
	public static void main(String[] args) {
		/*String nome = "O Curso de Java";
		String avaliacao = "é ótimo!";
		String tudo = nome +" "+ avaliacao;
		System.out.println(tudo);
		System.out.println(tudo.substring(11, 15));*/
		
		String data = "1 - D; 2 - E; 3 - D; 4 - C; 5 - B; 6 - B; 7 - D; 8 - D; 9 - A; 10 - E";
		System.out.println(data);
		String vet[] = data.split(";");
		for (String string : vet) {
			System.out.println(string);
		}
		/*char a = ' ';
		int x = (a + 1);
		System.out.println(x);*/
	}
}

