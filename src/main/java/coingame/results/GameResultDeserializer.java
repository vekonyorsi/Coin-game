package coingame.results;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contains the {@code deserialize()} method.
 */
public class GameResultDeserializer {

    /**
     * Reads the {@link GameResult} objects from file.
     * @return a list of {@link GameResult} objects.
     */
    public static List<GameResult> deserialize(){
        List<GameResult> gameResultList = new ArrayList<>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file = new File("./coindata.json");
            if(!file.exists()) {
                file.createNewFile();
                return List.of();
            }

            gameResultList = mapper.readValue(
                    file, new TypeReference<List<GameResult>>() { });

        }catch(IOException e){
            e.printStackTrace();
        }
        return gameResultList.stream().sorted(Comparator.comparing(GameResult::getDate).reversed()).collect(Collectors.toList());
    }
}
