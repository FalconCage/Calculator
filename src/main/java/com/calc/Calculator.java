package com.calc;

import java.util.List;

/**
 * @author Divya Ramesh
 *
 */
public class Calculator {

	public static void main(String args[]) {
		new Calculator().startCalculation();
	}

	/**
	 * will do calculations based on instructions from a file
	 * 
	 */
	public void startCalculation() {
		try {
			List<String> instructionList = new InputFileReader().getInstructionListFromFile();
			int outputValue = retriveResultBasedOnInstrinction(instructionList);
			System.out.println("Output Value : " + outputValue);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + ": Exception : " + e.getMessage());
		}
	}

	/**
	 * @param instructionList
	 * @return outputValue
	 */
	public Integer retriveResultBasedOnInstrinction(List<String> instructionList) {
		return new CalcOperator().calculateValues(instructionList);
	}

}
