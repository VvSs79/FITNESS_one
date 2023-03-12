package Mk.JD2_95_22.fitness.converter.number_format;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;

public class InstantConverter {
    public static class Deserializer extends StdConverter<Long, Instant> {
        @Override
        public Instant convert(Long aLong) {
            return aLong==null? null : Instant.ofEpochMilli(aLong);
        }
    }

        public  static class Serializer extends StdConverter<Instant, Long>{
            @Override
            public Long convert(Instant instant) {
            return instant==null? null : instant.toEpochMilli();
        }


        public static class StringtoInstantConverter extends  StdConverter<String, Instant>{
            @Override
            public Instant convert(String value) {
            return Instant.ofEpochMilli(Long.parseLong(value));
        }
        }
        public static class Deserializer implements Converter<String, Instant> {
            @Override
            public Instant convert(String time) {
                Instant longTime= Instant.ofEpochSecond(Long.decode(time));
                return longTime;

            }
        }

    }
}
