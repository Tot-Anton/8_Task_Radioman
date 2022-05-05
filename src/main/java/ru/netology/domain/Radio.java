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
    private int numberOfStations = 10;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio(int numberOfStations) {
        this.numberOfStations = numberOfStations;

    }


    public void setCurrentPosition(int currentPosition) {
        if (currentPosition < minStations) {
            return;
        }
        if (currentPosition > numberOfStations) {
            return;
        }
        this.currentPosition = currentPosition;
    }

    public void nextRadioPosition() { // выбор радиостанций вперед
        if (currentPosition < numberOfStations) {
            currentPosition++;
        } else {
            currentPosition = minStations;
        }

    }

    public void prevRadioPosition() {  // выбор радиостанций назад
        if (currentPosition > minStations) {
            currentPosition--;
        } else {
            currentPosition = numberOfStations;
        }
    }

    public void setDesiredRadioStation(int desiredRadioStation) {  //желаемая радио-станция
        if (desiredRadioStation > numberOfStations) {
            currentPosition = numberOfStations;
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
            currentPosition = numberOfStations - 1;
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
