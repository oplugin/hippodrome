package com.javarush.plugin;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HippodromeTest {

//    List<Horse> horseList = new ArrayList<>();
//    Hippodrome hippodrome = new Hippodrome(horseList);

    @Test
    void passNullAsParameter_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Hippodrome hippodrome = new Hippodrome(null);
        });
    }


    @Test
    void passNullAsParameter_ReceiveMessage() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Hippodrome hippodrome = new Hippodrome(null);
                }
        );
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void passEmptyListAsParameter_ThrowIllegalArgumentException() {
        List<Horse> horseList = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            Hippodrome hippodrome = new Hippodrome(horseList);
        });
    }

    @Test
    void passEmptyListAsParameter_ReceiveMessage() {
        List<Horse> horseList = new ArrayList<>();
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Hippodrome hippodrome = new Hippodrome(horseList);
                }
        );
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void givenListHorses_whenPassListAsParameter_ReceiveListAsWasPassed() {
        List<Horse> horseList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String name = "Horse : " + i;
            horseList.add(new Horse(name, Math.random() * 10));
        }
        Hippodrome hippodrome = new Hippodrome(horseList);
        assertEquals(horseList, hippodrome.getHorses());
    }

    @Mock
    Hippodrome hippodrome;
    List<Horse> horses;


    @Test
    void givenListHorses_whenPassListAsParameter_VerifyMove() {

        List<Horse> horseList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            String name = "Horse : " + i;
            horseList.add(new Horse(name, Math.random() * 10));
            hippodrome.move();
        }

        Mockito.verify(hippodrome, Mockito.times(50)).move();
    }

    @Test
    void shouldReturnWinner_When_GetWinner() {

        //given
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Буцефал", 2.4, 3.0));
        horseList.add(new Horse("Туз Пик", 2.5, 3.4));
        horseList.add(new Horse("Зефир", 2.6,4.0));
        horseList.add(new Horse("Пожар", 2.7,2.0));
        horseList.add(new Horse("Лобстер", 2.8,1.7));

        //when
        Hippodrome hippodrome = new Hippodrome(horseList);
        Horse winnerHorse = hippodrome.getWinner();

        //then
        assertEquals("Зефир", winnerHorse.getName());
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void shouldReturnWinner_When_GetWinnerWithRepeat() {

        //given
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Буцефал", 2.4));
        horseList.add(new Horse("Туз Пик", 2.5));
        horseList.add(new Horse("Зефир", 2.6));
        horseList.add(new Horse("Пожар", 2.7));
        horseList.add(new Horse("Лобстер", 2.8));

        //when
        Hippodrome hippodrome = new Hippodrome(horseList);
        for (Horse horse : horseList) {
            hippodrome.move();
        }

        Horse winnerHorse = hippodrome.getWinner();

        //then
        assertEquals("Зефир", winnerHorse.getName());
    }

}
