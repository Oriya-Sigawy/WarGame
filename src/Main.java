import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//TODO - give names to king, queen and prince
public class Main {
    public static void main(String[] args) {

        Hand gamer1 = new Hand();
        Hand gamer2 = new Hand();
       LinkedList<Card> pack = new LinkedList<>();
        for (int i = 1; i < 5; i++)
        {
            for (int j = 1; j < 14; j++)
            {
                String kind = null;
                if (i == 1) {
                    kind = "clover";
                }
                if (i == 2) {
                    kind = "leaf";
                }
                if (i == 3) {
                    kind = "heart";
                }
                if (i == 4) {
                    kind = "diamond";
                }
                Card card = new Card(j, kind);
                pack.add(card);
            }
        }
        for (int i = 0; i < 2; i++)
        {
            Card joker = new Card(14, "joker");
            pack.add(joker);
        }
        Collections.shuffle(pack);
        for (int i = 0; i < 54; i++)
        {
            if(i%2==0)
            {
                gamer1.addHand(pack.removeFirst());
            }
            else
            {
                gamer2.addHand(pack.removeFirst());
            }
        }
        boolean end = false;
        LinkedList<Card> caseOfWAR = new LinkedList<>();
        while (!end)
        {
           //both gamers poll cards
            //compare between the cards
            //case of winner
            //case of war
            //check for empty hand
            //check for empty side (winner)
            Card card1= gamer1.pop();
            Card card2= gamer2.pop();
            if (card1.get_num()>card2.get_num())
            {
                gamer1.addSide(card1);
                gamer1.addSide(card2);
            }
            if (card1.get_num()<card2.get_num())
            {
                gamer2.addSide(card1);
                gamer2.addSide(card2);
            }
            //TODO - CHECK IF HAND AND SIDE EMPTY after every card
            if (card1.get_num() == card2.get_num())
            {
                boolean war = true;
                while (war)
                {
                    caseOfWAR.add(card1);
                    caseOfWAR.add(card2);
                    caseOfWAR.add(gamer1.pop());
                    caseOfWAR.add(gamer1.pop());
                    caseOfWAR.add(gamer1.pop());
                    caseOfWAR.add(gamer2.pop());
                    caseOfWAR.add(gamer2.pop());
                    caseOfWAR.add(gamer2.pop());
                    card1=gamer1.pop();
                    card2=gamer2.pop();
                    if (card1.get_num()>card2.get_num())
                    {
                        gamer1.addSide(card1);
                        gamer1.addSide(card2);
                        for (int i = 0; i <caseOfWAR.size() ; i++)
                        {
                            gamer1.addSide(caseOfWAR.removeFirst());
                        }
                        war=false;
                    }
                    if (card1.get_num()<card2.get_num())
                    {
                        gamer2.addSide(card1);
                        gamer2.addSide(card2);
                        for (int i = 0; i <caseOfWAR.size() ; i++)
                        {
                            gamer2.addSide(caseOfWAR.removeFirst());
                        }
                        war=false;
                    }
                }

            }
          if(empty(gamer1))
          {
              gamer2.setWinner(true);
              end=true;
          }
            if(empty(gamer2))
            {
                gamer1.setWinner(true);
                end=true;
            }
        }
    }
    public static boolean empty(Hand gamer) {
        if (gamer.isEmpty()) {
            if (gamer.isSideEmpty()) {
                return true;
            }
            else
            {
                for (int i = 0; i < gamer.sideSize(); i++) {
                    gamer.addHand(gamer.popSide());
                }
            }
        }
        return false;
    }
}
