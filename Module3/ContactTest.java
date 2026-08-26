import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        Contact c = new Contact("Grace Hopper", "555-0000");
        assertEquals("Grace Hopper", c.getName());
    }

    @Test
    void toString_containsName() {
        Contact c = new Contact("Alan Turing", "555-0001");
        assertTrue(c.toString().contains("Alan Turing"));
    }

    @Test
    void toString_containsPhone() {
        Contact c = new Contact("Alan Turing", "555-0001");
        assertTrue(c.toString().contains("555-0001"));
    }

    @Test
    void contactsWithSameName_remainIndependent() {
        Contact contact1 = new Contact("Ada Lovelace", "555-1111");
        Contact contact2 = new Contact("Ada Lovelace", "555-2222");

        assertEquals("555-1111", contact1.getPhone());
        assertEquals("555-2222", contact2.getPhone());
    }
}