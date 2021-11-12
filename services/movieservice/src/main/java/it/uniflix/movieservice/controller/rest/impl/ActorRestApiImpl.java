package it.uniflix.movieservice.controller.rest.impl;

import it.uniflix.actorservice.controller.soap.ActorDetail;
import it.uniflix.actorservice.controller.soap.ActorSoapApi;
import it.uniflix.actorservice.controller.soap.GetActor;
import it.uniflix.actorservice.controller.soap.GetActorResponse;
import it.uniflix.actorservice.controller.soap.impl.ActorSoapApiImplService;
import it.uniflix.movieservice.controller.rest.ActorRestApi;

public class ActorRestApiImpl implements ActorRestApi {

	@Override
	public ActorDetail getActorDetail(long id) {
		
		ActorSoapApiImplService service = new ActorSoapApiImplService();
		ActorSoapApi port = service.getActorSoapApiImplPort();

		GetActor request = new GetActor(); 
		request.setArg0(2524L);
		
		// synchronous request
		GetActorResponse response = port.getActor(request);
		System.out.println(response.getActorDetail());
		
		return response.getActorDetail();
	}

}
