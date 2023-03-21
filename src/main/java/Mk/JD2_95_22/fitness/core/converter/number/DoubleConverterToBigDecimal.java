package Mk.JD2_95_22.fitness.core.converter.number;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleConverterToBigDecimal extends StdConverter<Double, BigDecimal> {
    @Override
    public BigDecimal convert(Double aDouble) {
        return BigDecimal.valueOf(aDouble).setScale(2, RoundingMode.CEILING);
    }
}
