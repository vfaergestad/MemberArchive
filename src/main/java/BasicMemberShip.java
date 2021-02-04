public class BasicMemberShip extends Membership {

    /**
     * Abstract method to register and add new points to balance.
     * @param bonusPointBalance Balance to add new points to.
     * @param newPoints New points to add to current balance.
     * @return Balance with new points added as int.
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    /**
     * Method that returns membership name.
     * @return Membership name as string.
     */
    @Override
    public String getMembershipName() {
        return "Basic";
    }
}
