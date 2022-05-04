package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.games.Person.Gambler;
import com.github.zipcodewilmington.casino.games.Person.Person;
import com.github.zipcodewilmington.casino.games.Person.Player;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends Player implements Gambler {
    public SlotsPlayer(Person person) {
        super(person);
    }

    @Override
    public void addWinning(int winning) {
        this.getPerson().setWallet(this.getBalance() + winning);
    }

    @Override
    public int getBalance() {
        return this.getPerson().getWallet();
    }

    @Override
    public void applyBet(int bet) {
        this.getPerson().setWallet(this.getBalance() - bet);

    }
}