package com.laborintos.prueba.business;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laborintos.prueba.model.CalculatorOperation;
import com.laborintos.prueba.repository.ICalculatorOperationRepository;
import com.laborintos.prueba.services.CalculatorClient;
import com.laborintos.prueba.services.soap.scheme.AddResponse;
import com.laborintos.prueba.services.soap.scheme.DivideResponse;
import com.laborintos.prueba.services.soap.scheme.MultiplyResponse;
import com.laborintos.prueba.services.soap.scheme.SubtractResponse;

@Component
public class CalculatorBusiness {
	
	@Autowired
	private ICalculatorOperationRepository calculatorOperationRepository;
	
	@Autowired
	private CalculatorClient clientCalculator;
	
	
	public void saveResultOperationBasic() {
		getResultAdd(5,5);
		getResultMultiply(5,5);
		getResultDivide(5,5);
		getResulSustract(5,5);
	}
	
	
	private void getResultAdd(int valueA, int valueB) {
		AddResponse responseAdd = clientCalculator.getAddResponse(valueA, valueB);
		CalculatorOperation calculatorOperation = new CalculatorOperation ();
		calculatorOperation.setValueA(new BigInteger(String.valueOf(valueA)));
		calculatorOperation.setValueB(new BigInteger(String.valueOf(valueB)));
		calculatorOperation.setDescription("ADD");
		calculatorOperation.setResultCalculate(responseAdd.getAddResult());
		calculatorOperationRepository.save(calculatorOperation);
	}
	
	
	private void getResultMultiply(int valueA, int valueB) {
		MultiplyResponse responseMultiple = clientCalculator.getMultiplyResponse(valueA, valueB);
		CalculatorOperation calculatorOperation = new CalculatorOperation ();
		calculatorOperation.setValueA(new BigInteger(String.valueOf(valueA)));
		calculatorOperation.setValueB(new BigInteger(String.valueOf(valueB)));
		calculatorOperation.setDescription("MULTIPLY");
		calculatorOperation.setResultCalculate(responseMultiple.getMultiplyResult());
		calculatorOperationRepository.save(calculatorOperation);
	}
	
	private void getResultDivide(int valueA, int valueB) {
		DivideResponse responseDivide = clientCalculator.getDivideResponse(valueA, valueB);
		CalculatorOperation calculatorOperation = new CalculatorOperation ();
		calculatorOperation.setValueA(new BigInteger(String.valueOf(valueA)));
		calculatorOperation.setValueB(new BigInteger(String.valueOf(valueB)));
		calculatorOperation.setDescription("DIVIDE");
		calculatorOperation.setResultCalculate(responseDivide.getDivideResult());
		calculatorOperationRepository.save(calculatorOperation);
	}
	
	private void getResulSustract(int valueA, int valueB) {
		SubtractResponse responseSubtract = clientCalculator.getSubtractResponse(valueA, valueB);
		CalculatorOperation calculatorOperation = new CalculatorOperation ();
		calculatorOperation.setValueA(new BigInteger(String.valueOf(valueA)));
		calculatorOperation.setValueB(new BigInteger(String.valueOf(valueB)));
		calculatorOperation.setDescription("SUSTRACT");
		calculatorOperation.setResultCalculate(responseSubtract.getSubtractResult());
		calculatorOperationRepository.save(calculatorOperation);
	}
}
