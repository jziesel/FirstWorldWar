package dataProviders;

import io.cucumber.messages.internal.com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final String searchForTopic = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Search.json";
    private List<Search> searchList;

    public JsonDataReader() {
        searchList = getSearchList();
    }

    public final Search getSearchByName(String searchTopicName){
        return searchList.stream().filter(x -> x.search.equalsIgnoreCase(searchTopicName)).findAny().get();
    }

    private List<Search> getSearchList() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(searchForTopic));
            Search[] customers = gson.fromJson(bufferReader, Search[].class);
            return Arrays.asList(customers);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + searchForTopic);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }
}
