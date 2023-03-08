package Mk.JD2_95_22.fitness.converter.number_format;

import com.fasterxml.jackson.databind.util.StdConverter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalConverter extends StdConverter<BigDecimal, BigDecimal> {
    @Override
    public BigDecimal convert(BigDecimal bigDecimal) {
        if(bigDecimal == null) {
            return null;
        }
            return bigDecimal.setScale(2, RoundingMode.HALF_UP);

    }
}
