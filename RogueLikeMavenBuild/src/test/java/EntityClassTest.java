
import org.junit.jupiter.api.Test;
import rougelike.Entity;

import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {

    @Test
    public void testEntityHasName() {
        Entity entity = new Entity("TestPlayer");
        assertEquals("Testname", entity.getName(), "Character should have a name");
    }

    @Test
    public void testEntityInitialHealth() {
        Entity entity = new Entity("TestPlayer"));
        assertEquals(100, entity.getHealth(), "Character should have initial health of 100");
    }

    @Test
    public void testEntityInitialLevel() {
        Entity entity = new Entity("TestPlayer");
                assertEquals(1, entity.getLevel(), "Character should have initial level of 1");
    }
}
