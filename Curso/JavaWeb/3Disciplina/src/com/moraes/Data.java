package com.moraes;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import oracle.jdbc.proxy.annotation.Post;

public class Data {
	private String data = "";
	private int dia = 0;
	private int mes = 0;
	private int ano = 0;
	
	
	public Data() {}
	public Data(String data) throws Exception {
		this.data = data;
		testes();
	}
	public Data(int dia, int mes, int ano) throws Exception {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		montaData();
		testes();
	}
	public Data(Data objeto) throws Exception {
		if(objeto.data == null) throw new Exception("Data Vazia!");
		this.data = objeto.data;
		testes();
	}
	
	
	private void testes() throws Exception {
		validaData(data);
		quebraData();
		segundaValidacao();
	}
	
	private void montaData() {
		String dd = dia + "";
		String mm = mes + "";
		if(dia < 10) dd = "0"+dd;
		if(mes < 10) mm = "0"+mm;
		this.data = dd+"//"+mm+"//"+ano;
	}
	
	private void quebraData() {
		String[] vet = data.split("/");
		
		this.dia = Integer.parseInt(vet[0]); 
		this.mes = Integer.parseInt(vet[1]);
		this.ano = Integer.parseInt(vet[2]);
	}

	public void validaData(String texto) throws Exception {
		if(!texto.matches("\\d{2}/\\d{2}/\\d{4}")) throw new Exception("Formato Inv�lido de \"Data\"!");
		String[] vet = texto.split("/");
		int[] veto = new int[3];
		
		for (int i = 0; i < veto.length; i++) 
			veto[i] = Integer.parseInt(vet[i]);
		
		if (veto[0] > 31 || veto[0] <=0) throw new Exception("\"Dia\" inexistente!"); 
		
		if (veto[1] > 12 || veto[1] <=0) throw new Exception("\"M�s\" inexistente!");
		
		if (veto[2] < 1000) throw new Exception("\"Ano\" inexistente!");
	}
	
	private void segundaValidacao() throws Exception {
		if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) throw new Exception("Dia Inexixtente de acordo com M�s \""+mes+"\"");
		else if(mes == 2 && dia > 29) throw new Exception("Dia Inexixtente de acordo com M�s \""+mes+"\"");
	}
	
	
	
	public String getData() {
		return data;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public void setData(String data) throws Exception {
		this.data = data;
		testes();
	}

	/*
	public void setDia(int dia) throws Exception {
		this.dia = dia;
		montaData();
		testes();
	}

	public void setMes(int mes) throws Exception {
		this.mes = mes;
		montaData();
		testes();
	}

	public void setAno(int ano) throws Exception {
		this.ano = ano;
		montaData();
		testes();
	}
	
	public void setDia(String dia) throws Exception {
		this.dia = Integer.parseInt(dia);
		montaData();
		testes();
	}

	public void setMes(String mes) throws Exception {
		this.mes = Integer.parseInt(mes);
		montaData();
		testes();
	}

	public void setAno(String ano) throws Exception {
		this.ano = Integer.parseInt(ano);
		montaData();
		testes();
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Data other = (Data) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Data == " + data;
	}
	public static void main(String[] args) {
		try {
			Scanner leia = new Scanner(System.in);
			String texto = "";
			System.out.println("Digite");
			texto = leia.next();
			Data data = new Data(texto);
			System.out.println("Digite");
			texto = leia.next();
			data.setData(texto);
			main(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			main(null);
		}
	}
}