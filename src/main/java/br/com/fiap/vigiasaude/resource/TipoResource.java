package br.com.fiap.vigiasaude.resource;

import java.util.List;

import br.com.fiap.vigiasaude.model.TipoUnidade;
import br.com.fiap.vigiasaude.service.TipoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tipo")
public class TipoResource {
	
	TipoService service = new TipoService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<TipoUnidade> listTipos = service.listarTodos();
		if (listTipos == null) Response.status(Response.Status.NOT_FOUND).entity("Não Encontrado").build();
		return Response.ok(listTipos).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarMedico(@PathParam("id") Long id){
		TipoUnidade tipo = service.buscarPorId(id);
		if (tipo == null) return Response.status(Response.Status.NOT_FOUND).entity("Não Encontrado").build();
		return Response.ok(tipo).build();
		
	}
}
