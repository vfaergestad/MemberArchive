import java.time.LocalDate;

public class BonusMember {

    private final int memberNumber;
    private final LocalDate enrolledDate;
    private int bonusPointsBalance;
    private final String name;
    private final String eMailAddress;
    private final String password;
    private Membership membership;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    /**
     * Constructor for the class.
     * @param memberNumber Membernumber as int.
     * @param enrolledDate Enrolled date as LocalDate object.
     * @param bonusPointsBalance Current bonuspoints balance as int.
     * @param name Name of member as string.
     * @param eMailAddress Member emailaddress as string.
     * @param password Member password as String.
     */
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name,
                       String eMailAddress, String password) throws IllegalArgumentException{
        if (memberNumber > 0){
            this.memberNumber = memberNumber;
        } else {
            throw new IllegalArgumentException("Invalid number.");
        }

        this.enrolledDate = enrolledDate;

        if (bonusPointsBalance > 0){
            this.bonusPointsBalance = bonusPointsBalance;
        } else {
            throw new IllegalArgumentException("Invalid balance");
        }

        if (name != null){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name.");
        }

        if (eMailAddress != null){
            this.eMailAddress = eMailAddress;
        } else {
            throw new IllegalArgumentException("Invalid eMailadress.");
        }

        if (password != null){
            this.password = password;
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
        checkAndSetMembership();
    }

    /**
     * Returns member number.
     * @return Member number as int.
     */
    public int getMemberNumber(){
        return memberNumber;
    }

    /**
     * Returns member enrolled date.
     * @return Enrolled date as a LocalDate object.
     */
    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    /**
     * Returns member BonusPoints balance.
     * @return BonusPoints balance as int.
     */
    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    /**
     * Returns member name.
     * @return Member name as String.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns member emailaddress.
     * @return Emailaddress as string.
     */
    public String getEMailAddress() {
        return eMailAddress;
    }

    /**
     * Returns member password.
     * @return Password as String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns membership status.
     * @return Membership status as Membership object.
     */
    public String getMembershipLevel() {
        return membership.getMembershipName();
    }

    /**
     * Check for correct password.
     * @param password Password to compare.
     * @return True if correct password, false if not.
     */
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    /**
     * Registers new points to a member.
     * @param newPoints Points to be added to balance.
     */
    public void registerBonusPoints(int newPoints){
        bonusPointsBalance = membership.registerPoints(bonusPointsBalance, newPoints);
        checkAndSetMembership();
    }

    /**
     * Checks and sets the correct membership for the member.
     */
    private void checkAndSetMembership(){
        if (bonusPointsBalance >= GOLD_LIMIT){
            membership = new GoldMembership();
        }
        else if (bonusPointsBalance >= SILVER_LIMIT){
            membership = new SilverMembership();
        }
        else {
            membership = new BasicMemberShip();
        }
    }
}
