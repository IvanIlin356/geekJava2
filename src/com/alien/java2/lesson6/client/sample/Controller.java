package com.alien.java2.lesson6.client.sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private static String userName = "user1";

    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @FXML
    TextArea conversationArea;
    @FXML
    TextArea messageAuthor;
    @FXML
    TextField messageText;

    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    final String IP_ADR = "localhost";
    final int PORT = 8189;

    public void sendMessage(){
        if (!messageText.getText().isEmpty()) {
            //conversationArea.appendText(messageText.getText() + "\n");
            //messageAuthor.appendText(dateFormat.format(new Date()) + " " + userName + "\n");
            try {
                dataOutputStream.writeUTF(messageText.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            messageText.clear();
            messageText.requestFocus();
        }
    }

    public void clearConversation(){
        messageAuthor.clear();
        conversationArea.clear();
        messageText.clear();
        messageText.requestFocus();
    }

    public void exitApplication(){
        System.exit(0);
    }

    public void changeUser(){
        userName = JOptionPane.showInputDialog("Введите новое имя:");
        if (userName.equals("")) userName = "user1";
    }

    public void selectSmile(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("under construction");
        alert.setHeaderText(null);
        alert.setContentText("в разработке");

        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            try {
                socket = new Socket(IP_ADR, PORT);
            } catch (IOException e) {
                e.printStackTrace();
            }

            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            String str = null;
                            str = dataInputStream.readUTF();
                            conversationArea.appendText(str + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
