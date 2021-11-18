

package it.univaq.disim.sose.rest.controller;
import java.util.List;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.disim.sose.rest.model.MovieBO;

@Path("/shop")
public interface ShopRestControllerApi {

	@Operation( 
			description = "The description of the getTodos operation goes here!",
			responses = {
					@ApiResponse(
							description = "The description of the Response goes here!",
							content = {
									@Content(mediaType = MediaType.TEXT_XML, 
											array = @ArraySchema(schema = @Schema(implementation = MovieBO.class))),	            		
									@Content(mediaType = MediaType.APPLICATION_XML,
									array = @ArraySchema(schema = @Schema(implementation = MovieBO.class))),
									@Content(mediaType = MediaType.APPLICATION_JSON,
									array = @ArraySchema(schema = @Schema(implementation = MovieBO.class)))
							}
							)
			}
			)
	@GET
	//@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<MovieBO> getAllMovies();

	@Operation(
			description = "The description of the getTodo operation goes here!",
			responses = {
					@ApiResponse(
							description = "The description of the Response goes here!", 
							content = @Content(mediaType = MediaType.APPLICATION_JSON, 
							schema = @Schema(implementation = MovieBO.class)))
			}
			)
	@GET
	@Path("/movie/{id}")
	public MovieBO getMovieById(@PathParam(value = "id") String id);

	@Operation(
			description = "The description of the getTodo operation goes here!",
			responses = {
					@ApiResponse(
							description = "The description of the Response goes here!", 
							content = @Content(mediaType = MediaType.APPLICATION_JSON, 
							schema = @Schema(implementation = MovieBO.class)))
			}
			)
	@POST
	@Path("/buy/{id}")
	public String buyMovie(@PathParam(value = "id") String id);

}