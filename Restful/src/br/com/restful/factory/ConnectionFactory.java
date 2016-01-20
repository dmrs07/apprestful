package br.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


/** Classe que contém os métodos de abrir e fechar conexão com o banco de dados.
 * 
 * @author Daniel
 * 
 * @since 20 de jan de 2016 - 18:59:16
 */

public class ConnectionFactory {
 //Definir caminho do db
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/testejdbc";
	private static final String USUARIO = "dmrs";
	private static final String SENHA = "";
	
	/**
	 * Método responsável por criar conexão com o MySql
	 *
	 * @return conexao
	 * @author Daniel Moraes
	 * @since 20/01/2016
	 * @version 1.0
	 * 
	 */
	public Connection criarConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (Exception e) {
			System.out.println("Erro ao tentar criar conexão com o banco: "+URL);
			e.printStackTrace();
		}
		return conexao;
	}
	
	public void fecharConexao(Connection conexao,  PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(conexao != null){
				conexao.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			
		} catch (Exception e) { 
			System.out.println("Erro ao fechar a conexão com o banco "+URL);
		}
	}
}
