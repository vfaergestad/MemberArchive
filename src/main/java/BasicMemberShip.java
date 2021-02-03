public class BasicMemberShip extends Membership {

    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    @Override
    String getMembershipName() {
        return "Basic";
    }
}
