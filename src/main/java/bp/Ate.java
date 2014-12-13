package bp;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by q on 12/12/14.
 */
public interface Ate {
    void readTransactions(String s) throws IOException, URISyntaxException;
    void processTransactions();
    void printAccounts();
}
