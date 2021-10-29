package it.uniflix.actorservice.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name="ActorDetail")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorDetail {
	private long actorId

}
