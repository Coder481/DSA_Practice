package z_labWork;

import javafx.scene.control.Alert;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab_5_AWT {

    public static void main(String[] args) {
//        ShowButtonThroughImplement showButton = new ShowButtonThroughImplement();
        new ShowButtonThroughObject();
    }


    static class ShowButtonThroughImplement extends Frame implements ActionListener{

        TextField tf;

        public ShowButtonThroughImplement() {

            setTitle("Button Example by implement Frame");

            tf = new TextField();
            tf.setBounds(100,150,80,30);
            tf.setVisible(false);

            Button b = new Button("Click Me");
            b.setBounds(100,100,80,30); // setting button position
//            b.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setContentText("Button Clicked");
//                    alert.show();
//                }
//            });
            b.addActionListener(this);

            add(b);// adding button into frame
            add(tf);
            setSize(300,300); // frame size 300 width and 300 height
            setLayout(null); // no layout manager
            setVisible(true); // now frame will be visible, by default not visible

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            tf.setText("Welcome");
            tf.setVisible(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Button Clicked");
            alert.show();
        }
    }

    static class ShowButtonThroughObject{
        public ShowButtonThroughObject() {

            Frame f = new Frame("Button Example by Object");

            TextField tf = new TextField();
            tf.setBounds(250,300,80,30);
            tf.setVisible(false);
            Label label = new Label();
            label.setBounds(250,350,80,30);
            label.setVisible(false);

            Button b = new Button("Click Me");
            b.setBounds(250,250,80,30);
            b.addActionListener(e -> {
                tf.setText("Welcome");
                tf.setVisible(true);
                label.setText("Welcome");
                label.setVisible(true);
            });

            f.add(b);
            f.add(tf);
            f.add(label);
            f.setSize(500,500);
            f.setBackground(Color.CYAN);
            f.setLayout(null);
            f.setVisible(true);

        }
    }
}
