package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.restful.controller.ClienteController;
import br.com.restful.model.Cliente;

/** Classe responsável por conter os métodos de acesso ao webservice
 * 
 * @author Daniel
 * 
 * @since 20 de jan de 2016 - 19:58:17
 */
@Path("/cliente")
public class ClienteResource {

	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<Cliente> listarTodos(){
		return new ClienteController().listarTodos();
	}
}
