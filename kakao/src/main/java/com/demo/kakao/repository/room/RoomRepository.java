package com.demo.kakao.repository.room;

import com.demo.kakao.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
