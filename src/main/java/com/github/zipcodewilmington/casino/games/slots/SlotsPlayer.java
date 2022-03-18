package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.games.Person.Gambler;
import com.github.zipcodewilmington.casino.games.Person.Person;
import com.github.zipcodewilmington.casino.games.Person.Player;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends Player implements Gambler {
    public SlotsPlayer(Person person) {
        super(person); //person currently labeled as private. Get emmm.
    }

    @Override
    public void addWinning(int winning) {

    }

    @Override
    public void applyBet(int bet) {

    }

    @Override
    public int getBalance() {
        return 0;
    }
}