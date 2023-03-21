package Mk.JD2_95_22.fitness.core.converter.number;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.Instant;

public class InstantConverterToLong {
    public static class Serializer extends StdConverter<Instant, Long> {

        @Override
        public Long convert(Instant instant) {
            return instant.toEpochMilli();
        }
    }
}
