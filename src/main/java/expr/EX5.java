package expr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class EX5 {
   private class Responder_1 implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         f1.setVisible(false);
         String username = t1.getText();
         String password = t2.getText();
         EX4 ex4 = new EX4(username, password);
         ex4.parseCSV();
         if (ex4.isPasswordCorrect) {
            f2.setVisible(true);
            if (System.nanoTime() == TimeUnit.NANOSECONDS.toSeconds(20)) {
               // wait 20 seconds then show the 1st frame again
               f2.setVisible(false);
               f1.setVisible(true);
            }
         } else {
            f3.setVisible(true);
         }
      }
   }

   private class Responder_2 implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         f2.setVisible(false);
         f1.setVisible(true);
      }
   }

   private class Responder_3 implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         f3.setVisible(false);
         f1.setVisible(true);
      }
   }

   // Instance variables
   private JFrame f1, f2, f3;
   private JTextField t1, t2;

   private void init() throws Exception {
      // set style to be OS-specific (Windows, macOS, Linux)
      // may throw ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      // declaration and assignment of variables
      this.f1 = new JFrame("Window 1");
      this.f2 = new JFrame("Window 2");
      this.f3 = new JFrame("Window 3");
      JButton
         b1 = new JButton("Submit!"),
         b2 = new JButton("Log in now!"),
         b3 = new JButton("Oh fuck go back!");
      JPanel
         form = new JPanel(),
         p1 = new JPanel(),
         p2 = new JPanel(),
         p3 = new JPanel(),
         p4 = new JPanel();
      JLabel
         l1 = new JLabel("Username: "),
         l2 = new JLabel("Password: "),
         l3 = new JLabel("Logged in.", SwingConstants.CENTER),
         l4 = new JLabel("Incorrect username or password.", SwingConstants.CENTER);
      this.t1 = new JTextField(40);
      this.t2 = new JTextField(40);

      // 1st Frame
      form.setBackground(Color.orange);
      p1.setBackground(Color.orange);
      p2.setBackground(Color.orange);
      l1.setBackground(Color.black);
      l2.setBackground(Color.black);
      p1.add(l1);
      p1.add(this.t1);
      p2.add(l2);
      p2.add(this.t2);
      form.setLayout(new GridLayout(3, 1));
      form.add(p1);
      form.add(p2);
      form.add(b1);
      b1.addActionListener(new Responder_1());
      this.f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.f1.setContentPane(form);
      this.f1.pack();
      this.f1.setResizable(false);
      this.f1.setVisible(true);
      // 2nd Frame
      p3.setBackground(Color.orange);
      p3.setPreferredSize(new Dimension(300, 35));
      l3.setSize(15, 0);
      p3.add(l3);
      b2.addActionListener(new Responder_2());
      p3.add(b2);
      f2.setContentPane(p3);
      f2.pack();
      f2.setVisible(false);
      f2.setResizable(false);
      // 3rd frame
      p4.setBackground(Color.orange);
      p4.setPreferredSize(new Dimension(300, 35));
      l4.setSize(15, 0);
      p4.add(l4);
      b3.addActionListener(new Responder_3());
      p4.add(b3);
      f3.setContentPane(p4);
      f3.pack();
      f3.setVisible(false);
      f3.setResizable(false);
   }

   public static void main(String[] args) throws Exception {
      EX5 ex5 = new EX5();
      ex5.init();
   }
}
