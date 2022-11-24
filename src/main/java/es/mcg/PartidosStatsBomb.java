package es.mcg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PartidosStatsBomb {
    private static final String ENCODE = "UTF-8";
    private static final Logger LOGGER = LogManager.getLogger();

    public static class Json
    {
        private static ObjectMapper MAPPER;

        public static ObjectMapper mapper()
        {
            if(Json.MAPPER == null)
            {
                Json.MAPPER = Json.createJson();
            }

            return Json.MAPPER;
        }

        public static ObjectMapper createJson()
        {
            return new ObjectMapper();
        }
    }

    public static void main(String[] args) {
        File file = null;
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        String fileContent;
        
        try
        {
            file = new File("43.json");
            fileContent = FileUtils.readFileToString(file, PartidosStatsBomb.ENCODE);
            fileWriter = new FileWriter(new File("partidos.txt"));
            printWriter = new PrintWriter(fileWriter);
        }
        catch(IOException IOException)
        {

        }
    }
}
