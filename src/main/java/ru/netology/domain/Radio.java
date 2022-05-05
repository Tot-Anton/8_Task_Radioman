package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private int currentPosition;
    private int currentVolume;
    private int minStations;
    private int numberStations = 10;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio(int numberStations) {
        this.numberStations = numberStations;

    }


    public void setCurrentPosition(int currentPosition) {
        if (currentPosition < minStations) {
            return;
        }
        if (currentPosition > numberStations - 1) {
            return;
        }
        this.currentPosition = currentPosition;
    }

    public void nextRadioPosition() { // выбор радиостанций вперед
        if (currentPosition < numberStations - 1) {
            currentPosition++;
        } else {
            currentPosition = minStations;
        }

    }

    public void prevRadioPosition() {  // выбор радиостанций назад
        if (currentPosition > minStations) {
            currentPosition--;
        } else {
            currentPosition = numberStations - 1;
        }
    }

    public void setDesiredRadioStation(int desiredRadioStation) {  //желаемая радио-станция
        if (desiredRadioStation > numberStations) {
            currentPosition = numberStations - 1;
            return;
        }
        if (desiredRadioStation < minStations) {
            currentPosition = minStations;
            return;
        }
        this.currentPosition = desiredRadioStation;
    }

    public void setCurrentRadioStationNumber() {
        //Номер текущей радиостанции изменяется в пределах от 0 до количества радиостанций
        // не включительно (т.е. если станций 10, то номер последней - 9).
        if (currentPosition > minStations) {
            currentPosition = currentPosition - 1;
        } else {
            currentPosition = numberStations - 1;
        }
    }


    public void increasingVolume() {    // повышение громкости
        if (currentVolume < maxVolume) {
            currentVolume++;
        } else {
            currentVolume = maxVolume;
        }

    }

    public void loweringVolume() {  // понижение громкости
        if (currentVolume > minVolume) {
            currentVolume--;
        } else {
            currentVolume = minVolume;
        }
    }

}
