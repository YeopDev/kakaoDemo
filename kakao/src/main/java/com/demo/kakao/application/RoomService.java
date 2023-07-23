package com.demo.kakao.application;

import com.demo.kakao.domain.Room;
import com.demo.kakao.repository.room.RoomRepository;
import com.demo.kakao.domain.User;
import com.demo.kakao.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public Long create(UUID userId, String name) {
        User author = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저는 존재하지 않습니다."));

        Room room = roomRepository.save(new Room(name, author));
        return room.id();
    }

    @Transactional
    public Long update(Long roomId, String roomName){
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("해당 방은 존재하지 않습니다."));
        room.setRoomName(roomName);
        return room.id();
    }

    @Transactional
    public void delete(Long roomId){
        roomRepository.deleteById(roomId);
    }
}
