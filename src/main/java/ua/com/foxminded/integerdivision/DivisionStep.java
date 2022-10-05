package ua.com.foxminded.integerdivision;

import java.util.Objects;

public class DivisionStep {

	private int minuend;
	private int subtrahend;

	public DivisionStep(int minuend, int subtrahend) {
		this.minuend = minuend;
		this.subtrahend = subtrahend;
	}

	public int getMinuend() {
		return minuend;
	}

	public void setMinuend(int minuend) {
		this.minuend = minuend;
	}

	public int getSubtrahend() {
		return subtrahend;
	}

	public void setSubtrahend(int subtrahend) {
		this.subtrahend = subtrahend;
	}

	@Override
	public int hashCode() {
		return Objects.hash(minuend, subtrahend);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivisionStep other = (DivisionStep) obj;
		return minuend == other.minuend && subtrahend == other.subtrahend;
	}
}
