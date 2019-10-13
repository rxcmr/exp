package expr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class EX3 {
   private class Responder_1 implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         f1.setVisible(false);
         f2.setVisible(true);
         String s1 = t1.getText();
         String s2 = t2.getText();
         LinkedList<String> list = new LinkedList<>();
         list.add(s1);
         list.add(s2);
         System.out.println(list);
         if (System.nanoTime() == TimeUnit.NANOSECONDS.toSeconds(20)) {
            // wait 20 seconds then show the 1st frame again
            f2.setVisible(false);
            f1.setVisible(true);
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

   // Instance variables
   private JFrame f1, f2;
   private JTextField t1, t2;

   private void init() throws Exception {
      // set style to be OS-specific (Windows, macOS, Linux)
      // may throw ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      // declaration and assignment of variables
      this.f1 = new JFrame("Window 1");
      this.f2 = new JFrame("Window 2");
      JButton
         b1 = new JButton("Click!"),
         b2 = new JButton("Click!");
      JPanel
         form = new JPanel(),
         p1 = new JPanel(),
         p2 = new JPanel(),
         p3 = new JPanel();
      JLabel
         l1 = new JLabel("Input: "),
         l2 = new JLabel("Input: "),
         l3 = new JLabel("Please wait...", SwingConstants.CENTER);
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
      b2.addActionListener(new Responder_2());
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
      p3.add(b2);
      f2.setContentPane(p3);
      f2.pack();
      f2.setVisible(false);
      f2.setResizable(false);
   }

   // throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException
   public static void main(String[] args) throws Exception {
      // nothing to see here...
      EX3 ex3 = new EX3();
      ex3.init();
   }
}

