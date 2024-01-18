import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HtmlRead implements ActionListener {
    public JScrollPane scrollPane;
    public String links = "";
    private JFrame mainFrame;
    private JLabel keyWord;
    private JLabel url;
    //private JLabel results;
    private JTextArea results;
    private JPanel allKeyWord;
    private JPanel allUrl;
    private JPanel top;
    private JPanel topHalf;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;

    private JTextField keyWordTF;
    private JTextField urlTF;
    private int WIDTH = 800;
    private int HEIGHT = 700;
    public String usersUrl;
    public String usersKeyword;

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
        //html.showEventDemo();
    }

    public HtmlRead() {
        prepareGUI();
        showEventDemo();

//        try {
//            System.out.println();
//            System.out.print("hello \n");
////            URL url = new URL("https://www.milton.edu/");
//            URL url = new URL(usersUrl);
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(url.openStream())
//            );
//            String line;
//
////            Scanner scan = new Scanner(System.in);
////            System.out.println("enter your keyword:");
////            String keyword = scan.nextLine();
//            String keyword = usersKeyword;
//
//            while ((line = reader.readLine()) != null) {
//
//                //System.out.println(line);
//                while (line.contains("href=")) {
//                    int start = line.indexOf("href");
//
//                    String link = line.substring(start + 6);
//                    //System.out.println(link);
//
//                    int singleQuote = link.indexOf("'");
//                    int doubleQuote = link.indexOf('"');
//
//                    String newLink = "";
//                    if (singleQuote == -1) {
//                        newLink = link.substring(0, doubleQuote);
//                        if (newLink.contains(keyword)) {
//                            System.out.println(newLink);
//                        }
//                    } else if (doubleQuote == -1) {
//                        newLink = link.substring(0, singleQuote);
//                        if (newLink.contains(keyword)) {
//                            System.out.println(newLink);
//                        }
//                    } else if (singleQuote < doubleQuote) {
//                        newLink = link.substring(0, singleQuote);
//                        if (newLink.contains(keyword)) {
//                            System.out.println(newLink);
//                        }
//                    } else {
//                        newLink = link.substring(0, doubleQuote);
//                        if (newLink.contains(keyword)) {
//                            System.out.println(newLink);
//                        }
//                    }
//                    links = links + "\n" + newLink;
//                    line = line.substring(line.indexOf(newLink + 1));
//
//                }
//            }
//            reader.close();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        results.setText(links);
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(2, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        allKeyWord = new JPanel();
        allKeyWord.setLayout(new BorderLayout()); //set the layout of the pannel

        allUrl = new JPanel();
        allUrl.setLayout(new BorderLayout()); //set the layout of the pannel

        top = new JPanel();
        top.setLayout(new GridLayout(1, 2)); //set the layout of the pannel

        topHalf = new JPanel();
        topHalf.setLayout(new BorderLayout()); //set the layout of the pannel

        top.add(allKeyWord);
        top.add(allUrl);

        topHalf.add(top, BorderLayout.CENTER);

        keyWordTF = new JTextField();
        urlTF = new JTextField();

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        //end menu at top

        mainFrame.add(mb);  //add menu bar
        mainFrame.setJMenuBar(mb); //set menu bar

        results = new JTextArea();
        results.setBounds(50, 5, WIDTH-100, HEIGHT-50);

        JScrollPane scrollPane = new JScrollPane(results);

        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new java.awt.Dimension(250, 150));

        // Add the JScrollPane to the JFrame
        mainFrame.add(topHalf);
        mainFrame.getContentPane().add(scrollPane);

        keyWord = new JLabel("enter your key word:");
        keyWord.setHorizontalAlignment(JLabel.CENTER);
        url = new JLabel("enter your url:");
        url.setHorizontalAlignment(JLabel.CENTER);
//        results = new JLabel("results");
//        results.setHorizontalAlignment(JLabel.CENTER);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    private void showEventDemo() {

        JButton go = new JButton("go");

        allKeyWord.add(keyWord, BorderLayout.NORTH);
        allKeyWord.add(keyWordTF, BorderLayout.CENTER);

        allUrl.add(url, BorderLayout.NORTH);
        allUrl.add(urlTF, BorderLayout.CENTER);

        topHalf.add(go, BorderLayout.SOUTH);

        //mainFrame.add(topHalf);
        //mainFrame.add(results);
        //mainFrame.getContentPane().add(scrollPane);

        //mainFrame.add(button3, BorderLayout.SOUTH);
        mainFrame.setVisible(true);

        go.setActionCommand("go");
        go.addActionListener(new ButtonClickListener());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            keyWordTF.cut();
        if (e.getSource() == paste)
            keyWordTF.paste();
        if (e.getSource() == copy)
            keyWordTF.copy();
        if (e.getSource() == selectAll)
            keyWordTF.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("go")) {
                usersUrl = urlTF. getText();
                usersKeyword = keyWordTF. getText();
                try {
                    System.out.println();
                    System.out.print("hello \n");
//            URL url = new URL("https://www.milton.edu/");
                    URL url = new URL(usersUrl);
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(url.openStream())
                    );
                    String line;

//            Scanner scan = new Scanner(System.in);
//            System.out.println("enter your keyword:");
//            String keyword = scan.nextLine();
                    String keyword = usersKeyword;

                    while ((line = reader.readLine()) != null) {

                        System.out.println(line);
                        while (line.contains("href=")) {
                            int start = line.indexOf("href");

                            String link = line.substring(start + 6);
                            System.out.println(link);

                            int singleQuote = link.indexOf("'");
                            int doubleQuote = link.indexOf("\"");

                            String newLink = "";
                            if (singleQuote == -1) {
                                newLink = link.substring(0, doubleQuote);
                                if (newLink.contains(keyword)) {

                                    System.out.println(newLink);
                                    links = links + " \n " + newLink;
                                }
                            } else if (doubleQuote == -1) {
                                newLink = link.substring(0, singleQuote);
                                if (newLink.contains(keyword)) {
                                    System.out.println(newLink);
                                    links = links + " \n " + newLink;
                                }
                            } else if (singleQuote < doubleQuote) {
                                newLink = link.substring(0, singleQuote);
                                if (newLink.contains(keyword)) {
                                    System.out.println(newLink);
                                    links = links + " \n " + newLink;
                                }
                            } else {
                                newLink = link.substring(0, doubleQuote);
                                if (newLink.contains(keyword)) {
                                    System.out.println(newLink);
                                    links = links + " \n " + newLink;
                                }
                            }
                            //links = links + "\n" + newLink;
                            System.out.println(line);
                            line = line.substring(start+1);

                        }
                    }
                    reader.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                results.setText(links);
                //change results to text area and add scroll pane
                //results.setText(usersLink + " " + usersKeyword);
            }
        }

    }
}

//contains method - checks if char sequence is in a string
//contains(CharSequence

//indexOf(String str)
//returns the index within the string of the first occurrence of the specified substring

//indexOf(String str, int fromIndex)
//starts at the fromIndex-th character

//lastIndexOf(String str)
//returns index of last occurrence

//substring(int beginIndex)
//returns a string that is a substring of this string