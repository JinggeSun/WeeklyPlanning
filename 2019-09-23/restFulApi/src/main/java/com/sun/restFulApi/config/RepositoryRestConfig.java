package com.sun.restFulApi.config;

import com.sun.restFulApi.validator.BookValidator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeSave",new BookValidator());
        validatingListener.addValidator("beforCreate",new BookValidator());
    }
}
