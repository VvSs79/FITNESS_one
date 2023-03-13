package Mk.JD2_95_22.fitness.servise.my_exeption.converter;

import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;

public class NotFounderConverterExeption extends ConverterNotFoundException {
    public NotFounderConverterExeption(TypeDescriptor sourceType, TypeDescriptor targetType) {
        super(sourceType, targetType);
    }
}
