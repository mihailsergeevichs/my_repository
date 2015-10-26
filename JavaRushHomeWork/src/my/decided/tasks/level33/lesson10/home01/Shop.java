package my.decided.tasks.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 04.09.2015.
 */
@XmlType(name="shop")
@XmlRootElement
public class Shop
{
    @XmlElementWrapper(name="goods", nillable = true)
    public List<String> names;
    @XmlElement(name = "count")
    public int count;
    @XmlElement(name = "profit")
    public double profit;
    @XmlElement
    public List<String> secretData;

    public Shop(){
        names = new ArrayList<>();
        secretData = new ArrayList<>();
    }
}