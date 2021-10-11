package com.shabloel.recipeapp.services;

import com.shabloel.recipeapp.model.User;
import com.shabloel.recipeapp.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author : christiaan.griffioen
 * @since :  28-6-2021, ma
 **/

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    UserServiceImpl userService;

    ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void save() {
        //given
        User peppa = new User("Peppa", "Pig", "pig@yahoo.com");
        //when
        userService.save(peppa);
        //verify
        verify(userRepository, times(1)).save(userArgumentCaptor.capture());
        User capturedPeppa = userArgumentCaptor.getValue();
        assertThat(capturedPeppa).isEqualTo(peppa);
    }
}