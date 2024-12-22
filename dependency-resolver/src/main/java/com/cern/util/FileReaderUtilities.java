package com.cern.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FileReaderUtilities {

    public static Map<String, List<String>> readFile(String fileName) throws IOException {
        ClassLoader classLoader = FileReaderUtilities.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if(resource==null) throw new FileNotFoundException();
        return new ObjectMapper().readValue(new File(resource.getFile()), Map.class);
    }
}
