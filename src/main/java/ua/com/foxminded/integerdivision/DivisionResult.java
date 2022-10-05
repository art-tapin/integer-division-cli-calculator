package ua.com.foxminded.integerdivision;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * The {@code DivisionResult} class stores the results of each division's steps
 * <p>
 * The data are:
 * 
 * <pre>
 * - Dividend, divisor, quotient
 * - List of DivisionStep objects
 * </pre>
 */
public class DivisionResult {

	private int dividend;
	private int divisor;
	private int quotient = 0;
	private List<DivisionStep> steps = new LinkedList<>();

	public void add(int minuend, int subtrahend) {
		steps.add(new DivisionStep(minuend, subtrahend));
	}

	public void add(DivisionStep step) {
		steps.add(step);
	}

	public int getQuotient() {
		return quotient;
	}

	public void setQuotient(int quotient) {
		this.quotient = quotient;
	}

	public int getDividend() {
		return dividend;
	}

	public void setDividend(int dividend) {
		this.dividend = dividend;
	}

	public int getDivisor() {
		return divisor;
	}

	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}

	public List<DivisionStep> getSteps() {
		return steps;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dividend, divisor, quotient, steps);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivisionResult other = (DivisionResult) obj;
		return dividend == other.dividend && divisor == other.divisor && quotient == other.quotient
				&& steps.equals(other.steps);
	}
}