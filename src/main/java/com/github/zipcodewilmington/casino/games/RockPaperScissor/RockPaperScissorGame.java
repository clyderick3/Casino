package com.github.zipcodewilmington.casino.games.RockPaperScissor;

import com.github.zipcodewilmington.casino.games.GameInterface.Games;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RockPaperScissorGame implements Games<RockPaperScissorPlayer> {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    public RockPaperScissorGame(){}
    private List<RockPaperScissorPlayer> order = new ArrayList<>();
    private boolean exitFlag = false;

    @Override
    public void play() {
        while (!exitFlag){
            shuffle();
            String player1move = getMove(order.get(0));
            String player2move = getMove(order.get(1));
            RockPaperScissorPlayer winner = getWinner(player1move, player2move);
            if (winner!=null)
                System.out.println("Winner is: " + winner.getPerson().getName());
            else
                System.out.println("Draw");
            exit();
        }
    }

    private RockPaperScissorPlayer getWinner(String player1move, String player2move) {
        if (player1move.equalsIgnoreCase("paper")){
            if (player2move.equalsIgnoreCase("rock")){
                return order.get(0);
            } else if (player2move.equalsIgnoreCase("paper")){
                return null;
            }else if (player2move.equalsIgnoreCase("scissor"))
                return order.get(1);
        } else if (player1move.equalsIgnoreCase("rock")){
            if (player2move.equalsIgnoreCase("rock")){
                return null;
            } else if (player2move.equalsIgnoreCase("paper")){
                return order.get(1);
            }else if (player2move.equalsIgnoreCase("scissor"))
                return order.get(0);
        } else if (player1move.equalsIgnoreCase("scissor")){
            if (player2move.equalsIgnoreCase("rock")){
                return order.get(1);
            } else if (player2move.equalsIgnoreCase("paper")){
                return order.get(0);
            }else if (player2move.equalsIgnoreCase("scissor"))
                return null;
        }
        return null;
    }

    public void shuffle(){
        Collections.shuffle(order);
    }

    public String getMove(RockPaperScissorPlayer player){
        for (int i =0 ; i<50; i++)
            System.out.println("");
        String move;
        move= console.getStringInput(player.getPerson().getName()+
                ", what is your move?");
        while (!move.equalsIgnoreCase("rock") &&
                !move.equalsIgnoreCase("paper") &&
                !move.equalsIgnoreCase("scissor")){
            move= console.getStringInput(player.getPerson().getName()+
                    ", what is your move?");
        }
        return move;
    }

    @Override
    public void addPlayer(RockPaperScissorPlayer player) {
        order.add(player);
    }

    @Override
    public void winConditionCheck(RockPaperScissorPlayer player) {
    }

    @Override
    public void exit() {
        String input = console.getStringInput("Do you want to exit the game?");
        if (input.equalsIgnoreCase("Yes"))
            this.exitFlag=true;
    }

    @Override
    public void setPlayerMax() {}
    @Override
    public void removePlayer(RockPaperScissorPlayer player) {}
}
