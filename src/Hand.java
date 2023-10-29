import java.util.*;

public class Hand {
    static boolean winner;
   static Stack hand = new Stack<Card>();
    public boolean isEmpty()
    {
       return hand.isEmpty();
    }
    public boolean isSideEmpty()
    {
        return side.isEmpty();
    }
    static Queue<Card> side = new LinkedList<Card>();
    public void refill()
    {
      Card  temp = side.poll();
        hand.push(temp);
    }
    public void addHand(Card c)
    {
        hand.push(c);
    }
    public void addSide(Card c)
    {
        side.add(c);
    }
    public Card pop()
    {
        return (Card) hand.pop();
    }
    public Card popSide()
    {
        return (Card) side.remove();
    }
    public int sideSize() {return side.size();}
    public int handSize() {return hand.size();}
    public void setWinner(boolean flag) {winner=flag;}

}
