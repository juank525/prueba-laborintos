package com.laborintos.prueba.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.laborintos.prueba.services.soap.scheme.Add;
import com.laborintos.prueba.services.soap.scheme.AddResponse;
import com.laborintos.prueba.services.soap.scheme.Divide;
import com.laborintos.prueba.services.soap.scheme.DivideResponse;
import com.laborintos.prueba.services.soap.scheme.MultiplyResponse;
import com.laborintos.prueba.services.soap.scheme.Subtract;
import com.laborintos.prueba.services.soap.scheme.SubtractResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

	@Value("${url.services.soap}")
	private String urlService;

	public AddResponse getAddResponse(int valueA, int valueB) {
		Add request = new Add();
		request.setIntA(valueA);
		request.setIntB(valueB);
		AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(urlService, request,
				new SoapActionCallback("http://tempuri.org/Add"));

		return response;
	}

	public SubtractResponse getSubtractResponse(int valueA, int valueB) {
		Subtract request = new Subtract();
		request.setIntA(valueA);
		request.setIntB(valueB);
		SubtractResponse response = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(urlService,
				request, new SoapActionCallback("http://tempuri.org/Subtract"));
		return response;
	}
	
	public DivideResponse getDivideResponse(int valueA, int valueB) {
		Divide request = new Divide();
		request.setIntA(valueA);
		request.setIntB(valueB);
		DivideResponse response = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(urlService,
				request, new SoapActionCallback("http://tempuri.org/Divide"));
		return response;
	}
	
	public MultiplyResponse getMultiplyResponse(int valueA, int valueB) {
		Subtract request = new Subtract();
		request.setIntA(valueA);
		request.setIntB(valueB);
		MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(urlService,
				request, new SoapActionCallback("http://tempuri.org/Multiply"));
		return response;
	}

}
