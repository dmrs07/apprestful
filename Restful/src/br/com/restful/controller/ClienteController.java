package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.ClienteDAO;
import br.com.restful.model.Cliente;

/** Classe responsável por ser controlador entre o resource e a camada DAO
 * 
 * @author Daniel
 * 
 * @since 20 de jan de 2016 - 19:56:13
 */
public class ClienteController {
	public ArrayList<Cliente> listarTodos(){
		return ClienteDAO.getInstance().listarTodos(); 
	}
}
