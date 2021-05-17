package coingame.results;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * Contains the {@code serialize()} method.
 */
public class GameResultSerializer {

    /**
     * Writes in file the passed {@link GameResult} object.
     * @param gameResult {@link GameResult} object.
     */
    public static void serialize(GameResult gameResult) {

        List<GameResult> gameResultList = GameResultDeserializer.deserialize();
        try {
            File file = new File("./coindata.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            SequenceWriter sequenceWriter = mapper.writer().writeValuesAsArray(fileWriter);
            for(GameResult gameResult1: gameResultList){
                sequenceWriter.write(gameResult1);
            }
            sequenceWriter.write(gameResult);
            sequenceWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
