package bp;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by q on 12/12/14.
 */
public interface Ate {
    void readTransactions(URI uri) throws IOException, URISyntaxException;
    void processTransactions();
    void printAccounts();
}
