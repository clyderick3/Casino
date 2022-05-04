package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.games.TicTacToe.TicTacToeGame;
import com.github.zipcodewilmington.casino.games.TicTacToe.TicTacToePlayer;

public class TicTacToeEngine extends GameEngine<TicTacToePlayer, TicTacToeGame> {
    public TicTacToeEngine(TicTacToeGame game, TicTacToePlayer player){
        super(game, player);
    }

    @Override
    public void start() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        casinoAccountManager.loadAccounts("accountsList.db");
        System.out.println("Player 2 please login");
        while(getPlayers().size() != 2){
            getPlayers().add(new TicTacToePlayer(casinoAccountManager.accountLogin().getProfile()));
        }
        for (TicTacToePlayer s: getPlayers()){
            getGame().addPlayer(s);
        }
        getGame().play();
    }
}
