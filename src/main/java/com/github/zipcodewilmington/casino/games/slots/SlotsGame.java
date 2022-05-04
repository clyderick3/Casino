package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GamblingGame<SlotsPlayer> {


    private static Random random = new Random();
    private static int column1;
    private static int column2;
    private static int column3;

    private static int balance = 100; //make it so every bet wages 25.

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private static String[] winners = {"Black Panther", "Iron Man", "Captain America","The Hulk","Thor","Spider-man","Thanos"};
    private static Integer[] payout = {500, 200, 100, 50, 150, 150, 0}; //Casino payout is like Monopoly payout.
    private static SlotsPlayer slotsPlayer ;

    private boolean exitFlag = false;

// Add bets after Are you feeling lucky. Add play again option.

    public static void spinReels(){
        column1 = random.nextInt(winners.length-1);
        column2 = random.nextInt(winners.length-1);
        column3 = random.nextInt(winners.length-1);
    }


    public void play(){
        while(!exitFlag) {
            System.out.println(getWelcomeMessage());
            //while isPlaying. --------
            slotsPlayer.applyBet(1);
            spinReels();
            System.out.println(getSlotResultsMessage());
            analyzeResults();
            exit();
        }
        //end while isPlaying.
    }

    @Override
    public void setPlayerMax() {

    }

    @Override
    public void addPlayer(SlotsPlayer player) {
        slotsPlayer = player;
    }

    @Override
    public void removePlayer(SlotsPlayer player) {

    }

    @Override
    public void winConditionCheck(SlotsPlayer player) {

    }

    @Override
    public void exit() {
            String input = console.getStringInput("Do you want to exit the game?");
            if (input.equalsIgnoreCase("Yes"))
                this.exitFlag=true;

        }


    public static void analyzeResults(){
        boolean isMatched = column1 == column2 && column1 == column3;
        if (isMatched){
            System.out.println(getWinningMessage());
            slotsPlayer.addWinning(determinePayout());
        }
        else{
            System.out.println(getLosingMessage());
        }
    }

    public static Integer determinePayout(){
        return payout[column1];
    }

    public static String getWelcomeMessage() {
        return "Welcome to the Slots game!\nAre you feeling lucky?";
    }

    public static String getWinningMessage() {
        return "You got all " + winners[column1] + ".\n" +
                "Also your payout is: $" + determinePayout() + ".";
    }

    public static String getLosingMessage() {
        return "Guess you weren't as lucky as you thought.\nOr are you? Try again?";
    }

    public static String getSlotResultsMessage(){
        return "| " + winners[column1] + " | " + winners[column2] + " | " + winners[column3] + " |";
    }

    public static Random getRandom() {
        return random;
    }

    public static int getColumn1() {
        return column1;
    }

    public static int getColumn2() {
        return column2;
    }

    public static int getColumn3() {
        return column3;
    }

    public static String[] getWinners() {
        return winners;
    }

    @Override
    public void setBets() {

    }

    @Override
    public void distributeWinningsToWinners(SlotsPlayer winner) {

    }


//    //Variables
//    SlotsPlayer player;
//    private int maxPartySize;
//
//
//
//    private int betAmount;
//    private boolean playing;
//
//
//    public static void spinSlots() {
////        Random random = new Random();
////        int column1;
////        int column2;
////        int column3;
////
////        column1 = random.nextInt(10);
////        column2 = random.nextInt(10);
////        column3 = random.nextInt(10);
////
////        System.out.println("|"+column1+"|"+column2+"|"+column3+"|");
////
////        if (column1 == 7 && column2 == 7 && column3 ==7 ) {
////            System.out.println("You just won the jackpot!");
////        }
////        else {
////            System.out.println("Try again :)");
////        }
////
////    }
////
////    public boolean isPlaying() {
////        return playing;
////    }
////
////    public void setPlaying(boolean playing) {
////        this.playing = playing;
////    }
////
////    public String getBetMessage() {
////        return  "Please set your bets.";
////    }
////
////    @Override
////    public void setBets() {
////        System.out.println(getBetMessage());
////        this.getBetInput();
////    }
////
////    public int getBetAmount() {
////        return betAmount;
////    }
////
////    public void getBetInput() {
////        Scanner scanner = new Scanner (System.in);
////        this.betAmount = scanner.nextInt();
////    }
////
////    public void setBetAmount(int betAmount) {
////        this.betAmount = betAmount;
////    }
////
////    @Override
////    public void distributeWinningsToWinners(SlotsPlayer winner) {
////
////    }
////
////    public void distributeWinningsToWinners() {
////
////    }
////
////    @Override
////    public void play() {
////        //overall method that contains the game loop, when it starts it should initiate the game.
////        this.playing = true;
////        while (this.playing) {
////            this.setBets();
////            this.spinSlots();
////        }
////    }
////
////    public int getPlayerMax() {
////        return this.maxPartySize;
////    }
////
////    @Override
////    public void setPlayerMax() {
////    this.maxPartySize = 1;
////    }
////
////    @Override
////    public void addPlayer(SlotsPlayer player) {
////        this.player = player;
////
////
////    }
////
////    @Override
////    public void removePlayer(SlotsPlayer player) {
////
////
////    }
////
////    @Override
////    public void winConditionCheck(SlotsPlayer player) {
////
////    }
////
////    public void setWinCondition() {
////
////    }
////
////    @Override
////    public void exit() {
////
////    }
////
////    public SlotsPlayer getPlayer(){
////        return this.player;
////    }
////
////    public String continuePlayingMessage() {
////        return "Do you want to continue playing? Y/N";
////    }
////
////    public void checkContinuePlaying(){
////        Scanner continuePlaying = new Scanner (System.in);
////        System.out.println(continuePlayingMessage());
////        String result = continuePlaying.nextLine();
////
////            if (result == "Y"){
////                 this.playing = true;
////            }
////            else {
////                this.playing = false;
////            }
////    }

}
