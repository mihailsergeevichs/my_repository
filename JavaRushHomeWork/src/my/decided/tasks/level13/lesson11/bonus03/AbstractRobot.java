package my.decided.tasks.level13.lesson11.bonus03;

public abstract class AbstractRobot
{
    int hitCount = 0;
    public BodyPart attack()
    {


        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1)
        {
            attackedBodyPart =  BodyPart.ARM;
        } else if (hitCount == 2)
        {
            attackedBodyPart =  BodyPart.HEAD;
        } else if (hitCount == 3)
        {
            hitCount = 0;
            attackedBodyPart =  BodyPart.LEG;
        }
        return attackedBodyPart;
    }
    public BodyPart defense()
    {
        BodyPart defencedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1)
        {
            defencedBodyPart =  BodyPart.HEAD;
        } else if (hitCount == 2)
        {
            defencedBodyPart =  BodyPart.LEG;
        } else if (hitCount == 3)
        {
            hitCount = 0;
            defencedBodyPart =  BodyPart.ARM;
        }
        else if (hitCount == 4)
        {
            defencedBodyPart = BodyPart.GRD;
        }
        return defencedBodyPart;
    }

    abstract String getName();
}
