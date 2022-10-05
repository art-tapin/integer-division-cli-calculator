package ua.com.foxminded.integerdivision;

/**
 * The {@code IntegerDivision} class represents the intermediate computations of
 * subtype of "long division" calculation e.g. 'Integer division with remainder'
 * <p>
 * After all dividing steps {@code divide} method returns list of division
 * intermediate results. They are the 'minuend', 'subtract', 'difference' of
 * each division step
 * <p>
 * Example (CIS countries format): <blockquote>
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
 * 
 * </blockquote> The intermediate results are: <br/>
 * 12, 12 <-- 12 - 12 = 0 <br/>
 * 3, 0 <-- 3 - 0 = 3 <br/>
 * 34, 32 <-- 34 - 32 = 2 <br/>
 * '2' is a remainder of the division
 * 
 * <p>
 * Don't forget to follow simple rules: <br/>
 * - It is not allowed to divide by zero <br/>
 * - It works only with integers
 */
public class IntegerDivision {

	/**
	 * <p>
	 * Returns list of intermediate division results.
	 * <p>
	 * They are: "minuend" and "subtrahend" of each division step till the remainder
	 * 
	 * @param dividend of the equation
	 * @param divisor  of the equation
	 * @return DivisionResult object
	 */
	public DivisionResult divide(int dividend, int divisor) {
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		if (divisor == 0) {
			throw new IllegalArgumentException("Division by zero!");
		}
		if (dividend == 0 || divisor > dividend) {
			return new DivisionResult();
		}
		DivisionResult result = new DivisionResult();
		result.setDividend(dividend);
		result.setDivisor(divisor);
		int[] dividendDigits = splitToDigits(dividend);
		int i = 0;
		int minuend = dividendDigits[i];
		while (minuend < divisor) {
			minuend = minuend * 10 + dividendDigits[++i];
		}
		int quotient = 0;
		int subtrahend = 0;
		int nextQuotientDigit = 0;
		while (dividendDigits.length > i) {
			nextQuotientDigit = minuend / divisor;
			subtrahend = nextQuotientDigit * divisor;
			result.add(minuend, subtrahend);
			quotient = quotient * 10 + nextQuotientDigit;
			if (i + 1 == dividendDigits.length) {
				break;
			}
			minuend = (minuend % divisor) * 10 + dividendDigits[++i];
		}
		result.setQuotient(quotient);
		return result;
	}

	private int[] splitToDigits(int number) {
		int length;
		if (number == 0) {
			length = 1;
		} else {
			length = (int) (Math.log10(number) + 1);
		}
		int[] arrayOfDigits = new int[length];
		int i = 0;
		while (number != 0) {
			arrayOfDigits[length - i - 1] = number % 10;
			number /= 10;
			i++;
		}
		return arrayOfDigits;
	}
}