import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import com.github.javafaker.Faker;

public class BunTest {
    static Faker faker = new Faker();

    @Test
    public void getNameTest() {
        String testBunName = faker.funnyName().name();
        Bun bun = new Bun(testBunName, (float)faker.number().randomDouble(1, 1, 100));
        Assert.assertEquals(testBunName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        float testPrice = (float)faker.number().randomDouble(1, 1, 100);
        Bun bun = new Bun(faker.funnyName().name(), testPrice);
        // сравнивать числа  плавающей точкой на точное равенство не совсем конкретно, поэтому использую +/- эпсилон 0.01
        Assert.assertEquals(testPrice, bun.getPrice(), 0.01);
    }
}
