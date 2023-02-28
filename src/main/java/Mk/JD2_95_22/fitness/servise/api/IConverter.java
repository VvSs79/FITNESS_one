package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.core.dto.page.Page;
import org.springframework.core.convert.converter.Converter;

public interface IConverter<T, E> {
    Page<E> convert(Page<T> page, Converter<T, E> converter);
}
