
package GomokuGame.game;

import java.util.Objects;

public class GameType {

    public static GameType Human() {
        return new GameType("Human");
    }

    public static GameType Strategy() {
        return new GameType("Strategy");
    }
    private String type;

    private GameType(String type){
        this.type = type;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        GameType gameType = (GameType) obj;
        return type.equals(gameType.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}
