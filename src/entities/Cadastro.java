package entities;

import java.util.Scanner;


public class Cadastro {
	 public String nome;
	 public String login;
	 public String senha;
	 public  int escolha = 1;
	
	Scanner sc = new Scanner (System.in);
	
		
public Cadastro (String nome, String login, String senha) {
	this.nome = nome;
	this.login = login;
	this.senha = senha;
}


public String getNome() {
	System.out.println("Digite seu nome: ");
	nome = sc.nextLine();
	return nome;
	
}


public void setNome(String nome) {
	this.nome = nome;
}


public String getLogin() {
	System.out.println("Digite seu e-mail: ");
	login = sc.nextLine();
	return login;
}


public void setLogin(String login) {
	this.login = login;
}


public String getSenha() {
	System.out.println("Digite sua senha: ");
	senha = sc.nextLine();
	return senha;
}


public void setSenha(String senha) {
	this.senha = senha;
}



}
