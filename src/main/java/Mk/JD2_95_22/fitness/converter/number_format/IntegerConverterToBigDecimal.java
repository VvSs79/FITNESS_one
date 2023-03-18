package Mk.JD2_95_22.fitness.converter.number_format;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
@Component
public class IntegerConverterToBigDecimal extends StdConverter<Integer, BigDecimal> {
    @Override
    public BigDecimal convert(Integer value) {
        return value==null ? null : BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }
}
