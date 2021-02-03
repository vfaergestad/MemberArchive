public class GoldMembership extends Membership{

    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        float newPointsFloat = Float.intBitsToFloat(newPoints);
        if (bonusPointBalance < 90000){
            return bonusPointBalance + Math.round(newPointsFloat*POINTS_SCALING_FACTOR_LEVEL_1);
        } else {
            return bonusPointBalance + Math.round(newPointsFloat*POINTS_SCALING_FACTOR_LEVEL_2);
        }
    }

    @Override
    String getMembershipName() {
        return "Gold";
    }
}
