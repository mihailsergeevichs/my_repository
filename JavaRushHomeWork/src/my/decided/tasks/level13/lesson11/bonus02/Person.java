package my.decided.tasks.level13.lesson11.bonus02;

public class Person implements RepkaItem
{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh)
    {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    @Override
    public String getNamePadezh() {
        return name + "за" + "namePadezh";
    }
    public void pull(Person second)
    {
        System.out.println(this.name + " за "+ second.namePadezh);
    }
}
