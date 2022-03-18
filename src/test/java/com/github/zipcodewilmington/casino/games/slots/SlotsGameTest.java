package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.games.Person.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlotsGameTest {

    @Test
    void main() {
    }

    @Test
    void setBets() {
    }

    @Test
    void distributeWinningsToWinners() {
    }

    @Test
    void play() {
    }

    @Test
    void setPlayerMax() {
    }

    @Test
    void addPlayer() {
        SlotsPlayer player = new SlotsPlayer(new Person("Mike", 1));
        SlotsGame game = new SlotsGame();
        game.addPlayer(player);
        SlotsPlayer actual = game.getPlayer();
        Assert.assertEquals(actual, player);

    }

    @Test
    void removePlayer() {
    }

    @Test
    void setWinCondition() {
    }

    @Test
    void getWinner() {
    }

    @Test
    void exit() {
    }
}