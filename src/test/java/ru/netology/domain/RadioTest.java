package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radioman = new Radio(10);

    @Test
        //радиостанции > max
    void radioOverMax() {
        radioman.setCurrentPosition(10);
        radioman.nextRadioPosition();
        int expected = 0;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        //радиостанции < 0
    void radioLessThanZero() {
        radioman.setCurrentPosition(0);
        radioman.prevRadioPosition();
        int expected = 10;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        //радиостанция > 0
    void radioOverZero() {
        radioman.setCurrentPosition(0);
        radioman.nextRadioPosition();
        int expected = 1;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        //радиостанция < max
    void getCurrentVolume() {
        radioman.setCurrentPosition(10);
        radioman.prevRadioPosition();
        int expected = 9;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        // номер радиостанции от нуля до максимума
    void radioStationNumberFromZeroToMax() {
        radioman.setDesiredRadioStation(7);
        int expected = 7;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        // номер радиостанции не может быть более max
    void radioStationCannotBeMoreThanMax() {
        radioman.setDesiredRadioStation(11);
        int expected = 10;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        // номер радиостанции не может быть < 0
    void radioStationCannotBeLessThanZero() {
        radioman.setDesiredRadioStation(-1);
        int expected = 0;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        //громкость не должна стать > max и переключится на 0
    void volumeOverMax() {
        radioman.setCurrentVolume(100);
        radioman.increasingVolume();
        int expected = 100;
        assertEquals(expected, radioman.getCurrentVolume());
    }

    @Test
        //громкость не должна стать < 0 и переключится на max
    void volumeLessThanZero() {
        radioman.setCurrentVolume(0);
        radioman.loweringVolume();
        int expected = 0;
        assertEquals(expected, radioman.getCurrentVolume());
    }

    @Test
        //переключение громкости на 1 вниз
    void volumeIsLower() {
        radioman.setCurrentVolume(10);
        radioman.loweringVolume();
        int expected = 9;
        assertEquals(expected, radioman.getCurrentVolume());
    }

    @Test
        //переключение громкости на 1 вверх
    void volumeUp() {
        radioman.setCurrentVolume(2);
        radioman.increasingVolume();
        int expected = 3;
        assertEquals(expected, radioman.getCurrentVolume());
    }

}