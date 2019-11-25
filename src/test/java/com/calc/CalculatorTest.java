package com.calc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CalculatorTest {

	private Calculator calculator;
	private List<String> instructionList;
	private Integer expectedOutput;

	@Before
	public void initialize() {
		calculator = new Calculator();
	}

	public CalculatorTest(List<String> instructionList, Integer output) {
		this.instructionList = instructionList;
		this.expectedOutput = output;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> instructionList() {
		return Arrays.asList(new Object[][] { 
			{ Arrays.asList("add 1", "apply 2"), 3 },
			{ Arrays.asList("SubTRACT 1", "apply 2"), 1 },
			{ Arrays.asList("DIVIDE 2", "Apply 10"), 5 },
			{ Arrays.asList("multiply 2", "APPLY 2"), 4 },
			{ Arrays.asList("add 1", "multiply 2", "SubTRACT 2", "DIVIDE 2", "apply 2"), 2 },
			{ Arrays.asList("APPLY 2"), 2 }
		});
	}

	@Test
	public void doCalculations() {
		assertEquals(expectedOutput, calculator.retriveResultBasedOnInstrinction(instructionList));
	}

}
