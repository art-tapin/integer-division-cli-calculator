package ua.com.foxminded.integerdivision;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivisionFormatterTest {
	
	private DivisionFormatter formatter = new DivisionFormatter();

	@Test
	void given_null_whenFormat_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.format(null);
		});
	}
	
	@Test
	void given_emptyDivisionResult_whenFormat_thenGetMessage() {
		String expected = "Dividend is bigger than divisor or equals to '0'" 
				+ System.lineSeparator() + "Answer is '0'";
		DivisionResult result = new DivisionResult();
		String actual = formatter.format(result);
		assertEquals(expected, actual);
	}
	
	@Test
	void given_4_and_1_whenFormat_thenGetFormattedOutput() {
		String expected = "_4|1" + System.lineSeparator()
				+ " 4|-" + System.lineSeparator()
				+ " -|4" + System.lineSeparator()
				+ " 0";
		DivisionResult result = new DivisionResult();
		result.setDividend(4);
		result.setDivisor(1);
		result.add(4, 4);
		result.setQuotient(4);
		String actual = formatter.format(result);
		assertEquals(expected, actual);
	}
	
	@Test
	void given_12_and_4_whenFormat_thenGetFormattedOutput() {
		String expected = "_12|4" + System.lineSeparator()
				+ " 12|-" + System.lineSeparator()
				+ " --|3" + System.lineSeparator()
				+ "  0";
		DivisionResult result = new DivisionResult();
		result.setDividend(12);
		result.setDivisor(4);
		result.add(12, 12);
		result.setQuotient(3);
		String actual = formatter.format(result);
		assertEquals(expected, actual);
	}
	
	@Test
	void given_164_and_4_whenFormat_thenGetFormattedOutput() {
		String expected = "_164|4" + System.lineSeparator()
				+ " 16 |--" + System.lineSeparator()
				+ " -- |41" + System.lineSeparator()
				+ "  _4" + System.lineSeparator()
				+ "   4" + System.lineSeparator()
				+ "   -" + System.lineSeparator()
				+ "   0";
		DivisionResult result = new DivisionResult();
		result.setDividend(164);
		result.setDivisor(4);
		result.add(16, 16);
		result.add(4, 4);
		result.setQuotient(41);
		String actual = formatter.format(result);
		assertEquals(expected, actual);
	}
	
	@Test
	void given_12345678_and_4_whenFormat_thenGetFormattedOutput() {
		String expected = "_12345678|4" + System.lineSeparator()
				+ " 12      |-------" + System.lineSeparator()
				+ " --      |3086419" + System.lineSeparator()
				+ "  _3" + System.lineSeparator()
				+ "   0" + System.lineSeparator()
				+ "   -" + System.lineSeparator()
				+ "  _34" + System.lineSeparator()
				+ "   32" + System.lineSeparator()
				+ "   --" + System.lineSeparator()
				+ "   _25" + System.lineSeparator()
				+ "    24" + System.lineSeparator()
				+ "    --" + System.lineSeparator()
				+ "    _16" + System.lineSeparator()
				+ "     16" + System.lineSeparator()
				+ "     --" + System.lineSeparator()
				+ "      _7" + System.lineSeparator()
				+ "       4" + System.lineSeparator()
				+ "       -" + System.lineSeparator()
				+ "      _38" + System.lineSeparator()
				+ "       36" + System.lineSeparator()
				+ "       --" + System.lineSeparator()
				+ "        2";
		DivisionResult result = new DivisionResult();
		result.setDividend(12345678);
		result.setDivisor(4);
		result.add(12, 12);
		result.add(3, 0);
		result.add(34, 32);
		result.add(25, 24);
		result.add(16, 16);
		result.add(7, 4);
		result.add(38, 36);
		result.setQuotient(3086419);
		String actual = formatter.format(result);
		assertEquals(expected, actual);
	}
	
	@Test
	void given_405022500_and_45_whenFormat_thenGetFormattedOutput() {
		String expected = "_405022500|45" + System.lineSeparator()
				+ " 405      |-------" + System.lineSeparator()
				+ " ---      |9000500" + System.lineSeparator()
				+ "   _0" + System.lineSeparator()
				+ "    0" + System.lineSeparator()
				+ "    -" + System.lineSeparator()
				+ "    _2" + System.lineSeparator()
				+ "     0" + System.lineSeparator()
				+ "     -" + System.lineSeparator()
				+ "    _22" + System.lineSeparator()
				+ "      0" + System.lineSeparator()
				+ "     --" + System.lineSeparator()
				+ "    _225" + System.lineSeparator()
				+ "     225" + System.lineSeparator()
				+ "     ---" + System.lineSeparator()
				+ "       _0" + System.lineSeparator()
				+ "        0" + System.lineSeparator()
				+ "        -" + System.lineSeparator()
				+ "        _0" + System.lineSeparator()
				+ "         0" + System.lineSeparator()
				+ "         -" + System.lineSeparator()
				+ "         0";
		DivisionResult result = new DivisionResult();
		result.setDividend(405022500);
		result.setDivisor(45);
		result.add(405, 405);
		result.add(0, 0);
		result.add(2, 0);
		result.add(22, 0);
		result.add(225, 225);
		result.add(0, 0);
		result.add(0, 0);
		result.setQuotient(9000500);
		String actual = formatter.format(result);
		assertEquals(expected, actual);
	}
	
	@Test
	void given_99999999_and_765_whenFormat_thenGetFormattedOutput() {
		String expected = "_99999999|765" + System.lineSeparator()
				+ " 765     |------" + System.lineSeparator()
				+ " ---     |130718" + System.lineSeparator()
				+ "_2349" + System.lineSeparator()
				+ " 2295" + System.lineSeparator()
				+ " ----" + System.lineSeparator()
				+ "  _549" + System.lineSeparator()
				+ "     0" + System.lineSeparator()
				+ "   ---" + System.lineSeparator()
				+ "  _5499" + System.lineSeparator()
				+ "   5355" + System.lineSeparator()
				+ "   ----" + System.lineSeparator()
				+ "   _1449" + System.lineSeparator()
				+ "     765" + System.lineSeparator()
				+ "    ----" + System.lineSeparator()
				+ "    _6849" + System.lineSeparator()
				+ "     6120" + System.lineSeparator()
				+ "     ----" + System.lineSeparator()
				+ "      729";
		DivisionResult result = new DivisionResult();
		result.setDividend(99999999);
		result.setDivisor(765);
		result.add(999, 765);
		result.add(2349, 2295);
		result.add(549, 0);
		result.add(5499, 5355);
		result.add(1449, 765);
		result.add(6849, 6120);
		result.setQuotient(130718);
		String actual = formatter.format(result);
		assertEquals(expected, actual);
	}
	
	@Test
	void given_123456789_and_1234_whenFormat_thenGetFormattedOutput() {
		String expected = "_123456789|1234" + System.lineSeparator()
				+ " 1234     |------" + System.lineSeparator()
				+ " ----     |100046" + System.lineSeparator()
				+ "    _5" + System.lineSeparator()
				+ "     0" + System.lineSeparator()
				+ "     -" + System.lineSeparator()
				+ "    _56" + System.lineSeparator()
				+ "      0" + System.lineSeparator()
				+ "     --" + System.lineSeparator()
				+ "    _567" + System.lineSeparator()
				+ "       0" + System.lineSeparator()
				+ "     ---" + System.lineSeparator()
				+ "    _5678" + System.lineSeparator()
				+ "     4936" + System.lineSeparator()
				+ "     ----" + System.lineSeparator()
				+ "     _7429" + System.lineSeparator()
				+ "      7404" + System.lineSeparator()
				+ "      ----" + System.lineSeparator()
				+ "        25";
		DivisionResult result = new DivisionResult();
		result.setDividend(123456789);
		result.setDivisor(1234);
		result.add(1234, 1234);
		result.add(5, 0);
		result.add(56, 0);
		result.add(567, 0);
		result.add(5678, 4936);
		result.add(7429, 7404);
		result.setQuotient(100046);
		String actual = formatter.format(result);
		assertEquals(expected, actual);
	}
	
	@Test
	void given_99999999_and_99999999_whenFormat_thenGetFormattedOutput() {
		String expected = "_99999999|99999999" + System.lineSeparator()
				+ " 99999999|--------" + System.lineSeparator()
				+ " --------|1" + System.lineSeparator()
				+ "        0";
		DivisionResult result = new DivisionResult();
		result.setDividend(99999999);
		result.setDivisor(99999999);
		result.add(99999999, 99999999);
		result.setQuotient(1);
		String actual = formatter.format(result);
		assertEquals(expected, actual);
	}
}