package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 10;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Lapisan kulit bumi yang tersusun atas logam silisium dan aluminium disebut lapisan....";
        questions[0][1] = "a. sima";
        questions[0][2] = "b. sial";
        questions[0][3] = "c. beku";
        questions[0][4] = "d. karst";

        questions[1][0] = "Batuan yang menglami perubahan yang dahsyat dinamakan....";
        questions[1][1] = "a. metamorf";
        questions[1][2] = "b. moraine";
        questions[1][3] = "c. andesit";
        questions[1][4] = "d. sedimen";

        questions[2][0] = "Tenaga yang banyak merusak bentuk-bentuk permukaan bumi adalah tenaga....";
        questions[2][1] = "a. alam";
        questions[2][2] = "b. bumi";
        questions[2][3] = "c. matahari";
        questions[2][4] = "d. eksogen";

        questions[3][0] = "Peristiwa yang berhubungan dengan naiknya magma dari dalam perut bumi disebut....";
        questions[3][1] = "a. antikinal";
        questions[3][2] = "b. tektogenesa";
        questions[3][3] = "c. vulkanisme";
        questions[3][4] = "d. diatropisme";

        questions[4][0] = "Memiliki kemiringan 3%-15% merupakan lahan potensial di daerah....";
        questions[4][1] = "a. pantai";
        questions[4][2] = "b. gunung";
        questions[4][3] = "c. dataran rendah";
        questions[4][4] = "d. dataran tinggi";

        questions[5][0] = "Suatu tempat yang dapat mengeluarkan CO2 pada gunung api disebut...";
        questions[5][1] = "a. solfatar";
        questions[5][2] = "b. mofet";
        questions[5][3] = "c. fumarol";
        questions[5][4] = "d. uap air";

        questions[6][0] = "Tipe erupsi yang  bekerja dengan irama tiap lima menit mengeluarkan lava dan bom adalah...";
        questions[6][1] = "a. st. Vincent";
        questions[6][2] = "b. hawaii";
        questions[6][3] = "c. stromboli";
        questions[6][4] = "d. perret";

        questions[7][0] = "Mata air mineral yang biasanya panas adalah..";
        questions[7][1] = "a. solfatar";
        questions[7][2] = "b. mofet";
        questions[7][3] = "c. makdani";
        questions[7][4] = "d. uap air";

        questions[8][0] = "Gerakan tekanan horizontal yang menyebabkan lapisan kulit bumi berkerut disebut....";
        questions[8][1] = "a. lipatan";
        questions[8][2] = "b. patahan";
        questions[8][3] = "c. gulungan";
        questions[8][4] = "d. retakan";

        questions[9][0] = "Pelapukan adalah perusakan karena terpengaruh oleh...";
        questions[9][1] = "a. air, limbah, dan udara";
        questions[9][2] = "b. batuan, organisme, dan bakteri";
        questions[9][3] = "c. tumbuhan, hewan, dan manusia";
        questions[9][4] = "d. temperatur, air, dan organisme";

        answers[0][1] = "b. sial";
        answers[1][1] = "a. metamorf";
        answers[2][1] = "d. eksogen";
        answers[3][1] = "c. vulkanisme";
        answers[4][1] = "c. dataran rendah";
        answers[5][1] = "b. mofet";
        answers[6][1] = "c. stromboli";
        answers[7][1] = "c. makdani";
        answers[8][1] = "a. lipatan";
        answers[9][1] = "d. temperatur, air, dan organisme";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
