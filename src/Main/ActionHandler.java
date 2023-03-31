package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

    GameManager gm;

    public ActionHandler(GameManager gm) {
        this.gm = gm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();
        switch(yourChoice) {
            case "lookHut": gm.ev1.lookHut(); break;
            case "talkHut": gm.ev1.talkHut(); break;
            case "restHut": gm.ev1.restHut(); break;

            case "lookGuard": gm.ev1.lookGuard(); break;
            case "talkGuard": gm.ev1.talkGuard(); break;
            case "attackGuard": gm.ev1.attackGuard(); break;

            case "lookChest": gm.ev1.lookChest(); break;
            case "talkChest": gm.ev1.talkChest(); break;
            case "openChest": gm.ev1.openChest(); break;
        }
    }
}