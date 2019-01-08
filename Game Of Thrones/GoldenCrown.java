package GeekTrust;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class UpdatedGoldenCrown {
    private static HashSet<String> allies = new HashSet<>();

    public static void main(String[] args) {
        CheckWhoIsTheRuler();
        TakeUserInput();
    }

    private static void CheckWhoIsTheRuler() {
        Iterator<String> iterator = allies.iterator();
        System.out.println("Who is the ruler of southeros");
        if (allies.size() == 3 || allies.size() > 3) {
            System.out.println("King Shan");
        } else {
            System.out.println("none");
        }

        System.out.println("Allies of Ruler");
        if (allies.size() == 3 || allies.size() > 3) {
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        } else {
            System.out.println("none");
        }
    }

    private static void TakeUserInput() {
        String useremblem="";
        System.out.println("Oh King!!!,Please Choose A Kingdom from the list below or select nothing to check your present status");
        System.out.print("[1]Land" + " " + "[2]Water" + " " + "[3]Air" + " " + "[4]Ice" + " " + "[5]Fire");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        String userinput = scanner.nextLine().toLowerCase().trim();
        switch (userinput){
            case "land":
                useremblem = "panda";
                Crown(useremblem,userinput);
                break;
            case "water":
                useremblem="octopus";
                Crown(useremblem,userinput);
                break;
            case "air":
                useremblem="owl";
                Crown(useremblem,userinput);
                break;
            case "ice":
                useremblem="mammoth";
                Crown(useremblem,userinput);
                break;
            case "fire":
                useremblem="dragon";
                Crown(useremblem,userinput);
                break;
            case "":
                CheckWhoIsTheRuler();
                break;
            default:
                System.out.println("Come on man!!, You can't choose something that doesn't exist, you can choose only from the Southeros and pandemonium reigns.So,Please select one again");
                TakeUserInput();
                break;
        }
    }

    private static void Crown(String emblemgiven,String kingdom) {
        System.out.println("Oh Mighty King,Please Enter Your Secret Message");
        Scanner scanner = new Scanner(System.in);
        String secretmessage = scanner.nextLine().toLowerCase();
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        StringBuilder three = new StringBuilder();
        one.append(emblemgiven);
        two.append(secretmessage);
        for(int i =0;i<one.length();i++) {
            for (int j = 0; j < two.length(); j++) {
                if (one.charAt(i) == two.charAt(j)) {
                    three.append(one.charAt(i));
                    two.deleteCharAt(j);
                    break;
                }
            }
        }
        if(one.toString().equals(three.toString())){
            allies.add(kingdom);
        }
        TakeUserInput();
    }
}