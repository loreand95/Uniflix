package it.uniflix.payservice.controller.rest.impl;

import javax.ws.rs.core.Response;

import it.uniflix.payservice.controller.rest.PayController;
import it.uniflix.payservice.dto.PayResponse;
import it.uniflix.payservice.model.Payment;

public class PayControllerImpl implements PayController{

	@Override
	public Response pay(Payment payment) {
		
		PayResponse res = new PayResponse();
		
		if(payment.getAmount() >= 100) {
			res.setPaid(false);
			res.setMessage("No Money!");
		}else {
			res.setPaid(true);
			res.setMessage("OK!");
		}
		
		return Response.ok(res).build();
	}
}
