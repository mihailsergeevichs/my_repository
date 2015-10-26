package my.decided.tasks.level33.lesson05.home01;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 27.08.2015.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public Shop(){
        names = new ArrayList();
        secretData = new ArrayList<>();
    }

    @XmlAnyElement
    @XmlElementWrapper(name="goods", nillable = true)
    public List<String> names;

    @XmlAnyElement
    public List<String> secretData;

    @XmlElement(name = "count")
    public Integer count = 12;
    @XmlElement(name = "profit")
    public Double profit = 123.4;
}
