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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Gabriel Budau
 */
public class Interface extends javax.swing.JFrame {
    Settings_Frame sf =  null;
    Settings_Frame sf_eye = null;
    JFileChooser fc = new JFileChooser();
    File file;
    BufferedImage current_image = null;
    String HAAR_FILE_PATH = "src//dr//haarcascade_frontalface_alt2.xml";
    public static int WIDTH = 694;
    public static int HEIGHT = 385;

    double scale = 1.1;
    int minN = 5;
    Size min = new Size(10, 10);
    Size max = new Size();
    
    
    double e_scale = 1.1;
    int e_minN = 5;
    Size e_min = new Size(10, 10);
    Size e_max = new Size();
    
    public Interface() {
        initComponents();
        //setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setButtonsIcons();
        haar_file_label.setText(HAAR_FILE_PATH.substring(HAAR_FILE_PATH.lastIndexOf("/") + 1));
        stepbystep_Btn.setVisible(false);
    }

    public static Image resize_image(BufferedImage i) {
        double currW = i.getWidth();
        double currH = i.getHeight();
        double ratio = currH / currW;
        if (currW > WIDTH) {
            ratio = WIDTH / currW;
            currW = currW * ratio;
            currH = currH * ratio;
        }
        if (currH > HEIGHT) {
            ratio = HEIGHT / currH;
            currH = currH * ratio;
            currW = currW * ratio;
        }

        return i.getScaledInstance((int) currW, (int) currH, Image.SCALE_SMOOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        load_Btn = new javax.swing.JButton();
        detect_Btn = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        stepbystep_Btn = new javax.swing.JButton();
        change_haar = new javax.swing.JButton();
        exit_Btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        haar_file_label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        eye_detection = new javax.swing.JCheckBox();
        current_file = new javax.swing.JLabel();
        eye_calibration = new javax.swing.JButton();
        image_Pnl = new javax.swing.JPanel();
        loadImage_Lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 800));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

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

        settings.setFocusable(false);
        settings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        settings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });
        jToolBar1.add(settings);

        stepbystep_Btn.setToolTipText("Step By Step Detection");
        stepbystep_Btn.setFocusable(false);
        stepbystep_Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stepbystep_Btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        stepbystep_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepbystep_BtnActionPerformed(evt);
            }
        });
        jToolBar1.add(stepbystep_Btn);

        change_haar.setFocusable(false);
        change_haar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        change_haar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        change_haar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_haarActionPerformed(evt);
            }
        });
        jToolBar1.add(change_haar);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Clasificatorul Haar curent:");

        haar_file_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Fisierul de test:");

        eye_detection.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        eye_detection.setText("Detectare ochi  ");

        current_file.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        eye_calibration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eye_calibrationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(current_file))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(eye_detection)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eye_calibration, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(haar_file_label)))
                .addContainerGap(537, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(haar_file_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eye_detection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eye_calibration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(current_file))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        image_Pnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout image_PnlLayout = new javax.swing.GroupLayout(image_Pnl);
        image_Pnl.setLayout(image_PnlLayout);
        image_PnlLayout.setHorizontalGroup(
            image_PnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(image_PnlLayout.createSequentialGroup()
                .addComponent(loadImage_Lbl)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        image_PnlLayout.setVerticalGroup(
            image_PnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(image_PnlLayout.createSequentialGroup()
                .addComponent(loadImage_Lbl)
                .addGap(0, 377, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(image_Pnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(image_Pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void load_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_BtnActionPerformed

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setCurrentDirectory(new File("src//dr//"));
        int returnVal = fc.showOpenDialog(Interface.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            
            current_file.setText(file.getName());
            BufferedImage i;
            try {
                i = ImageIO.read(file);
                current_image = i;
                loadImage_Lbl.setIcon(new ImageIcon(resize_image(i)));
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
            
            CascadeClassifier faceDetector = new CascadeClassifier(HAAR_FILE_PATH);
            CascadeClassifier eyeDetector = new CascadeClassifier("src//dr//haarcascade_eye.xml");
            
            Mat image = Highgui.imread(file.getAbsolutePath());
            MatOfRect faceDetections = new MatOfRect();
            MatOfRect eyeDetections = new MatOfRect();
            
            faceDetector.detectMultiScale(image, faceDetections, scale, minN, 0, min, max);
            
            for (Rect rect : faceDetections.toArray()) {
                Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                        new Scalar(0, 255, 0));
            }
            if (eye_detection.isSelected()) {
                
                eyeDetector.detectMultiScale(image, eyeDetections, e_scale, e_minN, 0, e_min, e_max);
                for (Rect rect : eyeDetections.toArray()) {
                    Core.circle(image, new Point(rect.x + rect.width / 2, rect.y + rect.width / 2), rect.width / 2, new Scalar(255, 0, 255));
                    Core.circle(image, new Point(rect.x + rect.width / 2, rect.y + rect.width / 2), rect.width / 2 + 1, new Scalar(255, 0, 255));
                    Core.circle(image, new Point(rect.x + rect.width / 2, rect.y + rect.width / 2), rect.width / 2 + 1, new Scalar(255, 0, 255));
                }
            }
            String filename = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\")) + "\\out.png";
            Highgui.imwrite(filename, image);
            BufferedImage i;
            try {
                if ((i = ImageIO.read(new File(filename))) != null) {
                    current_image = i;
                    loadImage_Lbl.setIcon(new ImageIcon(resize_image(i)));
                } else {
                    JOptionPane.showMessageDialog(this, "Nu s-a detectat nimic!", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_detect_BtnMouseClicked

    private void exit_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_BtnMouseClicked
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_exit_BtnMouseClicked

    private void stepbystep_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepbystep_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stepbystep_BtnActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        image_Pnl.revalidate();
        WIDTH = image_Pnl.getSize().width;
        HEIGHT = image_Pnl.getSize().height;
        if (current_image != null) {
            loadImage_Lbl.setIcon(new ImageIcon(resize_image(current_image)));
        }
    }//GEN-LAST:event_formComponentResized

    private void change_haarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_haarActionPerformed
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setCurrentDirectory(new File("src//dr//"));
        int returnVal = fc.showOpenDialog(Interface.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            HAAR_FILE_PATH = fc.getSelectedFile().getAbsolutePath();
            haar_file_label.setText(fc.getSelectedFile().getName());
        }
    }//GEN-LAST:event_change_haarActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        sf = new Settings_Frame();
        
        sf.resize_factor.setText("" + scale);
        sf.minneighbours.setText("" + this.minN);
        sf.minSize_w.setText("" + this.min.width);
        sf.minSize_h.setText("" + this.min.height);
        sf.maxSize_w.setText("" + this.max.width);
        sf.maxSize_h.setText("" + this.max.height);
        sf.setVisible(true);
        sf.setLocationRelativeTo(this);
        sf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                sf.setVisible(false);
                sf.dispose();
            }
        });
        sf.cancel_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                sf.dispatchEvent(new WindowEvent(sf, WindowEvent.WINDOW_CLOSING));
            }
        });
        sf.ok_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Double.parseDouble(sf.resize_factor.getText());
                    Double.parseDouble(sf.minneighbours.getText());
                    Double.parseDouble(sf.minSize_w.getText());
                    Double.parseDouble(sf.minSize_h.getText());
                } catch (NumberFormatException | NullPointerException ex) {
                    return;
                }
                
                try{
                     max = new Size((int) Double.parseDouble(sf.maxSize_w.getText()),
                        (int) Double.parseDouble(sf.maxSize_h.getText()));
                }catch(Exception ex){
                    max = new Size();
                }
                scale = Double.parseDouble(sf.resize_factor.getText());
                minN = (int) Double.parseDouble(sf.minneighbours.getText());
                min = new Size((int) Double.parseDouble(sf.minSize_w.getText()),
                        (int) Double.parseDouble(sf.minSize_h.getText()));
                sf.dispatchEvent(new WindowEvent(sf, WindowEvent.WINDOW_CLOSING));
            }
        });
    }//GEN-LAST:event_settingsActionPerformed

    private void eye_calibrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eye_calibrationActionPerformed
        sf_eye = new Settings_Frame();
        
        sf_eye.resize_factor.setText("" + e_scale);
        sf_eye.minneighbours.setText("" + this.e_minN);
        sf_eye.minSize_w.setText("" + this.e_min.width);
        sf_eye.minSize_h.setText("" + this.e_min.height);
        sf_eye.maxSize_w.setText("" + this.e_max.width);
        sf_eye.maxSize_h.setText("" + this.e_max.height);
        sf_eye.setVisible(true);
        sf_eye.setLocationRelativeTo(this);
        sf_eye.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                sf_eye.setVisible(false);
                sf_eye.dispose();
            }
        });
        sf_eye.cancel_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                sf_eye.dispatchEvent(new WindowEvent(sf_eye, WindowEvent.WINDOW_CLOSING));
            }
        });
        sf_eye.ok_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Double.parseDouble(sf_eye.resize_factor.getText());
                    Double.parseDouble(sf_eye.minneighbours.getText());
                    Double.parseDouble(sf_eye.minSize_w.getText());
                    Double.parseDouble(sf_eye.minSize_h.getText());
                } catch (NumberFormatException | NullPointerException ex) {
                    return;
                }
                try{
                    e_max = new Size((int) Double.parseDouble(sf_eye.maxSize_w.getText()),
                        (int) Double.parseDouble(sf_eye.maxSize_h.getText()));
                }catch(Exception ex){
                    e_max = new Size();
                }
                e_scale = Double.parseDouble(sf_eye.resize_factor.getText());
                e_minN = (int) Double.parseDouble(sf_eye.minneighbours.getText());
                e_min = new Size((int) Double.parseDouble(sf_eye.minSize_w.getText()),
                        (int) Double.parseDouble(sf_eye.minSize_h.getText()));
                sf_eye.dispatchEvent(new WindowEvent(sf_eye, WindowEvent.WINDOW_CLOSING));
            }
        });
    }//GEN-LAST:event_eye_calibrationActionPerformed

    private void setButtonsIcons() {
        if (BUTTON_IMAGE_LOAD != null) {
            load_Btn.setIcon(new ImageIcon(BUTTON_IMAGE_LOAD, "Incarca Imagine"));
        } else {
            load_Btn.setText("Incarca Imagine");
            System.err.println("Resource not found: " + BUTTON_IMAGE_LOAD);
        }
        if (BUTTON_IMAGE_EXIT != null) {
            exit_Btn.setIcon(new ImageIcon(BUTTON_IMAGE_EXIT, "Iesire"));
        } else {
            exit_Btn.setText("Iesire");
            System.err.println("Resource not found: " + BUTTON_IMAGE_EXIT);
        }
        if (BUTTON_IMAGE_DETECT != null) {
            detect_Btn.setIcon(new ImageIcon(BUTTON_IMAGE_DETECT, "Detecteaza"));
        } else {
            detect_Btn.setText("Detecteaza");
            System.err.println("Resource not found: " + BUTTON_IMAGE_DETECT);
        }
        if (BUTTON_IMAGE_STEP_BY_STEP != null) {
            stepbystep_Btn.setIcon(new ImageIcon(BUTTON_IMAGE_STEP_BY_STEP, "Pas cu pas"));
        } else {
            stepbystep_Btn.setText("Pas cu pas");
            System.err.println("Resource not found: " + BUTTON_IMAGE_STEP_BY_STEP);
        }
        if (BUTTON_IMAGE_CHANGE_HAAR != null) {
            change_haar.setIcon(new ImageIcon(BUTTON_IMAGE_CHANGE_HAAR, "Schimba clasificatorul"));
        } else {
            change_haar.setText("Schimba clasificatorul");
            System.err.println("Resource not found: " + BUTTON_IMAGE_CHANGE_HAAR);
        }
        if (BUTTON_IMAGE_CHANGE_SETTINGS != null) {
            settings.setIcon(new ImageIcon(BUTTON_IMAGE_CHANGE_SETTINGS, "Setari"));
        } else {
            settings.setText("Setari");
            System.err.println("Resource not found: " + BUTTON_IMAGE_CHANGE_SETTINGS);
        }
        
        if (BUTTON_IMAGE_CHANGE_SETTINGS_eye != null) {
            eye_calibration.setIcon(new ImageIcon(BUTTON_IMAGE_CHANGE_SETTINGS_eye, "Calibrare Ochi"));
        } else {
            eye_calibration.setText("Calibrare Ochi");
            System.err.println("Resource not found: " + BUTTON_IMAGE_CHANGE_SETTINGS_eye);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton change_haar;
    private javax.swing.JLabel current_file;
    public javax.swing.JButton detect_Btn;
    public javax.swing.JButton exit_Btn;
    private javax.swing.JButton eye_calibration;
    private javax.swing.JCheckBox eye_detection;
    private javax.swing.JLabel haar_file_label;
    public javax.swing.JPanel image_Pnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JLabel loadImage_Lbl;
    public javax.swing.JButton load_Btn;
    private javax.swing.JButton settings;
    public javax.swing.JButton stepbystep_Btn;
    // End of variables declaration//GEN-END:variables
}
