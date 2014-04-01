/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dr;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static dr.Utils.*;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Gabriel Budau
 */
public class Interface extends javax.swing.JFrame {

    JFileChooser fc = new JFileChooser();
    File file;

    public Interface() {
        initComponents();
        setLocationRelativeTo(null);
        setButtonsIcons();
        
        stepbystep_Btn.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        load_Btn = new javax.swing.JButton();
        detect_Btn = new javax.swing.JButton();
        stepbystep_Btn = new javax.swing.JButton();
        exit_Btn = new javax.swing.JButton();
        image_Pnl = new javax.swing.JPanel();
        loadImage_Lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 800));

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setRollover(true);

        load_Btn.setToolTipText("Load Image");
        load_Btn.setFocusable(false);
        load_Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        load_Btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        load_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_BtnActionPerformed(evt);
            }
        });
        jToolBar1.add(load_Btn);

        detect_Btn.setToolTipText("Face Detection");
        detect_Btn.setFocusable(false);
        detect_Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        detect_Btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        detect_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detect_BtnMouseClicked(evt);
            }
        });
        detect_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detect_BtnActionPerformed(evt);
            }
        });
        jToolBar1.add(detect_Btn);

        stepbystep_Btn.setToolTipText("Step By Step Detection");
        stepbystep_Btn.setFocusable(false);
        stepbystep_Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stepbystep_Btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(stepbystep_Btn);

        exit_Btn.setToolTipText("Exit Application");
        exit_Btn.setFocusable(false);
        exit_Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exit_Btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exit_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_BtnMouseClicked(evt);
            }
        });
        jToolBar1.add(exit_Btn);

        image_Pnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout image_PnlLayout = new javax.swing.GroupLayout(image_Pnl);
        image_Pnl.setLayout(image_PnlLayout);
        image_PnlLayout.setHorizontalGroup(
            image_PnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(image_PnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadImage_Lbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        image_PnlLayout.setVerticalGroup(
            image_PnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(image_PnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadImage_Lbl)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(image_Pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(image_Pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void load_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_BtnActionPerformed

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setCurrentDirectory(new File ("src//dr//"));
        int returnVal = fc.showOpenDialog(Interface.this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println(file.getAbsolutePath());
            
            BufferedImage i;
            try {
                i = ImageIO.read(file);
                //Image scaledImage = i.getScaledInstance(image_Pnl.getWidth(),image_Pnl.getHeight(),Image.SCALE_FAST);
                loadImage_Lbl.setIcon(new ImageIcon(i));
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
            fc.setCurrentDirectory(file);
        } else {
            file = null;
        }

    }//GEN-LAST:event_load_BtnActionPerformed

    private void detect_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detect_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detect_BtnActionPerformed

    private void detect_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detect_BtnMouseClicked

        if (file != null) {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            System.out.println("\nRunning FaceDetector");

            CascadeClassifier faceDetector = new CascadeClassifier("src//dr//haarcascade_frontalface_alt.xml");
            
            Mat image = Highgui.imread(file.getAbsolutePath());
            
            MatOfRect faceDetections = new MatOfRect();
            
            faceDetector.detectMultiScale(image, faceDetections);

            System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

            for (Rect rect : faceDetections.toArray()) {
                Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                        new Scalar(0, 255, 0));
            }

            String filename = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\")) + "\\out.png";

            System.out.println(String.format("Writing %s", filename));
            Highgui.imwrite(filename, image);
            //This is where a real application would open the file.
            BufferedImage i;
            try {
                i = ImageIO.read(new File(filename));
                //Image scaledImage = i.getScaledInstance(image_Pnl.getWidth(),image_Pnl.getHeight(),Image.SCALE_SMOOTH);
                loadImage_Lbl.setIcon(new ImageIcon(i));
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_detect_BtnMouseClicked

    private void exit_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_BtnMouseClicked
       this.setVisible(false);
       System.exit(0);
    }//GEN-LAST:event_exit_BtnMouseClicked

    private void setButtonsIcons() {
        if (BUTTON_IMAGE_LOAD != null) {
            load_Btn.setIcon(new ImageIcon(BUTTON_IMAGE_LOAD, "LOAD"));
        } else {
            load_Btn.setText("LOAD");
            System.err.println("Resource not found: " + BUTTON_IMAGE_LOAD);
        }
        if (BUTTON_IMAGE_EXIT != null) {
            exit_Btn.setIcon(new ImageIcon(BUTTON_IMAGE_EXIT, "EXIT"));
        } else {
            exit_Btn.setText("EXIT");
            System.err.println("Resource not found: " + BUTTON_IMAGE_EXIT);
        }
        if (BUTTON_IMAGE_DETECT != null) {
            detect_Btn.setIcon(new ImageIcon(BUTTON_IMAGE_DETECT, "DETECT"));
        } else {
            detect_Btn.setText("DETECT");
            System.err.println("Resource not found: " + BUTTON_IMAGE_DETECT);
        }
        if (BUTTON_IMAGE_STEP_BY_STEP != null) {
            stepbystep_Btn.setIcon(new ImageIcon(BUTTON_IMAGE_STEP_BY_STEP, "STEP BY STEP"));
        } else {
            stepbystep_Btn.setText("STEP BY STEP");
            System.err.println("Resource not found: " + BUTTON_IMAGE_STEP_BY_STEP);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton detect_Btn;
    public javax.swing.JButton exit_Btn;
    public javax.swing.JPanel image_Pnl;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JLabel loadImage_Lbl;
    public javax.swing.JButton load_Btn;
    public javax.swing.JButton stepbystep_Btn;
    // End of variables declaration//GEN-END:variables
}
