import java.time.LocalDate;
import java.util.HashMap;

/**
 * The member archive holds all the bonus members. The archive provides
 * functionality for adding members to the register, looking up bonuspoints
 * of given members, registering new bonuspoints and listing all the members.
 */
public class MemberArchive {

    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, BonusMember> members;

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.members = new HashMap<>();
        this.fillRegisterWithTestdata();
    }

    /**
     * Adds a new member to the register. The new member must have a memebr number
     * different from exsisting members. If not, the new member will not be added.
     *
     * @return {@code true} if the new member was added successfully,
     *         {@code false} if the new member could not be added, due to a
     *          membernumber that allready exsists.
     */
    public boolean addMember(BonusMember bonusMember) {
        boolean success = false;
        if (!members.containsKey(bonusMember.getMemberNumber())){
            members.put(bonusMember.getMemberNumber(), bonusMember);
            success = true;
        }
        return success;
    }

    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code false} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        boolean success = false;
        BonusMember member = members.get(memberNumber);
        if (member != null){
            member.registerBonusPoints(bonusPoints);
            success = true;
        }
        return success;
    }

    /**
     * Lists all members to the console.
     */
    public void listAllMembers() {
        for (BonusMember member : members.values()){
            listMember(member);
        }
    }

    /**
     * Lists a given member to console.
     * @param member Member to list.
     */
    public void listMember(BonusMember member){
        System.out.println("" + member.getName() + " " + member.getMembership().getMembershipName() + " " +  member.getBonusPointsBalance());
    }

    /**
     * Find and returns a members points, if member exist, and password is correct.
     * @param memberNumber Number of member to check.
     * @param password Password of member to check.
     * @return Points of member if number exists or password is correct.
     *          -1 if number do not exist or password incorrect.
     */
    public int findPoints(int memberNumber, String password){
        int result = -1;
        if (members.containsKey(memberNumber)){
            BonusMember member = members.get(memberNumber);
            if (member.checkPassword(password)){
                result = member.getBonusPointsBalance();
            }
        }
        return result;
    }


    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    private void fillRegisterWithTestdata() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "password");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz", "password");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no", "password");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org", "password");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com", "password");
        this.members.put(member.getMemberNumber(), member);

    }


}