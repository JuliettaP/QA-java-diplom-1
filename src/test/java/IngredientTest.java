import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    static Faker faker = new Faker();

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {SAUCE, faker.funnyName().name(), (float)faker.number().randomDouble(1, 1, 100)},
                {FILLING, faker.funnyName().name(), (float)faker.number().randomDouble(1, 1, 100)},
                {SAUCE, faker.funnyName().name(), (float)faker.number().randomDouble(1, 1, 100)},
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        // сравнивать числа  плавающей точкой на точное равенство не совсем конкретно, поэтому использую +/- эпсилон 0.01
        Assert.assertEquals(price, ingredient.getPrice(), 0.01);
    }
}
