package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.core.convert.converter.Converter;

public class UserConverterEntityToPage implements Converter<UserEntity, PageDTO<UserDTO>> {
    @Override
    public PageDTO<UserDTO> convert(UserEntity source) {
        return new PageDTO<UserDTO>();
    }
}
