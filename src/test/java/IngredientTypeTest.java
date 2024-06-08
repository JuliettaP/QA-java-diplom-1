import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    String valueOf;

    public IngredientTypeTest(String valueOf) {
        this.valueOf = valueOf;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                { "SAUCE" },
                { "FILLING" }
        };
    }
    @Test
    public void ingredientValueTest() {
        IngredientType ingredient = IngredientType.valueOf(valueOf);
        Assert.assertEquals(valueOf, ingredient.toString());
    }
}
