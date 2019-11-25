package com.calc;

import com.calc.util.CalculatorUtils;

/**
 * @author Divya Ramesh
 *
 */
public class InputValues {

	private String operator;
	private int value;

	public InputValues(String instruction) {
		try {
			String arrVal[] = CalculatorUtils.splitBySpace(instruction);
			if (arrVal.length == 2) {
				operator = arrVal[0].trim().toUpperCase();
				value = Integer.parseInt(arrVal[1].trim());
			}
		} catch (ArithmeticException e) {
			System.out.println(
					this.getClass().getSimpleName() + ": Instuction Value Not A Valid Number! : " + e.getMessage());
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + ": Exception : " + e.getMessage());
		}
	}

	public String getOperator() {
		return operator;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "InputValues [operator=" + operator + ", value=" + value + "]";
	}

}
