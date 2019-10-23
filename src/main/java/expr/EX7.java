package expr;

import javax.swing.*;

public class EX7 {
   private EX6 ex6 = EX6 -> System.out.println("Hi!") ;

   public static void main(String[] args) {
      JFrame f = new JFrame();
      JPanel p = new JPanel();
      JButton b = new JButton();
      b.addActionListener(EX6 -> System.out.println("Hey!"));
      p.add(b);
      f.setContentPane(p);
      f.pack();
      f.setVisible(true);
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   }
}
