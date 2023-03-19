package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.model.UserJsonModel;
import Mk.JD2_95_22.fitness.servise.user_holder.UserHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestController {
    private final ConversionService conversionService;
    private final UserHolder holder;

    public TestController(ConversionService conversionService, UserHolder holder) {
        this.conversionService = conversionService;
        this.holder = holder;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "user";
    }

    @RequestMapping(value = "/details")
    public UserDetails details(){
        return conversionService.convert(holder.getUser(), UserDetails.class);
    }
}

