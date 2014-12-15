package bp;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static org.junit.Assert.*;

public class SimpleFileATETest {
	static private final String TEST_FILE = "/ate.txt";
	SimpleFileAte ate = new SimpleFileAte();

	@Before
	public void setUp() throws IOException, URISyntaxException {
		URI resourceUrl = getClass().getResource(TEST_FILE).toURI();
		ate = new SimpleFileAte();
		ate.readTransactionFile(resourceUrl);
	}

	@Test
	public void testStreamToString() {
		assertNotNull("Test file missing", getClass().getResource(TEST_FILE));
	}


	@Test
	public void testReadTransactions() throws IOException, URISyntaxException {
		assertEquals(ate.getTransactions().size(), 4);
	}

	@Test
	public void testProcessTransactions() throws IOException, URISyntaxException {
		float balance;
		ate.processTransactions();
		Map<Integer, Float> accounts = ate.getAccounts();
		balance = accounts.get(1);
		assertEquals(balance, -200, 0.001);
		balance = accounts.get(2);
		assertEquals(balance, 0, 0.001);
		balance = accounts.get(3);
		assertEquals(balance, 200, 0.001);
	}

	@Test
	public void testPrintAccounts() {
		ate.printAccounts();
	}
}