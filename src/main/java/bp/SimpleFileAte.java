package bp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by q on 1TE2/12/14.
 */
public class SimpleFileAte implements Ate {

	public List<Transaction> getTransactions() {
		return transactions;
	}

	List<Transaction> transactions = new ArrayList<>();

	public Map<Integer, Float> getAccounts() {
		return accounts;
	}

	Map<Integer, Float> accounts = new HashMap<>();

	static public void main(String[] args) throws IOException, URISyntaxException {
		Ate ate = new SimpleFileAte();
		ate.readTransactions(new URI(args[0]));
		ate.processTransactions();
		ate.printAccounts();
	}

	@Override
	public void readTransactions(URI uri) throws IOException, URISyntaxException {
		File file = new File(uri);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		StringTokenizer st;
		Transaction transaction;

		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			transaction = new Transaction(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
			transactions.add(transaction);
		}

		br.close();
		fr.close();
	}

	//@Transaction
	@Override
	public void processTransactions() {

		for (Transaction t : transactions) {
			if (!accounts.keySet().contains(t.getSecondAccount())) {
				accounts.put(t.getSecondAccount(), new Float(0));
			}

			if (!accounts.keySet().contains(t.getFirstAccount())) {
				accounts.put(t.getFirstAccount(), new Float(0));
			}

			switch (t.getTranType()) {
				case D:
					accounts.put(t.getFirstAccount(),  accounts.get(t.getFirstAccount())  + t.getTranAmount());
					accounts.put(t.getSecondAccount(), accounts.get(t.getSecondAccount()) - t.getTranAmount());
                    break;
				case C:
					accounts.put(t.getFirstAccount(),  accounts.get(t.getFirstAccount())  - t.getTranAmount());
					accounts.put(t.getSecondAccount(), accounts.get(t.getSecondAccount()) + t.getTranAmount());
			}
		}

	}

	@Override
	public void printAccounts() {
		for (int i : accounts.keySet()) {
			System.out.println("account: " + i + " amount: " + accounts.get(i));
		}

	}
}
