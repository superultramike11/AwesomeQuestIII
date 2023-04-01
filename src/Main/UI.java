package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI {
    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    public UI(GameManager gm) {
        this.gm = gm;

        createMainField();
        generateScene();

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea("THIS IS SAMPLE TEXT");
        messageText.setBounds(50,410,700,150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        window.add(messageText);
    }

    public void createBackground(int bgNum, String bgFileName) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 700, 350);
        bgPanel[bgNum].setBackground(Color.blue);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
        bgLabel[bgNum].setIcon(bgIcon);        
    }

    public void createObject(int bgNum, int objx, int objy, int objwidth, int objheight, String objFileName,
    String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command) {
        // Create pop menu
        JPopupMenu popMenu = new JPopupMenu();

        // Create pop menu items
        JMenuItem menuItem[] = new JMenuItem[4]; // Use [1,2,3]
        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(choice1Command);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(choice2Command);
        popMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(choice3Name);
        menuItem[3].addActionListener(gm.aHandler);
        menuItem[3].setActionCommand(choice3Command);
        popMenu.add(menuItem[3]);

        // Create objects
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx, objy, objwidth, objheight);
        //objectLabel.setOpaque(true);
        //objectLabel.setBackground(Color.blue);

        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
            }
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        bgPanel[bgNum].add(objectLabel); // places hut
    }

    public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {
        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.aHandler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        bgPanel[bgNum].add(arrowButton);
    }

    public void generateScene() {
        // Scene 1
        createBackground(1, "greenbg700x350.png");
        createObject(1, 440, 140, 200, 200, "hut 200x200.png", "Look", "Talk", "Rest", "lookHut", "talkHut", "restHut");
        createObject(1, 70, 180, 150, 150, "guard 150x150.png", "Look", "Talk", "Attack", "lookGuard", "talkGuard", "attackGuard");
        createObject(1, 310, 280, 70, 70, "chest 70x70.png", "Look", "Talk", "Open", "lookChest", "talkChest", "openChest");
        createArrowButton(1, 0, 150, 50, 50, "leftarrow 50x50.png", "goScene2");
        bgPanel[1].add(bgLabel[1]); // places background
    
        // Scene 2
        createBackground(2, "cave 700x350.jpg");
        createObject(2, 0, 100, 100, 300, "blank.png", "Look", "Talk", "Enter", "lookCave", "talkCave", "enterCave");
        createObject(2, 355, 250, 50, 50, "blank.png", "Look", "Talk", "Search", "lookRoot", "talkRoot", "searchRoot");
        createArrowButton(2, 650, 150, 50, 50, "rightarrow 50x50.png", "goScene1");
        bgPanel[2].add(bgLabel[2]);
    }
}