package nonBoltTips.Methodes;

import nonBoltTips.Data.Data;
import nonBoltTips.Utils.Methodes;
import nonBoltTips.Utils.SleepCondition;
import xobot.script.methods.Bank;
import xobot.script.methods.GameObjects;
import xobot.script.methods.Packets;
import xobot.script.util.Time;
import xobot.script.wrappers.interactive.GameObject;

public class Banking {

    public static boolean canBank(){
        GameObject bank = GameObjects.getNearest(Data.BANK_ID);
        return bank != null && bank.isReachable();
    }

    public static void doBank(){
        GameObject bank = GameObjects.getNearest(Data.BANK_ID);
        if (bank != null && !Bank.isOpen()) {
            bank.interact("use-quickly");
            Methodes.conditionalSleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Bank.isOpen();
                }
            }, 8000);
        }

        if (Bank.isOpen()) {
            Bank.deposit(Data.CUTTED, 9999);
            Time.sleep(300);
            Bank.withdraw(Data.TO_CUT, 26);
            Packets.sendAction(200, 0, 2, 5384); //Close bank
        }
    }
}
