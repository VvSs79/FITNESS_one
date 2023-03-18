package Mk.JD2_95_22.fitness.converter.number_format;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.stereotype.Component;
import java.time.Instant;
@Component
public class StringConverterToInstant extends StdConverter<String, Instant>{
        @Override
        public Instant convert(String value) {
            return value==null? null : Instant.ofEpochMilli(Long.decode(value));
        }
    }

