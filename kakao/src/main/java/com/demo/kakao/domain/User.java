package com.demo.kakao.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Entity(name = "users")
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Embedded
    @AttributeOverride(name = "content", column = @Column(name = "ip_address"))
    private IpAddress ipAddress;
}
