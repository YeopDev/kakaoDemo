package com.demo.kakao.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@AllArgsConstructor
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {
    @Id
    @Generated
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST)
    private List<RoomUser> users = new ArrayList<>();
    @CreatedDate
    private LocalDateTime createdAt;

    public Room(String name, User author) {
        this.name = name;
        this.author = author;
    }

    public void setRoomName(String name) {
        this.name = name;
    }
}
