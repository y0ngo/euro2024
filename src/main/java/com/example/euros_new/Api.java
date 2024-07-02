package com.example.euros_new;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;


public class Api {
    private String name;
    private int goals;
    private int assists;
    private int appearances;
    private int firstTeamAppearances;
    private int minutesPlayed;
    private String teamName;

    public Api(String name, int goals, int assists, int appearances, int firstTeamAppearances, int minutesPlayed, String teamName) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.appearances = appearances;
        this.firstTeamAppearances = firstTeamAppearances;
        this.minutesPlayed = minutesPlayed;
        this.teamName = teamName;
    }

    public String getName() { return name; }
    public int getGoals() { return goals; }
    public int getAssists() { return assists; }
    public int getAppearances() { return appearances; }
    public int getFirstTeamAppearances() { return firstTeamAppearances; }
    public int getMinutesPlayed() { return minutesPlayed; }
    public String getTeamName() { return teamName; }

    public static List<Api> topScorer() throws Exception {
        String host = "https://euro-20242.p.rapidapi.com/players/topScorers";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "403817c476msh6b73b2840b3100bp1f3dfcjsn08d31a968d78";

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        JsonArray jsonArray = JsonParser.parseString(response.getBody().toString()).getAsJsonArray();
        List<Api> topScorers = new ArrayList<>();

        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            Api scorer = new Api(
                    jsonObject.get("name").getAsString(),
                    jsonObject.get("goals").getAsInt(),
                    jsonObject.get("assists").getAsInt(),
                    jsonObject.get("appearances").getAsInt(),
                    jsonObject.get("firstTeamAppearances").getAsInt(),
                    jsonObject.get("minutesPlayed").getAsInt(),
                    jsonObject.get("teamName").getAsString()
            );
            topScorers.add(scorer);
        }

        return topScorers;
    }

    public static void topAssister() throws UnsupportedEncodingException {
        String host = "https://euro-20242.p.rapidapi.com/players/topAssisters";
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "403817c476msh6b73b2840b3100bp1f3dfcjsn08d31a968d78";

        String s = "Pulp";
        // Format query for preventing encoding problems
        String query = String.format("s=%s", URLEncoder.encode(s, charset));
        HttpResponse<JsonNode> response = Unirest.get(host + "?" + query)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));
        String i = "tt0110912";
        // Format query for preventing encoding problems
        query = String.format("i=%s",
                URLEncoder.encode(i, charset));
        // Json response

        //Prettifying
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);


    }
    public static void displayPlayer(String playerID ) throws UnsupportedEncodingException {
        String host = "https://euro-20242.p.rapidapi.com/players/" + URLEncoder.encode(playerID, "UTF-8") ;
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "403817c476msh6b73b2840b3100bp1f3dfcjsn08d31a968d78";

        // Format query for preventing encoding problems

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));

        // Json response

        //Prettifying
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);

    }
    public static void displayTeamMatches(String teamID) throws UnsupportedEncodingException {
        String teamId = null;
        String host = "https://euro-20242.p.rapidapi.com/teams/" + URLEncoder.encode(teamID, "UTF-8") + "/matches";
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "403817c476msh6b73b2840b3100bp1f3dfcjsn08d31a968d78";

        String s = "Pulp";
        // Format query for preventing encoding problems

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));

        // Json response

        //Prettifying
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);

    }

    public static void displayAllTeams() throws UnsupportedEncodingException {
        String host = "https://euro-20242.p.rapidapi.com/teams";
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "403817c476msh6b73b2840b3100bp1f3dfcjsn08d31a968d78";


        // Format query for preventing encoding problems

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));

        // Format query for preventing encoding problems

        // Json response

        //Prettifying
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);


    }
    public static void displayAllMatches(){
        String host = "https://euro-20242.p.rapidapi.com/matches";
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "403817c476msh6b73b2840b3100bp1f3dfcjsn08d31a968d78";


        // Format query for preventing encoding problems

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));

        // Format query for preventing encoding problems

        // Json response

        //Prettifying
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);


    }
    public static void displayAllGroups(){
        String host = "https://euro-20242.p.rapidapi.com/groups";
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "403817c476msh6b73b2840b3100bp1f3dfcjsn08d31a968d78";


        // Format query for preventing encoding problems

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));

        // Format query for preventing encoding problems

        // Json response

        //Prettifying
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);

    }
    public static void displayGroupMatches(String groupID) throws UnsupportedEncodingException {

        String host = "https://euro-20242.p.rapidapi.com/teams/" + URLEncoder.encode(groupID, "UTF-8") + "/matches";
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "403817c476msh6b73b2840b3100bp1f3dfcjsn08d31a968d78";

        String s = "Pulp";
        // Format query for preventing encoding problems

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));

        // Json response

        //Prettifying
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);

    }


    public static void main(String[] args) throws Exception {
        String playerID ="6662f062c1920f21f03ed7a6";
        topScorer();
    }


}

