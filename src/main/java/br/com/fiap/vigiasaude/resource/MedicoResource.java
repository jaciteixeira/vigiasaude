package br.com.fiap.vigiasaude.resource;

import br.com.fiap.vigiasaude.model.Medico;
import br.com.fiap.vigiasaude.service.MedicoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("medico")
public class MedicoResource {

	MedicoService service = new MedicoService();
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarMedico(@PathParam("id") Long id){
		Medico medico = service.buscarPorId(id);
		if (medico == null) return Response.status(Response.Status.NOT_FOUND).entity("Não Encontrado").build();
		return Response.ok(medico).build();
		
	}
	
	@POST
	@Path("cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarMedico(Medico medico) {
		if (service.existeMedico(medico)) return Response.status(Response.Status.CONFLICT).entity("Email em uso.").build();
		if (!service.cadastrarMedico(medico)) return Response.status(Response.Status.BAD_REQUEST).entity("Requisição Inválida.").build();
		return Response.ok(medico).build();
	}
	
}
