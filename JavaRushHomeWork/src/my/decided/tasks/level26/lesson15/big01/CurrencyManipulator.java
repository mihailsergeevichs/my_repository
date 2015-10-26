package my.decided.tasks.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Overlord on 29.06.15.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private static Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode =currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }
    public  void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination)){
            denominations.put(denomination,denominations.get(denomination)+count);
        }else{
            denominations.put(denomination,count);
        }
    }
    public int getTotalAmount(){
        int result=0;
        for(Map.Entry<Integer,Integer> pair :denominations.entrySet()){

            result = result+(pair.getKey()*pair.getValue());
        }
        return result;
    }
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("CurrencyManipulator{");
        sb.append("currencyCode='").append(currencyCode).append('\'');
        sb.append(", denominations=").append(denominations);
        sb.append('}');
        return sb.toString();
    }

    public static boolean hasMoney(){
        return denominations.size()!=0;
    }
}