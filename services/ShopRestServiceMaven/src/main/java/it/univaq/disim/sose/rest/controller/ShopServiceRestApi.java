

package it.univaq.disim.sose.rest.controller;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.disim.sose.rest.model.Movie_old;

@Path("/shop")
public interface ShopServiceRestApi {

	@Operation( 
		       description = "The description of the getTodos operation goes here!",
				responses = {
			       @ApiResponse(
			          description = "The description of the Response goes here!",
			          content = {
			             @Content(mediaType = MediaType.TEXT_XML, 
			                 array = @ArraySchema(schema = @Schema(implementation = Movie_old.class))),	            		
			             @Content(mediaType = MediaType.APPLICATION_XML,
			                 array = @ArraySchema(schema = @Schema(implementation = Movie_old.class))),
			             @Content(mediaType = MediaType.APPLICATION_JSON,
			                 array = @ArraySchema(schema = @Schema(implementation = Movie_old.class)))
			          }
			       )
			    }
			 )
		    @GET
		    //@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		    public List<Movie_old> getAllMovies();
		    
			@Operation(
		       description = "The description of the getTodo operation goes here!",
		       responses = {
		          @ApiResponse(
		             description = "The description of the Response goes here!", 
		             content = @Content(mediaType = MediaType.APPLICATION_JSON, 
		                                schema = @Schema(implementation = Movie_old.class)))
		           }
			)
			@GET
		    @Path("{id}")
		    public Movie_old getMovie(@PathParam(value = "id") String id);
}
