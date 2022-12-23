package dev.ambev.carshop.util;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil implements MessageSourceAware {
    private static MessageSource messageSource;

    public static String getMessage(String key, String... args) {
        return messageSource.getMessage(key, args, Locale.getDefault());
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        MessageUtil.messageSource = messageSource;
    }
}
