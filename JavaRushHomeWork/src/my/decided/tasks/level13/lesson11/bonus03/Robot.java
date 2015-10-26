package my.decided.tasks.level13.lesson11.bonus03;

public class Robot extends AbstractRobot implements Attackable, Defensable
{
    private static int hitCount;
    private String name;

    public Robot(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public BodyPart defense()
    {
        return null;
    }
    public BodyPart attack()
    {
     return null;
    }
}
