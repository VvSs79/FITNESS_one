package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import org.springframework.core.convert.converter.Converter;

public interface IConverter<T, E> {
    PageDTO<E> convert(PageDTO<T> page, Converter<T, E> converter);
}
