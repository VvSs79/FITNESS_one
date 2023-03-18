package Mk.JD2_95_22.fitness.converter.number_format;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.stereotype.Component;

import java.time.Instant;
@Component
public class InstantConvertorToLong extends StdConverter<Instant, Long> {
    @Override
    public Long convert(Instant value) {
        return value==null? null : value.toEpochMilli();
    }
}
