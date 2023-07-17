package com.demo.kakao.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IpAddressTest {

    @ParameterizedTest
    @ValueSource(strings = {"192.0.0.1"})
    void IP_형식이_정상(String address) {
        assertThatCode(() -> new IpAddress(address))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"192.0.0.0.1"})
    void IP_형식이_비정상(String address) {
        assertThatThrownBy(
                () -> new IpAddress(address)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("IP형식은 0.0.0.0 입니다. (현재 값 %s)".formatted(address));
    }
}