package Mk.JD2_95_22.fitness.core.converter.number;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class StringConverterToInstant implements Converter<String, Instant> {
    @Override
    public Instant convert(String value) {
        return Instant.ofEpochMilli(Long.decode(value));
    }
}
