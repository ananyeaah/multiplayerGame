/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmaintyperacer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saloni
 */
public class server1 extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form server1
     */
    public static ArrayList<Socket> ConnectionArray=new ArrayList<Socket>();
    public static ArrayList<String> CurrentUsers=new ArrayList<String>();
    public static ArrayList<String> leader=new ArrayList<String>();
    public server1(int x)
    {
        
    }
    public server1() {
        String ar[]={"abc","cdf"};
        
       initComponents();
        //main(ar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startgame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startgame.setText("START GAME");
        startgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startgameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(startgame)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(startgame)
                .addGap(0, 277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startgameActionPerformed
        // TODO add your handling code here:
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
            int a=(int)(Math.random()*10);
            out.println("**"+a);
            out.flush();
        }
    }//GEN-LAST:event_startgameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String ar[]) {
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
            java.util.logging.Logger.getLogger(server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
       // server1 obj1=new server1(6);
      //obj1.showframe();
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new server1().setVisible(true);
            }
        });
    }
    /*void showframe()
    {
          this.setVisible(true);
      
    }*/
    public static void AddUserName(Socket x) throws Exception
    {
        
        Scanner input=new Scanner(x.getInputStream());
        String username=input.nextLine();
        CurrentUsers.add(username);
  System.out.println(CurrentUsers);
        int i;
        for(i=0;i<server1.ConnectionArray.size();i++)
        {
            Socket temp=(Socket)server1.ConnectionArray.get(i);
            PrintWriter out=new PrintWriter(temp.getOutputStream());
            out.println("!!"+CurrentUsers);
            out.flush();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton startgame;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet.");
    //clientmain ob=new clientmain();
        try
        {
            final int port=1000;
            ServerSocket ser=new ServerSocket(port);
            System.out.println("Waiting for clients");
            while(true)
            {
                Socket sock=ser.accept();
                ConnectionArray.add(sock);
                System.out.println("Client connected from"+sock.getLocalAddress().getHostName());
                AddUserName(sock);
                chat c=new chat(sock);
          System.out.println("bj,kj");      
                Thread X=new Thread(c);
                X.start();
            
        
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
    }
}
