package localiser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TimeZoneConverterTest {
    private static final String PACIFIC_AUCKLAND = "Pacific/Auckland";
    private static final String LATITUDE_AUCKLAND = "-44.490947";
    private static final String LONGITUDE_AUCKLAND = "171.220966";
    private static final String AUSTRALIA_SYDNEY = "Australia/Sydney";
    private static final String LATITUDE_SYDNEY = "-33.912167";
    private static final String LONGITUDE_SYDNEY = "151.215820";

    private TimeZoneConverter timeZoneConverter;

    @Before
    public void setUp() {
        timeZoneConverter = new TimeZoneConverter();
    }

    @Test()
    public void convertLatLongToZoneIdAuckland() {
        convertLatLongToZoneId(LATITUDE_AUCKLAND, LONGITUDE_AUCKLAND, PACIFIC_AUCKLAND);
    }

    @Test()
    public void convertLatLongToZoneIdSydney() {
        convertLatLongToZoneId(LATITUDE_SYDNEY, LONGITUDE_SYDNEY, AUSTRALIA_SYDNEY);
    }

    private void convertLatLongToZoneId(String latitude, String longitude, String expectedTimeZone) {
        try {
            assertEquals(timeZoneConverter.convertLatLonToZoneId(latitude, longitude).toString(), expectedTimeZone);
        } catch (Exception e) {
            fail();
        }
    }
}