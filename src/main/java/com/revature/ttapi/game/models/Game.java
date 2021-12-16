package com.revature.ttapi.game.models;

import com.revature.ttapi.collection.Deck;
import com.revature.ttapi.user.models.AppUser;

public class Game {

    private  AppUser player1;
    private  AppUser player2;
    private  Deck deck_p1;
    private  Deck deck_p2;
    private  String result;
    private  Board board;//winner or loser, set mgp


   public Game (AppUser p1, AppUser p2, Deck p1Deck, Deck p2Deck, Board gameBoard){
       player1 = p1;
       player2 = p2;
       deck_p1 = p1Deck;
       deck_p2 = p2Deck;
       board = gameBoard;

   }


    public AppUser getPlayer1() {
        return player1;
    }

    public void setPlayer1(AppUser player1) {
        this.player1 = player1;
    }

    public AppUser getPlayer2() {
        return player2;
    }

    public void setPlayer2(AppUser player2) {
        this.player2 = player2;
    }

    public Deck getDeck_p1() {
        return deck_p1;
    }

    public void setDeck_p1(Deck deck_p1) {
        this.deck_p1 = deck_p1;
    }

    public Deck getDeck_p2() {
        return deck_p2;
    }

    public void setDeck_p2(Deck deck_p2) {
        this.deck_p2 = deck_p2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


}
