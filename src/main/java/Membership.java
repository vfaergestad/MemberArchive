/**
 * Superclass for the different Membership classes.
 */
public abstract class Membership {

    /**
     * Abstract method to register and add new points to balance.
     * @param bonusPointBalance Balance to add new points to.
     * @param newPoints New points to add to current balance.
     */
    abstract int registerPoints(int bonusPointBalance, int newPoints);

    /**
     * Method that returns membership name.
     */
    abstract String getMembershipName();

}
