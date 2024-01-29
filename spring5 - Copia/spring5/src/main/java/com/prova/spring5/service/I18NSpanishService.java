package com.prova.spring5.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("i18nService")
public class I18NSpanishService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}