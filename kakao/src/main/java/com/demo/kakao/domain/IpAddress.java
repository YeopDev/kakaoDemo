package com.demo.kakao.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IpAddress {
    private static final Pattern validPattern = Pattern.compile(
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    private String content;

    public IpAddress(String content) {
        validate(content);
        this.content = content;
    }

    private void validate(String address) {
        if (!validPattern.matcher(address).matches()) {
            throw new IllegalArgumentException("IP형식은 0.0.0.0 입니다. (현재 값 %s)".formatted(address));
        }
    }
}
