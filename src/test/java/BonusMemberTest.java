import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusMemberTest {
    static BonusMember member;

    @BeforeEach
    void addMember(){
        member = new BonusMember(1, LocalDate.of(2020, 2, 8),
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
        assertEquals(member.getEnrolledDate(), LocalDate.of(2020, 2, 8));
    }

    @Test
    void pointsHandling(){
        assertEquals(member.getBonusPointsBalance(), 10000);
        assertEquals(member.getMembershipLevel(), "Basic" );
        member.registerBonusPoints(15000);
        assertEquals(member.getMembershipLevel(), "Silver");
        member.registerBonusPoints(50000);
        assertEquals(member.getMembershipLevel(), "Gold");
        member.registerBonusPoints(30000);
        member.registerBonusPoints(10000);
    }

    @Test
    void checkPassword() {
        assertTrue(member.checkPassword("Baloo123"));
        assertFalse(member.checkPassword("Baloo1234"));
    }
}