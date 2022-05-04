package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.games.TicTacToe.TicTacToePlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;

public class SlotsEngine extends GameEngine<SlotsPlayer, SlotsGame>{
    public SlotsEngine(SlotsGame game, SlotsPlayer player){super(game, player);}

    @Override
    public void start() {
        getGame().addPlayer(getPlayers().get(0));
        getGame().play();
    }
}
