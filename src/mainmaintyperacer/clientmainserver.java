/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmaintyperacer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author saloni
 */
public class clientmainserver extends javax.swing.JFrame {

    /**
     * Creates new form clientmain
     */
    Socket sock;
    String username="";
    int a;
    public clientmainserver() {
        
        initComponents();
    }
public clientmainserver(String user,int a)
{  username=user;
  this.a=a;

    initComponents();
    LoggedInAsBox.setText(username);
    TA_conversation.setEditable(false);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoggedInAs = new javax.swing.JLabel();
        LoggedInAsBox = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JLonline = new javax.swing.JList();
        L_online = new javax.swing.JLabel();
        L_Message = new javax.swing.JLabel();
        Tf_message = new javax.swing.JTextField();
        L_conversation = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TA_conversation = new javax.swing.JTextArea();
        send = new javax.swing.JButton();
        JOIN = new javax.swing.JButton();
        start = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        LoggedInAs.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        LoggedInAs.setForeground(new java.awt.Color(255, 255, 255));
        LoggedInAs.setText("LOGGED IN AS -");
        getContentPane().add(LoggedInAs);
        LoggedInAs.setBounds(398, 20, 120, 30);

        LoggedInAsBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LoggedInAsBox.setForeground(new java.awt.Color(51, 204, 0));
        LoggedInAsBox.setText("Username");
        getContentPane().add(LoggedInAsBox);
        LoggedInAsBox.setBounds(430, 50, 70, 14);

        jScrollPane1.setViewportView(JLonline);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(419, 150, 70, 140);

        L_online.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        L_online.setForeground(new java.awt.Color(255, 255, 255));
        L_online.setText("ONLINE USERS");
        getContentPane().add(L_online);
        L_online.setBounds(399, 120, 110, 23);

        L_Message.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Message.setForeground(new java.awt.Color(255, 255, 255));
        L_Message.setText("Message-");
        getContentPane().add(L_Message);
        L_Message.setBounds(19, 15, 60, 15);
        getContentPane().add(Tf_message);
        Tf_message.setBounds(89, 12, 230, 20);

        L_conversation.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        L_conversation.setForeground(new java.awt.Color(255, 255, 255));
        L_conversation.setText("CONVERSATION");
        getContentPane().add(L_conversation);
        L_conversation.setBounds(23, 123, 160, 23);

        TA_conversation.setColumns(20);
        TA_conversation.setRows(5);
        jScrollPane2.setViewportView(TA_conversation);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(23, 148, 198, 141);

        send.setText("SEND");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        getContentPane().add(send);
        send.setBounds(40, 70, 80, 23);

        JOIN.setText("JOIN CHALLENGE");
        JOIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOINActionPerformed(evt);
            }
        });
        getContentPane().add(JOIN);
        JOIN.setBounds(170, 70, 150, 23);

        start.setText("START GAME");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        getContentPane().add(start);
        start.setBounds(260, 180, 120, 23);

        jButton1.setText("LEADERBOARD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 230, 120, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/5069dce6dbd0cb3067000b80._w.540_h.423_s.fit_.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-6, -6, 540, 310);

        setBounds(0, 0, 553, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void JOINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JOINActionPerformed
        // TODO add your handling code here:
        String ip=JOptionPane.showInputDialog("Enter ip of server:");
        
        System.out.println(ip);
        try
        {
        
    
         sock = new Socket(ip, 1000); // 10000 = Port no.
            System.out.println("Connected to server");
             PrintWriter out=new PrintWriter(sock.getOutputStream());
            out.println(username);
            out.flush();
            client1 c=new client1(sock,username);
            Thread X=new Thread(c);
            X.start();
            
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_JOINActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
  int i;
        for(i=0;i<server1.ConnectionArray.size();i++)
        {
            Socket temp=(Socket)server1.ConnectionArray.get(i);
            PrintWriter out = null;
            try {
                out = new PrintWriter(temp.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(server1.class.getName()).log(Level.SEVERE, null, ex);
            }
            //int a=(int)(Math.random()*10);
            out.println("**"+a);
            out.flush();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_startActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        leaderboard x=new leaderboard();
        x.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        PrintWriter ou = null;
        try {
            ou = new PrintWriter(sock.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(clientmain.class.getName()).log(Level.SEVERE, null, ex);
        }
        ou.println(username+" : "+Tf_message.getText());
        ou.flush();
        Tf_message.setText("");
    }//GEN-LAST:event_sendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(clientmainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientmainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientmainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientmainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new clientmainserver().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JList JLonline;
    private javax.swing.JButton JOIN;
    private javax.swing.JLabel L_Message;
    private javax.swing.JLabel L_conversation;
    private javax.swing.JLabel L_online;
    private javax.swing.JLabel LoggedInAs;
    private javax.swing.JLabel LoggedInAsBox;
    public static javax.swing.JTextArea TA_conversation;
    private javax.swing.JTextField Tf_message;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton send;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
