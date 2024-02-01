package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.repository.EnglishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/27/19.
 */

//      in questo caso non serve @Service perché viene specificato in GreetingServiceConfig
//      uguale per @Profile("EN")
//@Profile("EN")
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {
    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }
}
