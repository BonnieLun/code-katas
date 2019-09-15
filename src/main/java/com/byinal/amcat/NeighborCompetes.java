package com.byinal.amcat;

import java.util.List;
import java.util.*;

//Eight houses represented as cells, are arranged in a straight line.
//- Each day every cell completed with its adjacent cells (neighbors).
//- An integer value of 1 represents an active cell and a value of 0 represents inactive cell.
//- If the neighbors on both the side of a cell are either active or inactive, the cell becomes inactive on the other day; otherwise cell becomes active.
//- The two cells on each end have a single adjacent cell, so assume that the occupied space on the opposite side is an inactive cell.
//- Even after updating cell state, consider it's previous state when updating the state of other cells.
//- The state info of all cells should be updates simultaneously.
//Write an algorithm to output state of the cells after the given number of days.

public class NeighborCompetes {

    private int firstUnoccupied, endUnoccupied = 0;

    public static void main(String[] args) {
        int[] initialStates = {1, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(new NeighborCompetes().cellCompete(initialStates, 1));
    }


    public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
        while(days > 0){
            states = updateCells(states);
            days--;
        }
        List<Integer> finalStatuses = new ArrayList<>();
        for(int i : states){
            finalStatuses.add(i);
        }

        return finalStatuses;
    }

    private int[] updateCells(int[] states){
        int[] updatedStates = new int[states.length];
        int before = firstUnoccupied;
        int after = states.length > 1 ? states[1] : endUnoccupied;
        for (int i = 0 ; i < states.length; i++){
            if(isShouldBeInactive(before,after)){
                updatedStates[i] = 0;
            }else {
                updatedStates[i] = 1;
            }
            before = states[i];
            int afterIndex = i+2;
            after = afterIndex < states.length ? states[afterIndex] : endUnoccupied;
        }
        return updatedStates;
    }

    private boolean isShouldBeInactive(int before, int after){
        if(before == after){
            return true;
        }else{
            return false;
        }
    }
}