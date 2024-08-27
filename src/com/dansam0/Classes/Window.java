package com.dansam0.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Window extends JFrame {

    JTextField text_field;
    JTextField output_field;
    Random random = new Random();
    OlegTexts olegTexts = new OlegTexts();

    public Window(){

        super("Olegenator 3000");
        super.setBounds(400,400,500, 200);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("egg.png"))));

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(3, 2, 20,20));

        JLabel description = new JLabel("Type text to oleg it:");
        text_field = new JTextField("", 1);
        JLabel result = new JLabel("There will be oleg:");
        output_field = new JTextField("", 1);
        JButton send_button = new JButton("Olegenate");
        JButton copy_button = new JButton("Copy");

        container.add(description);
        container.add(text_field);
        container.add(result);
        container.add(output_field);
        container.add(send_button);
        container.add(copy_button);

        send_button.addActionListener(new ButtonEvent());
        copy_button.addActionListener(new CopyText());

    }

    class ButtonEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try{

                if(text_field.getText().contains("олег")){
                    throw new OlegException("Блять он олег");
                }

            } catch (Exception exc){
                text_field.setText("Ну ты сам то Олег");
                System.out.println(exc);

            }

            String[] textArray = text_field.getText().split(" ");
            StringBuilder finalText = new StringBuilder();

            if(text_field.getText().contains(" ")){

                for(int i = 0; i < textArray.length; i++){

                    StringBuilder currentText = new StringBuilder();
                    for(Method method : olegTexts.getClass().getDeclaredMethods())
                    {
                        if(method.isAnnotationPresent(ReflectOleg.class)){
                            ReflectOleg reflectOleg = method.getAnnotation(ReflectOleg.class);
                            for(int j = 0; j < reflectOleg.repeat(); j++) {
                                try {
                                    currentText.append(" ").append(method.invoke(olegTexts, random.nextInt(olegTexts.getOlegTextsSize()))).append(" ");
                                } catch (IllegalAccessException | InvocationTargetException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                    }

                    finalText.append(textArray[i] += random.nextBoolean() ? currentText : " ");

                }

                output_field.setText(finalText.toString());

            } else {

                output_field.setText(text_field.getText() + " " + olegTexts.getOlegTexts(random.nextInt(olegTexts.getOlegTextsSize())));

            }

        }
    }

    class CopyText implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StringSelection stringSelection = new StringSelection(output_field.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }

}
