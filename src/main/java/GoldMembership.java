public class GoldMembership extends Membership{

    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    /**
     * Abstract method to register and add new points to balance.
     * @param bonusPointBalance Balance to add new points to.
     * @param newPoints New points to add to current balance.
     * @return Balance with new points added as int.
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        float newPointsFloat = (float) newPoints;
        if (bonusPointBalance < 90000){
            return bonusPointBalance + Math.round(newPointsFloat*POINTS_SCALING_FACTOR_LEVEL_1);
        } else {
            return bonusPointBalance + Math.round(newPointsFloat*POINTS_SCALING_FACTOR_LEVEL_2);
        }
    }

    /**
     * Method that returns membership name.
     * @return Membership name as string.
     */
    @Override
    public String getMembershipName() {
        return "Gold";
    }
}
