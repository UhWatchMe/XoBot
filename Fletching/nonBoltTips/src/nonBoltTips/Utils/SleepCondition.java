package nonBoltTips.Utils;


/**
 * Keeps sleeping till a condition is valid
 *
 * @author Everel
 *
 */
public interface SleepCondition {

    /**
     * Determine if condition is valid
     * @return <b>true</b> if valid, otherwise <b>false</b>.
     */
    public boolean isValid();

}
