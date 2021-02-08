import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusMemberTest {
    static BonusMember member;

    @BeforeAll
    static void addMember(){
        member = new BonusMember(1, LocalDate.now(),
                10000, "Kajsa",
                "kajsa@gmail.com", "Baloo123");
    }

    @Test
    void BonusMember() {
        assertEquals(member.getBonusPointsBalance(), 10000);
        assertEquals(member.getMemberNumber(), 1);
        assertEquals(member.getName(), "Kajsa");
        assertEquals(member.getEMailAddress(), "kajsa@gmail.com");
        assertEquals(member.getPassword(), "Baloo123");

    }

    @Test
    void checkPassword() {
        assertTrue(member.checkPassword("Baloo123"));
        assertFalse(member.checkPassword("Baloo1234"));
    }

    @Test
    void registerBonusPoints() {
        assertEquals(member.getBonusPointsBalance(), 10000);
        member.registerBonusPoints(10000);
        assertEquals(member.getBonusPointsBalance(), 20000);

    }
}