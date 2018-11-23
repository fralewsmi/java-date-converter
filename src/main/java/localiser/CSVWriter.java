package localiser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.ZoneId;

public class CSVWriter {
    private static final String TEMP_FILE_PATH = "temp.csv";
    private static final String OUTPUT_FORMAT = "%s,%s,%s,%s,%s";
    private TimeZoneConverter timeZoneConverter;
    private DateConverter dateConverter;

    void writeCSV(String csvFilePath) throws RuntimeException {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String line;
        File csvFile = new File(csvFilePath);
        File tempFile = new File(TEMP_FILE_PATH);
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    bufferedWriter.write(getString(data[0], data[1], data[2]));
                }
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace(); // this is ok
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace(); // this is ok
                }
            }
        }
        try {
            Files.move(tempFile.toPath(), csvFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace(); // this is ok
        }
    }

    private String getString(String UTCDateTime, String latitude, String longitude) throws RuntimeException {
        timeZoneConverter = new TimeZoneConverter();
        dateConverter = new DateConverter();

        ZoneId zoneId = timeZoneConverter.convertLatLonToZoneId(latitude, longitude);
        String localDateString = dateConverter.convertStringToZonedDateTimeString(UTCDateTime, zoneId);

        return String.format(OUTPUT_FORMAT, UTCDateTime, latitude, longitude, zoneId.getId(), localDateString);
    }
}
