import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl, titlePnl, displayPnl, cmdPnl;
    JLabel titleLbl;
    ImageIcon icon;
    JScrollPane scroller;
    JTextArea fortuneTA;
    JButton quitBtn, fortuneBtn;
    String fortunes[] = new String[15];
    int curFortuneDex = -1;

    public FortuneTellerFrame()
    {
        loadFortunes();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTitlePanel();
        createDisplayPanel();
        createControlPanel();

        setTitle("Fortune Teller");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadFortunes()
    {
        fortunes[1] = "A beautiful, smart, and loving person will be coming into your life.";
        fortunes[2] = "A dubious friend may be an enemy in camouflage.";
        fortunes[3] = "A friend is a present you give yourself.";
        fortunes[4] = "A funny coincidence will make your day.";
        fortunes[5] = "A gambler not only will lose what he has, but also will lose what he doesn’t have.";
        fortunes[6] = "A golden egg of opportunity falls into your lap this month.";
        fortunes[7] = "A lifetime friend shall soon be made.";
        fortunes[8] = "A new outlook brightens your image and brings new friends.";
        fortunes[9] = "A person of words and not deeds is like a garden full of weeds.";
        fortunes[10] = "Distance yourself from the vain.";
        fortunes[11] = "Expect much of yourself and little of others.";
        fortunes[12] = "Happy life is just in front of you.";
        fortunes[13] = "In the end all things will be known.";
        fortunes[14] = "Never fear! The end of something marks the start of something new.";
    }

    public void createTitlePanel()
    {
        titlePnl = new JPanel();
        icon = new ImageIcon("src/FortuneTeller.jpg");
        titleLbl = new JLabel(icon);
        titleLbl.setText("Get your Fortune!");
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);

        titlePnl.add(titleLbl);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }

    public void createDisplayPanel()
    {
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(15, 50);
        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }

    public void createControlPanel()
    {
        Random rnd = new Random();
        cmdPnl = new JPanel();
        cmdPnl.setLayout(new GridLayout(1,2));
        fortuneBtn = new JButton("Get a Fortune!");
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            int newDex = curFortuneDex;
            do {
                newDex = rnd.nextInt(fortunes.length);
            }while(newDex == curFortuneDex);
            curFortuneDex = newDex;
            fortuneTA.append(fortunes[newDex] + "\n");
        }
        );

        cmdPnl.add(fortuneBtn);
        cmdPnl.add(quitBtn);
        mainPnl.add(cmdPnl, BorderLayout.SOUTH);
    }
}
