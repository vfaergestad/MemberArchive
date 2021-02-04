public class SilverMembership extends Membership{

    private final float POINTS_SCALING_FACTOR = 1.2f;

    /**
     * Abstract method to register and add new points to balance.
     * @param bonusPointBalance Balance to add new points to.
     * @param newPoints New points to add to current balance.
     * @return Balance with new points added as int.
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        float newPointsFloat = (float) newPoints;
        return bonusPointBalance + Math.round(newPointsFloat*POINTS_SCALING_FACTOR);
    }

    /**
     * Method that returns membership name.
     * @return Membership name as string.
     */
    @Override
    public String getMembershipName() {
        return "Silver";
    }
}
