package com.javarush.plugin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void should_RunTheApp_When_HorseListHas10000Elements() {

        //given
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            horses.add(new Horse("Horse #" + i, 1.0 + i));
        }

        //when
        Hippodrome hippodrome = new Hippodrome(horses);
//        Executable executable = () ->
//
//        //then
//        assertTimeout(Duration.ofSeconds(24), executable);

    }

}
