package com.cricket;
import java.util.*;
public class CircketTeamSelection {
    HashSet<PlayerInfo> playersSet = new HashSet<>();
    public static void main(String[] args) throws
            PlayerNotFoundException,
            PlayerAlreadyExisted,
            DucksOverloadException,
            RunsScoredWithoutMatchesPlayedException,
            WicketsTakenWithoutMatchesPlayedException{
        Scanner s = new Scanner(System.in);
        CircketTeamSelection cts = new CircketTeamSelection();
        DispAllPlayers dap = new DispAllPlayers();
        StaticPlayersList spl = new StaticPlayersList();
        UpdatePlayerByName upbn = new UpdatePlayerByName();
        DisplayFinalTeam dft = new DisplayFinalTeam();
        AddPlayerInformation api = new AddPlayerInformation();
        spl.playersList(cts.playersSet);
        char dis;
        do {
            System.out.println("Please choose one option from the menu: ");
            System.out.println("1 Display All Players");
            System.out.println("2 Update Player Information by name");
            System.out.println("3 Display Final Team");
            System.out.println("4 Add Player Information");
            System.out.println("5 Exit");
            switch (s.next()) {
                case "1":
                    List<PlayerInfo> playersList = new ArrayList<>(cts.playersSet);
                    dap.dispAllPlayers(playersList);
                    break;
                case "2":
                    System.out.println("Enter the name of the player you want to update: ");
                    s.nextLine();
                    String playerN = s.nextLine();
                    try{
                        if(!upbn.updatePlayer(cts.playersSet, playerN)){
                            throw new PlayerNotFoundException("Not Found");
                        }
                        else{
                            System.out.println("Successfully updated the details of "+playerN);
                        }
                    }
                    catch(PlayerNotFoundException pnfe){
                    System.out.println("Player not found, please enter a valid name...!");
                    }
                    catch(DucksOverloadException doe){
                        System.out.println("Player have more number of out's on zero then number of matches played, please enter valid deatils...!");
                    }
                    catch(RunsScoredWithoutMatchesPlayedException rwmpe){
                        System.out.println("Player have more number of runs scored without playing, please enter valid deatils...!");
                    }
                    catch(WicketsTakenWithoutMatchesPlayedException wtwmpe){
                        System.out.println("Player have more number of wickets taken without playing, please enter valid deatils...!");
                    }
                    break;
                case "3":
                    dft.dispFinalTeam(cts.playersSet);
                    break;
                case "4":
                    try {
                        api.addPlayer(cts.playersSet);
                    }
                    catch(PlayerAlreadyExisted pae){
                        System.out.println("Player already existed, please enter valid deatils...!");
                    }
                    catch(DucksOverloadException doe){
                        System.out.println("Player have more number of out's on zero then number of matches played, please enter valid deatils...!");
                    }
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select a valid option between[1-5] :( ");
                    break;
            }
            System.out.println("Do you want to continue [Y/N]");
            dis = s.next().charAt(0);
        }
        while (dis == 'y' || dis == 'Y');
    }
}
