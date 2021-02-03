public class SilverMembership extends Membership{

    private final float POINTS_SCALING_FACTOR = 1.2f;

    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        float newPointsFloat = Float.intBitsToFloat(newPoints);
        return bonusPointBalance + Math.round(newPointsFloat*POINTS_SCALING_FACTOR);
    }

    @Override
    String getMembershipName() {
        return "Silver";
    }
}
