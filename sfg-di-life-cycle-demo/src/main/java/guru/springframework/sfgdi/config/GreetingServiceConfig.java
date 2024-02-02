package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.datasurce.FakeData;
import guru.springframework.sfgdi.repository.EnglishGreetingRepository;
import guru.springframework.sfgdi.repository.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import pets.PetService;
import pets.PetServiceFactory;

@EnableConfigurationProperties(SfgConstructorConfig.class)
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {
    @Bean
    FakeData fakeDataSource(SfgConstructorConfig sfgConstructorConfig) {
        FakeData fakeData = new FakeData();
        fakeData.setUsername(sfgConstructorConfig.getUsername());
        fakeData.setPassword(sfgConstructorConfig.getPassword());
        fakeData.setJdbcurl(sfgConstructorConfig.getJdbcurl());
            return fakeData;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
            return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
            return petServiceFactory.getPetService("dog");
    }
    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
            return petServiceFactory.getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18NSpanishService i18NSpanishService() {
            return new I18NSpanishService();
    }
    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
            return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
            return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
            return new PrimaryGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
            return new PropertyInjectedGreetingService();
    }
    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
            return new SetterInjectedGreetingService();
    }

}
