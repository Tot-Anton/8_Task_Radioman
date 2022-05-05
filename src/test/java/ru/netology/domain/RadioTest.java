package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
        //Номер текущей радиостанции изменяется в пределах от 0 до количества радиостанций
        // не включительно (т.е. если станций 10, то номер последней - 9).
    void getNumberPosition() {
        Radio radioman = new Radio();
        radioman.setCurrentPosition(9);
        radioman.setCurrentRadioStationNumber();
        int expected = 8;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        //радиостанции > max
    void radioOverMax() {
        Radio radioman = new Radio();
        radioman.setCurrentPosition(10);
        radioman.nextRadioPosition();
        int expected = 1;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        //радиостанции < 0
    void radioLessThanZero() {
        Radio radioman = new Radio();
        radioman.setCurrentPosition(0);
        radioman.prevRadioPosition();
        int expected = 9;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        //радиостанция > 0
    void radioOverZero() {
        Radio radioman = new Radio();
        radioman.setCurrentPosition(0);
        radioman.nextRadioPosition();
        int expected = 1;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        //радиостанция < max
    void getCurrentVolume() {
        Radio radioman = new Radio();
        radioman.setCurrentPosition(8);
        radioman.prevRadioPosition();
        int expected = 7;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        // номер радиостанции от нуля до максимума
    void radioStationNumberFromZeroToMax() {
        Radio radioman = new Radio();
        radioman.setDesiredRadioStation(7);
        int expected = 7;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        // номер радиостанции не может быть более max
    void radioStationCannotBeMoreThanMax() {
        Radio radioman = new Radio();
        radioman.setDesiredRadioStation(11);
        int expected = 9;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        // номер радиостанции не может быть < 0
    void radioStationCannotBeLessThanZero() {
        Radio radioman = new Radio();
        radioman.setDesiredRadioStation(-1);
        int expected = 0;
        assertEquals(expected, radioman.getCurrentPosition());
    }

    @Test
        //громкость не должна стать > max и переключится на 0
    void volumeOverMax() {
        Radio radioman = new Radio();
        radioman.setCurrentVolume(100);
        radioman.increasingVolume();
        int expected = 100;
        assertEquals(expected, radioman.getCurrentVolume());
    }

    @Test
        //громкость не должна стать < 0 и переключится на max
    void volumeLessThanZero() {
        Radio radioman = new Radio();
        radioman.setCurrentVolume(0);
        radioman.loweringVolume();
        int expected = 0;
        assertEquals(expected, radioman.getCurrentVolume());
    }

    @Test
        //переключение громкости на 1 вниз
    void volumeIsLower() {
        Radio radioman = new Radio();
        radioman.setCurrentVolume(10);
        radioman.loweringVolume();
        int expected = 9;
        assertEquals(expected, radioman.getCurrentVolume());
    }

    @Test
        //переключение громкости на 1 вверх
    void volumeUp() {
        Radio radioman = new Radio();
        radioman.setCurrentVolume(2);
        radioman.increasingVolume();
        int expected = 3;
        assertEquals(expected, radioman.getCurrentVolume());
    }

}