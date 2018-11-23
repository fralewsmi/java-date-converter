package localiser;

import org.junit.Before;
import org.junit.Test;

import java.time.ZoneId;

import static org.junit.Assert.assertEquals;

public class DateConverterTest {
    private static final String TEST_DATE = "2013-07-10 02:52:49";
    private static final String DATE_AUCKLAND = "2013-07-10T14:52:49";
    private static final String DATE_SYDNEY = "2013-07-10T12:52:49";
    private static final String PACIFIC_AUCKLAND = "Pacific/Auckland";
    private static final String AUSTRALIA_SYDNEY = "Australia/Sydney";

    private DateConverter dateConverter;

    @Before
    public void setUp() {
        dateConverter = new DateConverter();
    }

    @Test()
    public void testConvertStringAndZoneToLocalDateTimeAuckland() {
        testConvertStringAndZoneToLocalDateTime(PACIFIC_AUCKLAND, DATE_AUCKLAND);
    }

    @Test()
    public void testConvertStringAndZoneToLocalDateTimeSydney() {
        testConvertStringAndZoneToLocalDateTime(AUSTRALIA_SYDNEY, DATE_SYDNEY);
    }

    private void testConvertStringAndZoneToLocalDateTime(String timeZone, String expectedLocalDateTime) {
        ZoneId zoneId = ZoneId.of(timeZone);
        String actualLocalDateTime = dateConverter.convertStringToZonedDateTimeString(TEST_DATE, zoneId);
        assertEquals(expectedLocalDateTime, actualLocalDateTime);
    }
}