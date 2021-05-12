package coingame.state;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;


public class GameState {

    int starters[] = {1, 5, 6, 4, 8, 6, 4, 3, 1, 2, 2, 8};


    public void setCoinRow(int x) {
        this.coinRow = coinRow;
        coinRow.add(x);
    }

    ArrayList<Integer> coinRow = new ArrayList<Integer>();

    public ArrayList<Integer> getCoinRow() {
        return coinRow;
    }

    public GameState(){
    }

    public void firstChoice(int index) {
        for(int i = index; i < starters.length; i++){
            coinRow.add(starters[i]);
        }
        for (int j = 0; j < index-1; j++){
            coinRow.add(starters[j]);
        }

    }


    @Override
    public String toString() {
        return "GameState{" +
                "coinRow=" + coinRow +
                '}';
    }
}
