package com.revature.ttapi.game.models;

import com.revature.ttapi.card.models.Card;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Objects;

@Component
public class Board {

    private ArrayList<Node> positions;

    public Board(){
        //Instantiate List
        positions = new ArrayList<Node>(9);

        //Add Blank Nodes
        for (int i = 0; i < 9; i++) {
            positions.add(i, new Node());
        }

        //Connect Board relevant position relationships.
        setBoardRelations(positions);

    }

    //Relationship Function setup. Should be called once when a board is instantiated and only once.
    private void setBoardRelations(ArrayList<Node> positions){
        //Node 0 Setup
        positions.get(0).setEast_Node(positions.get(1));
        positions.get(0).setSouth_Node(positions.get(3));
        //Node 1
        positions.get(1).setEast_Node(positions.get(2));
        positions.get(1).setSouth_Node(positions.get(4));
        positions.get(1).setWest_Node(positions.get(0));
        //Node 2
        positions.get(2).setSouth_Node(positions.get(5));
        positions.get(2).setWest_Node(positions.get(1));
        //Node 3
        positions.get(3).setEast_Node(positions.get(4));
        positions.get(3).setSouth_Node(positions.get(6));
        positions.get(3).setNorth_Node(positions.get(0));
        //Node 4
        positions.get(4).setEast_Node(positions.get(5));
        positions.get(4).setSouth_Node(positions.get(7));
        positions.get(4).setWest_Node(positions.get(3));
        positions.get(4).setNorth_Node(positions.get(1));
        //Node 5
        positions.get(5).setWest_Node(positions.get(4));
        positions.get(5).setSouth_Node(positions.get(8));
        positions.get(5).setNorth_Node(positions.get(2));
        //Node 6
        positions.get(6).setEast_Node(positions.get(7));
        positions.get(6).setNorth_Node(positions.get(3));
        //Node 7
        positions.get(7).setEast_Node(positions.get(8));
        positions.get(7).setNorth_Node(positions.get(4));
        positions.get(7).setWest_Node(positions.get(6));
        //Node 8
        positions.get(8).setNorth_Node(positions.get(5));
        positions.get(8).setWest_Node(positions.get(7));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return positions.equals(board.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }

    @Override
    public String toString() {
        return "Board{" +
                "positions=" + positions +
                '}';
    }

    //Customer node that stores a card played, and relevant position functions for comparing plays made. Only 9 of these nodes should ever be made in 1 game
    //and that makes us able to use index based usage functions of the containing ArrayList.
    private static class Node {
        public Card getPlayedCard() {
            return playedCard;
        }

        public void setPlayedCard(Card playedCard) {
            this.playedCard = playedCard;
        }

        public Node getNorth_Node() {
            return north_Node;
        }

        public void setNorth_Node(Node north_Node) {
            this.north_Node = north_Node;
        }

        public Node getEast_Node() {
            return east_Node;
        }

        public void setEast_Node(Node east_Node) {
            this.east_Node = east_Node;
        }

        public Node getSouth_Node() {
            return south_Node;
        }

        public void setSouth_Node(Node south_Node) {
            this.south_Node = south_Node;
        }

        public Node getWest_Node() {
            return west_Node;
        }

        public void setWest_Node(Node west_Node) {
            this.west_Node = west_Node;
        }

        public int getSlotController() {
            return slotController;
        }


        public void setSlotController(int slotController) {
            this.slotController = slotController;
        }

        //Called to determine result of a play //TODO Maybe find a way to store and compare without long .chains
        public void compareRelations(Node playedPosition){
            //Compare to north card
            if (playedPosition.north_Node != null && (playedPosition.getPlayedCard().getStats().getTop() > playedPosition.getNorth_Node().getPlayedCard().getStats().getBottom())){
                //Change ownership if card to north
                playedPosition.getNorth_Node().setSlotController(playedPosition.getSlotController());
            }
            //Compare to east card
            if (playedPosition.east_Node != null && (playedPosition.getPlayedCard().getStats().getRight() > playedPosition.getEast_Node().getPlayedCard().getStats().getLeft())){
                //Change ownership if card to east
                playedPosition.getEast_Node().setSlotController(playedPosition.getSlotController());
            }
            //Compare to south card
            if (playedPosition.south_Node != null && (playedPosition.getPlayedCard().getStats().getBottom() > playedPosition.getSouth_Node().getPlayedCard().getStats().getTop())){
                //Change ownership if card to south
                playedPosition.getSouth_Node().setSlotController(playedPosition.getSlotController());
            }
            //Compare to west card
            if (playedPosition.west_Node != null && (playedPosition.getPlayedCard().getStats().getLeft() > playedPosition.getWest_Node().getPlayedCard().getStats().getRight())){
                //Change ownership if card to south
                playedPosition.getWest_Node().setSlotController(playedPosition.getSlotController());
            }


        }

        Card playedCard;
        Node north_Node;
        Node east_Node;
        Node south_Node;
        Node west_Node;
        int slotController;

        @Override
        public String toString() {
            String cardResult = "";
            if (playedCard == null) {
                cardResult = null;
            } else {
                cardResult = String.valueOf(playedCard.getId());
            }

            return "Node{" +
                    "playedCard=" + cardResult +
                    ", slotController=" + slotController +
                    '}';
        }
    }

    /*
     *   If no index based access, make array of nodes that fakes our indexes
     *  Array 0, 1, 2, 3, 4, 5, 6, 7, 8,
     *
     * 4 directions
     * Is card present
     * ownership of field
     *
     *  0 | 1 | 2
     * ------------
     *  3 | 4 | 5
     *  -----------
     *  6 | 7 | 8
     *
     * Handle Play with a Switch
     * case 4:
     *   compare function target 1
     *   compare function target 3
     *   compare function target 5
     *   compare function target 7
     *   update array position 4 to taken on board
     *
     *
     *
     *
     *
     * */

}
