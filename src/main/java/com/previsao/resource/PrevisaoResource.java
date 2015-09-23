package com.previsao.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.previsao.dao.PrevisaoDAO;
import com.previsao.dto.Erro;
import com.previsao.entity.Previsao;
import com.previsao.service.BuscaPrevisao;
import com.previsao.xmlClass.CurrentWeather;

@Path("previsao")
public class PrevisaoResource {
	
	@Inject
	private BuscaPrevisao buscaPrevisao;
	
	@Inject
	private PrevisaoDAO dao;
	
    @GET
    @Produces({"application/json"})
    public Response buscar() {
    	try {
			CurrentWeather current = buscaPrevisao.buscar();
			Previsao previsao = Previsao.create(current);
			dao.salvarPrevisao(previsao);
	        return Response
	                .status(Response.Status.OK)
	                .entity(previsao)
	                .build();
		} catch (Exception e) {
			Erro erro = Erro.create("Erro Inesperado", e.getCause().getMessage());
	        return Response
	                .status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(erro)
	                .build();
		}
    	
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscar(@PathParam("id") Integer id) {
        Object previsao = dao.find(id);
        return Response
                .status(Response.Status.OK)
                .entity(previsao)
                .build();
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarTodos() {
    	List<Previsao> all = dao.findAll();
        return Response
                .status(Response.Status.OK)
                .entity(all)
                .build();
    }    
    

}
