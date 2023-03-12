package HomeWork3;

public class Man extends Human{
    Man() {
        this.setSex(true);
    }

    Man (
        String firstname,
        String lastname,
        float height,
        float weight)

    {
        super(
            true,
            firstname,
            lastname,
            height,
            weight
        );
    }

}
