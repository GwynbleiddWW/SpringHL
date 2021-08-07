package ru.netology.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.netology.controller.ProfileController;
import ru.netology.systemprofyle.DevProfile;
import ru.netology.systemprofyle.ProductionProfile;
import ru.netology.systemprofyle.SystemProfile;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(value = "profile.dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
