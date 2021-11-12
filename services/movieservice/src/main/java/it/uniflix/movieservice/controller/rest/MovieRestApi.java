package it.uniflix.movieservice.controller.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.uniflix.movieservice.model.Movie;

@Path("/movie")
public interface MovieRestApi {

	@Operation(
			description = "Retrieve all available movies",
			responses = {
					@ApiResponse(
							description = "List of movies",
							content = {
									@Content(
											mediaType = MediaType.APPLICATION_JSON,
											array = @ArraySchema(schema = @Schema(implementation = Movie.class))),
									 @Content(
											 mediaType = MediaType.APPLICATION_XML,
											 array = @ArraySchema(schema = @Schema(implementation = Movie.class)))
							})
			})
	@GET
	public List<Movie> getMovies();

	@Operation(
			description = "Retrieve a movie given its id",
			responses = {
					@ApiResponse(
							description = "A movie",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON,
									schema = @Schema(implementation = Boolean.class)))
					}
			)
	@GET
	@Path("{id}")
	public Movie getMovie(@PathParam(value = "id") long id);
	

}
