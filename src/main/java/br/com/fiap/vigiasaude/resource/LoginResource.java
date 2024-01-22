package br.com.fiap.vigiasaude.resource;

import br.com.fiap.vigiasaude.model.Medico;
import br.com.fiap.vigiasaude.model.Unidade;
import br.com.fiap.vigiasaude.service.MedicoService;
import br.com.fiap.vigiasaude.service.UnidadeService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("login")
public class LoginResource {
	
	UnidadeService unidadeService = new UnidadeService();
	MedicoService medicoService = new MedicoService();

	@POST
	@Path("medico")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginMedico(Medico medico) {
		if (!medicoService.validaMedico(medico)) 
			return Response.status(Response.Status.UNAUTHORIZED).entity("Não Autenticado").build();
		return Response.ok("Validado").build();
	}
	
	@POST
	@Path("unidade")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUnidade(Unidade unidade) {
		if(!unidadeService.validaUnidade(unidade)) 
			return Response.status(Response.Status.UNAUTHORIZED).entity("Não Autenticado").build();
		return Response.ok("Validado").build();
	}
}
