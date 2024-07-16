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
    private String coach;
    private String captain;
    private String championships;
    private String runnersUp;

    public Api(String name, int goals, int assists, int appearances, int firstTeamAppearances, int minutesPlayed, String teamName) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.appearances = appearances;
        this.firstTeamAppearances = firstTeamAppearances;
        this.minutesPlayed = minutesPlayed;
        this.teamName = teamName;
    }
    public Api(String name,String coach,String captain,String championships,String runnersUp){
        this.name=name;
        this.coach=coach;
        this.captain=captain;
        this.championships=championships;
        this.runnersUp=runnersUp;

    }


    public String getName() { return name; }
    public int getGoals() { return goals; }
    public int getAssists() { return assists; }
    public int getAppearances() { return appearances; }
    public int getFirstTeamAppearances() { return firstTeamAppearances; }
    public int getMinutesPlayed() { return minutesPlayed; }
    public String getTeamName() { return teamName; }
    public String getCaptain(){return captain;}
    public String getCoach(){return coach;}
    public String getChampionships(){return championships;}
    public String getRunnersUp(){return runnersUp;}

    public String toFormattedString() {
        return "Name: " + name + "\n" +
                "Goals: " + goals + "\n" +
                "Assists: " + assists + "\n" +
                "Appearances: " + appearances + "\n" +
                "First Team Appearances: " + firstTeamAppearances + "\n" +
                "Minutes Played: " + minutesPlayed + "\n" +
                "Team Name: " + teamName;
    }
    public String teamToFormattedString() {
        return "Name: " + name + "\n" +
                "Coach:" + coach + "\n" +
                "Captain: " + captain + "\n" +
                "Championships: " + championships + "\n" +
                "Runners Up: " + runnersUp;
    }

    public static List<Api> topScorer() throws Exception {
        String host = "https://euro-20242.p.rapidapi.com/players/topScorers";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "2c88eb9997msh93e1ed470796691p1b5f63jsn9cc88cd36945";

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        // Properly convert response to JSON Element
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(response.getBody().toString(), JsonArray.class);
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


    public static List<Api>topAssister() throws UnsupportedEncodingException {
        String host = "https://euro-20242.p.rapidapi.com/players/topAssisters";
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "2c88eb9997msh93e1ed470796691p1b5f63jsn9cc88cd36945";


        // Format query for preventing encoding problems

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(response.getBody().toString(), JsonArray.class);
        List<Api> topAssiter = new ArrayList<>();

        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            Api assister = new Api(
                    jsonObject.get("name").getAsString(),
                    jsonObject.get("goals").getAsInt(),
                    jsonObject.get("assists").getAsInt(),
                    jsonObject.get("appearances").getAsInt(),
                    jsonObject.get("firstTeamAppearances").getAsInt(),
                    jsonObject.get("minutesPlayed").getAsInt(),
                    jsonObject.get("teamName").getAsString()
            );
            topAssiter.add(assister);
        }
        return topAssiter;
    }


        // Format query for preventing encoding problems

        // Json response

        //Prettifying



    public static Api displayPlayer(String playerID) throws Exception {
        String host = "https://euro-20242.p.rapidapi.com/players/" + URLEncoder.encode(playerID, "UTF-8");
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "2c88eb9997msh93e1ed470796691p1b5f63jsn9cc88cd36945";

        HttpResponse<JsonNode> response = Unirest.get(host)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();

        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));

        // Print the raw response for debugging
        System.out.println("Response Body: " + response.getBody().toString());

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.getBody().getObject().toString(), JsonObject.class);

        // Check if jsonObject or any of its fields are null
        if (jsonObject == null) {
            throw new NullPointerException("The JsonObject is null");
        }

        String name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : "Unknown";
        int goals = jsonObject.has("goals") ? jsonObject.get("goals").getAsInt() : 0;
        int assists = jsonObject.has("assists") ? jsonObject.get("assists").getAsInt() : 0;
        int appearances = jsonObject.has("appearances") ? jsonObject.get("appearances").getAsInt() : 0;
        int firstTeamAppearances = jsonObject.has("firstTeamAppearances") ? jsonObject.get("firstTeamAppearances").getAsInt() : 0;
        int minutesPlayed = jsonObject.has("minutesPlayed") ? jsonObject.get("minutesPlayed").getAsInt() : 0;
        String teamName = jsonObject.has("teamName") ? jsonObject.get("teamName").getAsString() : "Unknown";

        Api player = new Api(name, goals, assists, appearances, firstTeamAppearances, minutesPlayed, teamName);
        return player;
    }

    public static Api displayTeam(String teamID) throws UnsupportedEncodingException {

        String host = "https://euro-20242.p.rapidapi.com/teams/" + URLEncoder.encode(teamID, "UTF-8") ;
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "2c88eb9997msh93e1ed470796691p1b5f63jsn9cc88cd36945";

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
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.getBody().getObject().toString(), JsonObject.class);
        if (jsonObject == null) {
            throw new NullPointerException("The JsonObject is null");
        }
        String name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : "Unknown";
        String coach = jsonObject.has("coach") ? jsonObject.get("coach").getAsString() : "Unknown";
        String captain = jsonObject.has("captain") ? jsonObject.get("captain").getAsString() : "Unknown";
        String championships = jsonObject.has("championships") ? jsonObject.get("championships").getAsString() : "Unknown";
        String runnersUp = jsonObject.has("runnersUp") ? jsonObject.get("runnersUp").getAsString() : "Unknown ";

        Api team =new Api( name, coach, captain,championships, runnersUp);
        return team;


    }

    public static  List <Api> displayAllTeams() throws UnsupportedEncodingException {
        String host = "https://euro-20242.p.rapidapi.com/teams";
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "2c88eb9997msh93e1ed470796691p1b5f63jsn9cc88cd36945";


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
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(response.getBody().toString(), JsonArray.class);
        List<Api> displayAllTeams = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            Api team = new Api(
                    jsonObject.get("name").getAsString(),
                    jsonObject.get("coach").getAsString(),
                    jsonObject.get("captain").getAsString(),
                    jsonObject.get("championships").getAsString(),
                    jsonObject.get("runnersUp").getAsString()

            );
            displayAllTeams.add(team);
        }
        return displayAllTeams;
    }





    public static void displayAllMatches(){
        String host = "https://euro-20242.p.rapidapi.com/matches";
        String charset = "UTF-8";
        String x_rapidapi_host = "euro-20242.p.rapidapi.com";
        String x_rapidapi_key = "2c88eb9997msh93e1ed470796691p1b5f63jsn9cc88cd36945";


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
        String x_rapidapi_key = "2c88eb9997msh93e1ed470796691p1b5f63jsn9cc88cd36945";


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
        String x_rapidapi_key = "2c88eb9997msh93e1ed470796691p1b5f63jsn9cc88cd36945";

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

    public static void main(String[] args) {
        try {
            List<Api> allTeams = displayAllTeams();
            for (Api team : allTeams) {
                System.out.println(team.teamToFormattedString());
                System.out.println("-------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error occurred: " + e.getMessage());
        }
    }



}


