package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GamblingGame<SlotsPlayer> {
    //Variables
    SlotsPlayer player;
    private int maxPartySize;



    private int betAmount;
    private boolean playing;


    public static void spinSlots() {
        Random random = new Random();
        int column1;
        int column2;
        int column3;

        column1 = random.nextInt(10);
        column2 = random.nextInt(10);
        column3 = random.nextInt(10);

        System.out.println("|"+column1+"|"+column2+"|"+column3+"|");

        if (column1 == 7 && column2 == 7 && column3 ==7 ) {
            System.out.println("You just won the jackpot!");
        }
        else {
            System.out.println("Try again :)");
        }

    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public String getBetMessage() {
        return  "Please set your bets.";
    }

    @Override
    public void setBets() {
        System.out.println(getBetMessage());
        this.getBetInput();
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void getBetInput() {
        Scanner scanner = new Scanner (System.in);
        this.betAmount = scanner.nextInt();
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    @Override
    public void distributeWinningsToWinners(SlotsPlayer winner) {

    }

    public void distributeWinningsToWinners() {

    }

    @Override
    public void play() {
        //overall method that contains the game loop, when it starts it should initiate the game.
        this.playing = true;
        while (this.playing) {
            this.setBets();
            this.spinSlots();
        }
    }

    public int getPlayerMax() {
        return this.maxPartySize;
    }

    @Override
    public void setPlayerMax() {
    this.maxPartySize = 1;
    }

    @Override
    public void addPlayer(SlotsPlayer player) {
        this.player = player;


    }

    @Override
    public void removePlayer(SlotsPlayer player) {


    }

    @Override
    public void winConditionCheck(SlotsPlayer player) {

    }

    public void setWinCondition() {

    }

    @Override
    public SlotsPlayer[] getWinner() {
        return new SlotsPlayer[0];
    }

    @Override
    public void exit() {

    }

    public SlotsPlayer getPlayer(){
        return this.player;
    }

    public String continuePlayingMessage() {
        return "Do you want to continue playing? Y/N";
    }

    public void checkContinuePlaying(){
        Scanner continuePlaying = new Scanner (System.in);
        System.out.println(continuePlayingMessage());
        String result = continuePlaying.nextLine();

            if (result == "Y"){
                 this.playing = true;
            }
            else {
                this.playing = false;
            }
    }

}
