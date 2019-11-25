package com.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.calc.constants.CalculatorConstants;
import com.calc.util.CalculatorUtils;

/**
 * @author Divya Ramesh
 *
 */
public class InputFileReader {

	public List<String> instructionList = new ArrayList<String>();

	/**
	 * will create instruction list from a file
	 * 
	 * @return List<String>
	 */
	public List<String> getInstructionListFromFile() {
		String filePath = CalculatorConstants.FILE_PATH;
		try {
			if (!CalculatorUtils.isValidString(filePath)) {
				filePath = readFilePathFromCmdLine();
			}
			try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
				instructionList = br.lines().collect(Collectors.toList());
			} catch (IOException e) {
				System.out.println(this.getClass().getSimpleName() + ": getInstructionListFromFile() : IO Exception : "
						+ e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(
					this.getClass().getSimpleName() + ": getInstructionListFromFile() : Exception : " + e.getMessage());
		}
		return instructionList;
	}

	/**
	 * 
	 * Will read file path from a command line
	 * 
	 * @return filePath
	 */
	private String readFilePathFromCmdLine() {
		String filePath = "";
		Scanner scanner = null;
		try {
			scanner = new Scanner(new InputStreamReader(System.in));
			System.out.println("Please Enter Valid File Path: ");
			filePath = scanner.nextLine();
		} catch (Exception e) {
			System.out.println(
					this.getClass().getSimpleName() + ": readFilePathFromCmdLine() : Exception : " + e.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return filePath;

	}
}
