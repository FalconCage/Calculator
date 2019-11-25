package com.calc;

import java.util.List;

import com.calc.constants.CalculatorConstants;
import com.calc.util.CalculatorUtils;

/**
 * @author Divya Ramesh
 *
 */
public class CalcOperator {

	private int applyNumber;
	private boolean isValid;

	/**
	 * 
	 * @param instructionList
	 * @return Output Value
	 */
	public int calculateValues(List<String> instructionList) {
		try {
			applyNumber = getApplyNumFromInstructions(
					instructionList.stream().reduce((first, second) -> second).orElse(null));
			if (isValid) {
				instructionList.forEach(instruction -> {

					InputValues inputValues = new InputValues(instruction);
					int inputValue = inputValues.getValue();

					switch (inputValues.getOperator()) {
					case CalculatorConstants.ADD:
						applyNumber = applyNumber + inputValue;
						break;
					case CalculatorConstants.MULTIPLY:
						applyNumber = applyNumber * inputValue;
						break;
					case CalculatorConstants.SUBTRACT:
						applyNumber = applyNumber - inputValue;
						break;
					case CalculatorConstants.DIVIDE:
						applyNumber = applyNumber / inputValue;
						break;
					}
				});
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + ": calculateValues() : Exception : " + e.getMessage());
		}
		return applyNumber;
	}

	/**
	 * will return apply number for a operations, from a last line of the
	 * instruction list
	 * 
	 * @param applyInstruction
	 * @return applyNum
	 */
	private int getApplyNumFromInstructions(String applyInstruction) {
		int applyNum = -1;
		isValid = true;
		if (CalculatorUtils.isValidString(applyInstruction)) {
			InputValues inputValues = new InputValues(applyInstruction);
			if (inputValues.getOperator().equals(CalculatorConstants.APPLY)) {
				applyNum = inputValues.getValue();
			} else {
				isValid = false;
				System.out.println(this.getClass().getSimpleName()
						+ ": getApplyNumFromInstructions() : Last Instruction Must Be `APPLY`! ");
			}
		}
		return applyNum;
	}

}
