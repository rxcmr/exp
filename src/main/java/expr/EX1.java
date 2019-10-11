package expr;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EX1 {
   private JFrame frame = new JFrame();
   private JPanel panel = new JPanel(new BorderLayout());
   private JButton button;
   private static EX1 ex1;

   public static void main(String[] args) {
      ex1 = new EX1();
      ex1.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ex1.panel.setBackground(Color.MAGENTA);
      ex1.panel.setPreferredSize(new Dimension(300, 300));
      ex1.button = new JButton("RED");
      ex1.panel.add(ex1.button, BorderLayout.SOUTH);
      ex1.frame.getContentPane().add(ex1.panel);
      ex1.frame.pack();
      ex1.frame.setVisible(true);
      ex1.button.addActionListener(new Responder(Color.RED));
   }

   private static class Responder implements ActionListener {
      private Color color;
      @Contract(pure = true)
      Responder(Color color) {
         this.color = color;
      }

      @Override
      public void actionPerformed(@NotNull ActionEvent event) {
         if (event.getActionCommand().equals("RED")) ex1.panel.setBackground(color);
      }
   }
}


