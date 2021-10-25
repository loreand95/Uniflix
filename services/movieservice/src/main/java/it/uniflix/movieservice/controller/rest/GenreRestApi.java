package it.uniflix.movieservice.controller.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.uniflix.movieservice.model.Genre;
import it.uniflix.movieservice.model.Movie;

@Path("/genre")
public interface GenreRestApi {
	@Operation(
			description = "Retrieve all movies of a given genre",
			responses = {
					@ApiResponse(
							description = "List of movies by genre",
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
	@Path("{id}/movies")
	public List<Movie> getMoviesByGenre(@PathParam(value = "id") int id);
	
	@Operation(
			description = "Retrieve all genres",
			responses = {
					@ApiResponse(
							description = "List of genres",
							content = {
									@Content(
											mediaType = MediaType.APPLICATION_JSON,
											array = @ArraySchema(schema = @Schema(implementation = Genre.class))),
									 @Content(
											 mediaType = MediaType.APPLICATION_XML,
											 array = @ArraySchema(schema = @Schema(implementation = Genre.class)))
							})
			})
	@GET
	public List<Genre> getGenres();

}
