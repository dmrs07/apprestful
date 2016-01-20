package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Cliente;

/** Classe responsável por conter os métodos do CRUD
 * 
 * @author Daniel
 * 
 * @since 20 de jan de 2016 - 19:08:04
 */
public class ClienteDAO extends ConnectionFactory{
	
	private static ClienteDAO instance;
	
	/** Método responsável por criar instancia do ClienteDAO (Singleton)
	 * 
	 * @return
	 */
	
	public static ClienteDAO getInstance(){
		if (instance == null){
			instance = new ClienteDAO();
		}
		return instance;
	}
	
	public ArrayList<Cliente> listarTodos(){
		Connection conexao = null;
		conexao = criarConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> listaCliente = new ArrayList<>();
		try {
			pstmt = conexao.prepareStatement("select * from cliente order by nome");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("idcliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setCpf(rs.getString("cpf"));
				listaCliente.add(cliente);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return listaCliente;
	}
}
