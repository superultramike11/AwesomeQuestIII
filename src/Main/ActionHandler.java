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
            case "lookHut": gm.ui.messageText.setText("This is your house"); break;
            case "talkHut": gm.ui.messageText.setText("Who are you talking to ?"); break;
            case "restHut": gm.ui.messageText.setText("You rest at the house.\n (Your life has recovered)"); break;
        }
    }
}