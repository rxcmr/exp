package expr;

import javax.swing.*;
import java.awt.*;

public class EX1 {
   private JFrame frame = new JFrame();
   private JPanel panel = new JPanel(new BorderLayout());
   private JButton button;

   public static void main(String[] args) {
      EX1 ex1 = new EX1();
      ex1.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ex1.panel.setBackground(Color.MAGENTA);
      ex1.panel.setPreferredSize(new Dimension(300, 300));
      ex1.button = new JButton("RED");
      ex1.panel.add(ex1.button, BorderLayout.SOUTH);
      ex1.frame.getContentPane().add(ex1.panel);
      ex1.frame.pack();
      ex1.frame.setVisible(true);
      ex1.button.addActionListener(ActionListener -> {
         if (ActionListener.getActionCommand().equals("RED")) ex1.panel.setBackground(Color.RED);
      });
   }
}


