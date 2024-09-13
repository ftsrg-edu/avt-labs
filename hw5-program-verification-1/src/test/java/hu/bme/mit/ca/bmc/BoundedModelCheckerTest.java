package hu.bme.mit.ca.bmc;

//import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import hu.bme.mit.theta.cfa.CFA;
import hu.bme.mit.theta.cfa.dsl.CfaDslManager;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public final class BoundedModelCheckerTest {

	@Parameter(value = 0)
	public String filepath;

	@Parameter(value = 1)
	public boolean safe;

	@Parameter(value = 2)
	public int bound;

	@Parameters(name = "{index}: {0}, {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				{ "src/test/resources/ca-ex_false.cfa", false, 30 },

				{ "src/test/resources/counter5_false.cfa", false, 30 },

				{ "src/test/resources/counter5_true.cfa", true, 30 },

				{ "src/test/resources/gcd_true.cfa", true, 15 },

				{ "src/test/resources/locking_true.cfa", true, 30 },

		});
	}

	@Test
	public void test() throws IOException {
		final InputStream inputStream = new FileInputStream(filepath);
		final CFA cfa = CfaDslManager.createCfa(inputStream);
		final SafetyChecker checker = BoundedModelChecker.create(cfa, bound, 5);

		final SafetyResult result = checker.check();
		if (safe) {
			assertEquals(SafetyResult.UNKNOWN, result);
		} else {
			assertEquals(SafetyResult.UNSAFE, result);
		}
	}

}
