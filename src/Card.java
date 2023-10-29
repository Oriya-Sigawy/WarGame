public class Card {
    public static int _num;
    public static String _kind;
    public Card(int num, String kind)
    {
        _kind=kind;
        _num=num;
    }
    public int get_num() {return _num;}
    public String get_kind() {return _kind;}
}
