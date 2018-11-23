package localiser;

public class Main {

    private static final String CSV_FILE_PATH = "test.csv";

    public static void main(String[] args) throws RuntimeException {
        CSVWriter csvWriter = new CSVWriter();
        csvWriter.writeCSV(CSV_FILE_PATH);
    }
}
