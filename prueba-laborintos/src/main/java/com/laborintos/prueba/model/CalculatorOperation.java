package com.laborintos.prueba.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * The persistent class for the calculator_operation database table.
 * 
 */
@Entity
@Table(name = "calculator_operation")
@NamedQuery(name = "CalculatorOperation.findAll", query = "SELECT c FROM CalculatorOperation c")
public class CalculatorOperation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(name = "result_calculate")
	private double resultCalculate;

	@Column(name = "value_a")
	private BigInteger valueA;

	@Column(name = "value_b")
	private BigInteger valueB;

	public CalculatorOperation() {
	}

	public CalculatorOperation(String description, double resultCalculate, BigInteger valueA, BigInteger valueB) {
		super();
		this.description = description;
		this.resultCalculate = resultCalculate;
		this.valueA = valueA;
		this.valueB = valueB;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getResultCalculate() {
		return this.resultCalculate;
	}

	public void setResultCalculate(double resultCalculate) {
		this.resultCalculate = resultCalculate;
	}

	public BigInteger getValueA() {
		return this.valueA;
	}

	public void setValueA(BigInteger valueA) {
		this.valueA = valueA;
	}

	public BigInteger getValueB() {
		return this.valueB;
	}

	public void setValueB(BigInteger valueB) {
		this.valueB = valueB;
	}

}