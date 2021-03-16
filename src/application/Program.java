package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import entities.Cadastro;

public class Program {
 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner (System.in);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
		Cadastro cadastro = new Cadastro(null,null,null);
		int escolha;
						
		try {Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro", "root", "2530paz@");
        System.out.println("Seja Bem Vindo Você está Conectado!");
        Statement statement =  conexao.createStatement();
        System.out.println("Dite a opção desejada: ");
        System.out.println("1 Cadastrar ");
		System.out.println("2 Atualizar ");
		System.out.println("3 Excluir ");
		System.out.println("4 Mostrar Cadastro");
        escolha = sc.nextInt();
        		
		
		if( escolha == 1) {
            System.out.println("Faça o seu Cadastro");
            cadastro.getNome();
    		cadastro.getLogin();
    		cadastro.getSenha();
            statement.executeUpdate("INSERT INTO dados (nome, login, senha)VALUES ('"+ cadastro.nome+"', '" + cadastro.login+"','" + cadastro.senha + "')");
            System.out.println("Dados Cadastrados com Sucesso!\n"+ dataFormat.format(c.getTime()));   
            
		}
		
		else if (escolha == 2) {
			System.out.println("Digite o ID que deseja atualizar os dados");
			int id = sc.nextInt();
			System.out.println("Digite o nome deseja atualizar os dados");
			String nome = sc.next();  
			System.out.println("Digite o email que deseja atualizar os dados");
			String login = sc.next();
			statement.execute("UPDATE dados SET nome= '" +nome+"', login= '"+login+"' WHERE id=" +id );
		    System.out.println("Cadastro Atulizado!\n " + dataFormat.format(c.getTime()));
            
    					
		}
		
		else if (escolha == 3 ) {
			System.out.print("Excluir Cadastro \nEscolha o ID \n");
			int id = sc.nextInt();
			statement.execute("DELETE FROM dados WHERE id = " +id);
         	System.out.println("Cadastro Excluido com Sucesso! \n"+ dataFormat.format(c.getTime()));
         	
		}
		
	
		else if (escolha == 4) {
			statement.executeQuery("SELECT*FROM dados");
			 ResultSet set = statement.getResultSet();
	        while (set.next()) {
	      	  System.out.printf("%d:%15s-%10s\n",
	      	  set.getInt("id"),
	      	  set.getString( "nome"),
	      	  set.getString("login"),
	      	  set.getString("senha"));  	  
	      	   }
	        
	       System.out.println(dataFormat.format(c.getTime()));
		}
				    	  
		else {
			System.out.println("Opção Invalida");
		}
		 
		}
		catch (SQLException s) {
            System.out.println("Não foi possível conectar ao banco de dados");
            System.out.println(s);
          }  
		
		sc.close();
	}
	}

