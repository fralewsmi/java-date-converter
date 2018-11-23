package localiser;

import net.iakovlev.timeshape.TimeZoneEngine;

import java.time.ZoneId;
import java.util.Optional;

class TimeZoneConverter {
    ZoneId convertLatLonToZoneId(String latitude, String longitude) throws RuntimeException {
        Double latDouble = Double.parseDouble(latitude);
        Double lonDouble = Double.parseDouble(longitude);
        Optional<ZoneId> zoneIdOptional = queryTimeZoneEngine(latDouble, lonDouble);

        return zoneIdOptional.orElseThrow(RuntimeException::new);
    }

    private Optional<ZoneId> queryTimeZoneEngine(Double latDouble, Double lonDouble) {
        TimeZoneEngine timeZoneEngine = TimeZoneEngine.initialize();
        return timeZoneEngine.query(latDouble, lonDouble);
    }
}