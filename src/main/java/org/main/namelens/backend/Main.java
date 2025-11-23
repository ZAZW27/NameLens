package org.main.namelens.backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap rbTree = new HashMap();

        Map<String, String> dataS = new LinkedHashMap<>();
        dataS.put("type", "definition");
        dataS.put("text", "S is for Super");
        rbTree.add('S', dataS);

        Map<String, String> dataE = new LinkedHashMap<>();
        dataE.put("type", "definition");
        dataE.put("text", "E is for Elephant");
        rbTree.add('E', dataE);

        Map<String, String> appData = new LinkedHashMap<>();
        appData.put("type", "app");
        appData.put("name", "flip_coin_gui");
        rbTree.add('F', appData);

        Map<String, String> animData = new LinkedHashMap<>();
        animData.put("type", "animation");
        animData.put("name", "naruto_run");
        rbTree.add('N', animData);

//        rbTree.remove('E');

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("tree_structure.json")) {
            gson.toJson(rbTree.getRoot(), writer);
            System.out.println("Successfully wrote tree to tree_structure.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}