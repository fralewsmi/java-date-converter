package localiser;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

public class CSVWriterTest {
    private static final String TEST_CSV_PATH = "test.csv";

    private CSVWriter csvWriter;

    @Before
    public void setUp() {
        csvWriter = new CSVWriter();
    }

    @Test()
    public void test() {
        try {
            csvWriter.writeCSV(TEST_CSV_PATH);
        } catch (RuntimeException e) {
            fail();
        }
    }
}
