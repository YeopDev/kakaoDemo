package com.demo.kakao.application;

import com.demo.kakao.domain.RoomRepository;
import com.demo.kakao.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {
    @Mock
    UserRepository userRepository;
    @Mock
    RoomRepository roomRepository;
    @InjectMocks
    RoomService roomService;

    @Test
    void no_가입() {
        UUID userId = UUID.randomUUID();

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> roomService.create(userId, "안녕하세요"))
                .hasMessage("해당 유저는 존재하지 않습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 방_이름_변경(){
        Long roomId = 1L;
        String roomName = "안녕1";

        when(roomRepository.findById(roomId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> roomService.update(roomId,roomName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 방은 존재하지 않습니다.");
    }

    @Test
    void 방_삭제(){
        Long roomId = 1L;

        when(roomRepository.findById(roomId)).thenReturn(Optional.empty());

        assertThatCode(() -> roomService.delete(roomId)).doesNotThrowAnyException();
    }
}