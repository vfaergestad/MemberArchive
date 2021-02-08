import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberArchiveTest {
    MemberArchive members;
    BonusMember member;

    @BeforeEach
    void init(){
        members = new MemberArchive();
        member = new BonusMember(6, LocalDate.of(2020, 2, 8),
                10000, "Kajsa",
                "kajsa@gmail.com", "Baloo123");
    }

    @Test
    void testConstructor(){
        assertNotNull(members);
    }

    @Test
    void testAddMember(){
        BonusMember member2 = new BonusMember(6, LocalDate.of(2020, 2, 8),
                10000, "Kajsa",
                "kajsa@gmail.com", "Baloo123");
        assertTrue(members.addMember(member));
        assertFalse(members.addMember(member2));
        assertFalse(members.addMember(null));
    }

    @Test
    void testRegisterAndFindPoints(){
        members.addMember(member);
        assertEquals(10000, members.findPoints(6, "Baloo123"));
        assertNotEquals(5000, members.findPoints(6, "Baloo123"));
        assertEquals(-1, members.findPoints(7, "Baloo123"));
        assertEquals(-1, members.findPoints(6, "Baloo1234"));

        assertTrue(members.registerPoints(6, 10000));
        assertFalse(members.registerPoints(-1, 10000));

        assertEquals(20000, members.findPoints(6, "Baloo123"));
    }



}