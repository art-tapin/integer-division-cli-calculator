package ua.com.foxminded.integerdivision;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntegerDivisionTest {

	private IntegerDivision integerDivision = new IntegerDivision();

	@Test
	void given_4_and_1_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(4, 1);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(4);
		expected.setDivisor(1);
		expected.add(4, 4);
		expected.setQuotient(4);
		assertEquals(expected, actual);
	}

	@Test
	void given_4_and_4_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(4, 4);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(4);
		expected.setDivisor(4);
		expected.add(4, 4);
		expected.setQuotient(1);
		assertEquals(expected, actual);
	}

	@Test
	void given_12_and_4_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(12, 4);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(12);
		expected.setDivisor(4);
		expected.add(12, 12);
		expected.setQuotient(3);
		assertEquals(expected, actual);
	}

	@Test
	void given_164_and_4_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(164, 4);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(164);
		expected.setDivisor(4);
		expected.add(16, 16);
		expected.add(4, 4);
		expected.setQuotient(41);
		assertEquals(expected, actual);
	}

	@Test
	void given_12345678_and_4_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(12345678, 4);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(12345678);
		expected.setDivisor(4);
		expected.add(12, 12);
		expected.add(3, 0);
		expected.add(34, 32);
		expected.add(25, 24);
		expected.add(16, 16);
		expected.add(7, 4);
		expected.add(38, 36);
		expected.setQuotient(3086419);
		assertEquals(expected, actual);
	}

	// Testing case: when firstMinuend is bigger in length then the difference
	@Test
	void given_123456777_and_9_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(123456777, 9);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(123456777);
		expected.setDivisor(9);
		expected.add(12, 9);
		expected.add(33, 27);
		expected.add(64, 63);
		expected.add(15, 9);
		expected.add(66, 63);
		expected.add(37, 36);
		expected.add(17, 9);
		expected.add(87, 81);
		expected.setQuotient(13717419);
		assertEquals(expected, actual);
	}

	@Test
	void given_405022500_and_45_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(405022500, 45);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(405022500);
		expected.setDivisor(45);
		expected.add(405, 405);
		expected.add(0, 0);
		expected.add(2, 0);
		expected.add(22, 0);
		expected.add(225, 225);
		expected.add(0, 0);
		expected.add(0, 0);
		expected.setQuotient(9000500);
		assertEquals(expected, actual);
	}

	@Test
	void given_1823000002_and_13_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(1823000002, 13);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(1823000002);
		expected.setDivisor(13);
		expected.add(18, 13);
		expected.add(52, 52);
		expected.add(3, 0);
		expected.add(30, 26);
		expected.add(40, 39);
		expected.add(10, 0);
		expected.add(100, 91);
		expected.add(90, 78);
		expected.add(122, 117);
		expected.setQuotient(140230769);
		assertEquals(expected, actual);
	}

	@Test
	void given_123456789_and_1234_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(123456789, 1234);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(123456789);
		expected.setDivisor(1234);
		expected.add(1234, 1234);
		expected.add(5, 0);
		expected.add(56, 0);
		expected.add(567, 0);
		expected.add(5678, 4936);
		expected.add(7429, 7404);
		expected.setQuotient(100046);
		assertEquals(expected, actual);
	}

	@Test
	void given_77777777_and_8888_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(77777777, 8888);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(77777777);
		expected.setDivisor(8888);
		expected.add(77777, 71104);
		expected.add(66737, 62216);
		expected.add(45217, 44440);
		expected.add(7777, 0);
		expected.setQuotient(8750);
		assertEquals(expected, actual);
	}

	@Test
	void given_99999999_and_765_whenDivide_thenGetDivisionResult() {
		DivisionResult actual = integerDivision.divide(99999999, 765);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(99999999);
		expected.setDivisor(765);
		expected.add(999, 765);
		expected.add(2349, 2295);
		expected.add(549, 0);
		expected.add(5499, 5355);
		expected.add(1449, 765);
		expected.add(6849, 6120);
		expected.setQuotient(130718);
		assertEquals(expected, actual);
	}

	@Test
	void given_negativeAndPositiveNums_whenDivide_thenDivisionResultWithPositiveNums() {
		DivisionResult actual = integerDivision.divide(-100, 10);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(100);
		expected.setDivisor(10);
		expected.add(10, 10);
		expected.add(0, 0);
		expected.setQuotient(10);
		assertEquals(expected, actual);
	}

	@Test
	void given_negativeNums_whenDivide_thenDivisionResultWithPositiveNums() {
		DivisionResult actual = integerDivision.divide(-100, -10);
		DivisionResult expected = new DivisionResult();
		expected.setDividend(100);
		expected.setDivisor(10);
		expected.add(10, 10);
		expected.add(0, 0);
		expected.setQuotient(10);
		assertEquals(expected, actual);
	}

	@Test
	void given_divisorBiggerThenDividend_whenDivide_thenEmptyCollections() {
		DivisionResult actual = integerDivision.divide(1, 10);
		DivisionResult expected = new DivisionResult();
		assertEquals(expected, actual);
	}

	@Test
	void given_divisorIsZero_whenDivide_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			integerDivision.divide(7, 0);
		});
	}
}