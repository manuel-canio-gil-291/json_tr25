package es.mcg;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PartidosStatsBomb {
    private static final String ENCODE = "UTF-8";

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
        File file = null, file2 = null;
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        String fileContent;
        
        try
        {
            file = new File("43.json");
            fileContent = FileUtils.readFileToString(file, PartidosStatsBomb.ENCODE);
        }
        catch(Exception e)
        {

        }
    }
}
