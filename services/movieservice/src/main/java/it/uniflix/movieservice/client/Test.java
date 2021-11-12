package it.uniflix.movieservice.client;

import it.uniflix.actorservice.controller.soap.ActorSoapApi;
import it.uniflix.actorservice.controller.soap.GetActor;
import it.uniflix.actorservice.controller.soap.GetActorResponse;
import it.uniflix.actorservice.controller.soap.GetMovieCast;
import it.uniflix.actorservice.controller.soap.GetMovieCastResponse;
import it.uniflix.actorservice.controller.soap.impl.ActorSoapApiImplService;

public class Test {
	public static void main(String[] args) {
		ActorSoapApiImplService service = new ActorSoapApiImplService();
		ActorSoapApi port = service.getActorSoapApiImplPort();

		GetActor request = new GetActor(); 
		request.setArg0(2524L);
		
		GetActorResponse response = port.getActor(request);
		System.out.println(response.getActorDetail());
		
		GetMovieCast request2 = new GetMovieCast();
		request2.setArg0(438631L);
		
		GetMovieCastResponse response2 = port.getMovieCast(request2);
		System.out.println(response2.getCast());
	}
}
