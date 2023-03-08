package Mk.JD2_95_22.fitness.converter.number_format;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleConverter {
    public static class Serializer extends StdConverter<Double, BigDecimal>{
        @Override
        public BigDecimal convert(Double aDouble) {
            return aDouble==null? null : BigDecimal.valueOf(aDouble).setScale(2, RoundingMode.HALF_UP);
        }
    }
}
