package ua.com.foxminded.integerdivision;

import java.util.List;

/**
 * The {@code DivisionFormatter} class is responsible for formatting the integer
 * division results, received from DivisionResult object, for future outputting
 * in the console.
 * <p>
 * This formatter makes a CIS countries format
 * <p>
 * Example (CIS countries format):
 * 
 * <pre>
 * _1234|4
 *  12  |----
 *  --  |308
 *   _3
 *    0
 *    -
 *   _34
 *    32
 *    --
 *     2
 * </pre>
 */
public class DivisionFormatter {

	/**
	 * Format output of division (CIS countries format)
	 * 
	 * @param result - object that stores intermediate division steps' values
	 * @return String of formatted output
	 */
	public String format(DivisionResult result) {
		if (result == null) {
			throw new IllegalArgumentException("The input is NULL!");
		}
		if (result.getSteps().isEmpty()) {
			return "Dividend is bigger than divisor or equals to '0'" + System.lineSeparator() + "Answer is '0'";
		}
		StringBuilder formattedResult = new StringBuilder();
		List<DivisionStep> steps = result.getSteps();
		formattedResult.append(drawFirstStep(result, steps.get(0).getSubtrahend()));
		if (steps.size() == 1) {
			formattedResult.append(" ".repeat(getLengthOf(steps.get(0).getMinuend())));
			formattedResult.append(steps.get(0).getMinuend() - steps.get(0).getSubtrahend());
			return formattedResult.toString();
		}
		formattedResult.append(drawDivisionSteps(steps));
		return formattedResult.toString();
	}

	private String drawFirstStep(DivisionResult result, int subtrahend) {
		int dividend = result.getDividend();
		int divisor = result.getDivisor();
		int quotient = result.getQuotient();
		return "_" + dividend + "|" + divisor + System.lineSeparator() + " " + subtrahend
				+ " ".repeat(getLengthOf(dividend) - getLengthOf(subtrahend)) + "|"
				+ "-".repeat(Math.max(getLengthOf(quotient), getLengthOf(divisor))) + System.lineSeparator() + " "
				+ "-".repeat(getLengthOf(subtrahend)) + " ".repeat(getLengthOf(dividend) - getLengthOf(subtrahend))
				+ "|" + quotient + System.lineSeparator();
	}

	private String drawDivisionSteps(List<DivisionStep> steps) {
		StringBuilder formattedResult = new StringBuilder();
		int offset = 0;
		for (int i = 1; i < steps.size(); i++) {
			offset = getOffset(steps.get(i - 1), offset);
			formattedResult.append(drawStep(steps.get(i), offset));
			formattedResult.append(System.lineSeparator());
		}
		int lastMinuend = steps.get(steps.size() - 1).getMinuend();
		int lastSubtrahend = steps.get(steps.size() - 1).getSubtrahend();
		int remainder = lastMinuend - lastSubtrahend;
		formattedResult.append(drawRemainder(lastMinuend, remainder, offset));
		return formattedResult.toString();
	}

	private String drawStep(DivisionStep currentStep, int offset) {
		String minuend = "_" + currentStep.getMinuend();
		int lengthDifference = getLengthOf(currentStep.getMinuend()) - getLengthOf(currentStep.getSubtrahend());
		String subtrahend = " ".repeat(lengthDifference + 1) + currentStep.getSubtrahend();
		return " ".repeat(offset) + minuend + System.lineSeparator() + " ".repeat(offset) + subtrahend
				+ System.lineSeparator() + " ".repeat(offset + 1) + "-".repeat(minuend.length() - 1);
	}

	private String drawRemainder(int minuend, int remainder, int offset) {
		return " ".repeat(offset + (1 + getLengthOf(minuend)) - getLengthOf(remainder)) + remainder;

	}

	private int getOffset(DivisionStep lastStep, int lastOffset) {
		int minuend = lastStep.getMinuend();
		int subtrahend = lastStep.getSubtrahend();
		int difference = minuend - subtrahend;
		if (difference == 0) {
			if (minuend == 0 && subtrahend == 0) {
				return lastOffset + 1;
			} else if (subtrahend == 0) {
				return lastOffset;
			}
			return lastOffset + getLengthOf(minuend) - getLengthOf(difference) + 1;
		}
		return lastOffset + getLengthOf(minuend) - getLengthOf(difference);
	}

	private int getLengthOf(int number) {
		if (number == 0) {
			return 1;
		}
		return (int) (Math.log10(number) + 1);
	}
}