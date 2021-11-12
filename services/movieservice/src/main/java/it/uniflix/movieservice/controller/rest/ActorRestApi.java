package it.uniflix.movieservice.controller.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.uniflix.actorservice.controller.soap.ActorDetail;

@Path("/actor")
public interface ActorRestApi {

	@Operation(
			description = "Retrieve an actor details by its id",
			responses = {
					@ApiResponse(
							description = "Actor details",
							content = {
									@Content(
											mediaType = MediaType.APPLICATION_JSON,
											array = @ArraySchema(schema = @Schema(implementation = ActorDetail.class))),
									 @Content(
											 mediaType = MediaType.APPLICATION_XML,
											 array = @ArraySchema(schema = @Schema(implementation = ActorDetail.class)))
							})
			})
	@GET
	@Path("{id}")
	public ActorDetail getActorDetail(@PathParam(value = "id") long id);
}
