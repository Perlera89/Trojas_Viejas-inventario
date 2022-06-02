package com.trojasviejas.data;

import com.trojasviejas.models.entity.MessageModel;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SendMail {
    public MessageModel sendMail(String toEmail, String code) {
        MessageModel ms = new MessageModel(false, "");
        String from = "trojasviejas.inventario@gmail.com";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        String username = "tp0714032020@unab.edu.sv";
        String password = "boku no hero";    //  Aqui va la contraseña del correo
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Verificación de codigo");
            message.setText("Codigo para poder registrarse en la aplicación Trojas Viejas Inventory \n"+code);
            Transport.send(message);
            ms.setSuccess(true);
        } catch (MessagingException e) {
            if (e.getMessage().equals("Invalid Addresses")) {
                ms.setMessage("Correo Invalido");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println(e.getMessage());
            }
        }
        return ms;
    }
}
