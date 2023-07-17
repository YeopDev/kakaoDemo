package com.demo.kakao.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Entity
@AllArgsConstructor
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomUser {
    @Id
    @Generated
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
    @OneToOne(fetch = FetchType.EAGER)
    private User users;
}
