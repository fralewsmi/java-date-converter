package localiser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

class DateConverter {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    String convertStringToZonedDateTimeString(String dateString, ZoneId zoneId) {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(
                LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
                        .toInstant(ZoneOffset.UTC)
                        .atZone(zoneId)
        );
    }
}
