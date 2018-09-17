package gui;

import core.FrameRateSelector;
import core.LoadFileChooser;
import static core.LoadFileChooser.file;
import core.SaveFileChooser;
import core.TimeSelector;
import core.config.RecordConfig;
import core.recorder.DurationSelector;
import core.recorder.ScreenRecorder2;
import core.recorder.ScreenRecorder_h265;
import core.recorder.ScreenRecorder_stream;
import core.recorder.ScreenRecorder_openload;
import core.recorder.ScreenRecorder_xtubeth;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import main.player01_deletesheet;
import main.player01_remove_empty02;
import main.player01_sorting;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import selenium.h265;
import selenium.openload;
import selenium.openload_sorry;
import selenium.openload_new;
import selenium.tvb;
import selenium.tvb1;
import selenium.stream;
import xuggler.videoInfo;
import youtube.ClearVideo;
import youtube.UploadVideo;
import youtube.check_myuploads1;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import main.player01_excel05;
import main.player01_excel06;
import org.sikuli.script.Screen;
import selenium.xtubeth;
import youtube.UploadVideo2;
import youtube.check_myuploads2;

// this class provies implimentation for the record controller panel
public class RecordControlPanel extends javax.swing.JPanel {
    // the local record config reference object

    private RecordConfig recConfig = null;
    // the record image image
    private ImageIcon record = null;
    // the recording image icon
    private ImageIcon recording = null;
    private boolean isChecking = false;

    // is recording flag
    private boolean isRecording = false;
    private boolean isUploading = false;
    // the screen recorder object
    private ScreenRecorder2 screenRecorder2 = null;
    private ScreenRecorder_h265 screenRecorder_h265 = null;
    private ScreenRecorder_openload screenRecorder_openload = null;
    private ScreenRecorder_xtubeth screenRecorder_xtubeth = null;
    private ScreenRecorder_stream screenRecorder_stream = null;

    private videoInfo videoInfo = null;
    private player01_excel05 player01_excel05 = null;
    private player01_excel06 player01_excel06 = null;
    private player01_sorting player01_sorting = null;
    private player01_deletesheet player01_deletesheet = null;
    public static boolean autopress = false;
    private UploadVideo UploadVideo = null;

    // the default constructor
    public RecordControlPanel() {
        initComponents();
    }

    // constructor with the record config parameter
    public RecordControlPanel(RecordConfig rc) {
        // initilise components
        initComponents();
        // set the record config refernce
        this.recConfig = rc;
        // load record icons
        loadRecordIcons();
        // create a new screen recorder object

        screenRecorder2 = new ScreenRecorder2();
        screenRecorder_h265 = new ScreenRecorder_h265();
        screenRecorder_openload = new ScreenRecorder_openload();
        screenRecorder_xtubeth = new ScreenRecorder_xtubeth();
        screenRecorder_stream = new ScreenRecorder_stream();

        videoInfo = new videoInfo();
        player01_excel05 = new player01_excel05();
        player01_excel06 = new player01_excel06();
        player01_sorting = new player01_sorting();
        player01_deletesheet = new player01_deletesheet();
    }

    // load the recor icons from the jar resource package
    private void loadRecordIcons() {
        record = new javax.swing.ImageIcon(getClass().getResource("/gui/resources/record.png"));
        recording = new javax.swing.ImageIcon(getClass().getResource("/gui/resources/recording.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recordButtonLabel = new javax.swing.JLabel();
        frameRateButtonLabel = new javax.swing.JLabel();
        captureAreaButtonLabel = new javax.swing.JLabel();
        saveButtonLabel = new javax.swing.JLabel();
        DurationButtonLabel = new javax.swing.JLabel();
        uploadButtonLabel = new javax.swing.JLabel();
        extractButtonLabel = new javax.swing.JLabel();
        clearButtonLabel = new javax.swing.JLabel();
        TimeButtonLabel = new javax.swing.JLabel();
        capture_xtubethButtonLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        capture_h265ButtonLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        autorunButtonLabel = new javax.swing.JLabel();
        capture_openloadButtonLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        capture_streamButtonLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        autorunButtonLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Record Controls"));

        recordButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/record.png"))); // NOI18N
        recordButtonLabel.setToolTipText("start/stop recording");
        recordButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recordButton_MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recordButton_MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                recordButton_MousePressedEvent(evt);
            }
        });

        frameRateButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/fps.png"))); // NOI18N
        frameRateButtonLabel.setToolTipText("set frame rate");
        frameRateButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                frameRateButton_MousePressedEvent(evt);
            }
        });

        captureAreaButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/screen.png"))); // NOI18N
        captureAreaButtonLabel.setToolTipText("select capture area");
        captureAreaButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                captureAreaButton_MousePressedEvent(evt);
            }
        });

        saveButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/save.png"))); // NOI18N
        saveButtonLabel.setToolTipText("select save location");
        saveButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveButton_MousePressedEvent(evt);
            }
        });

        DurationButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/wait2.png"))); // NOI18N
        DurationButtonLabel.setToolTipText("set duration");
        DurationButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DurationButtonLabelframeRateButton_MousePressedEvent(evt);
            }
        });

        uploadButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/upload.png"))); // NOI18N
        uploadButtonLabel.setToolTipText("Upload video to Youtube");
        uploadButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                uploadButtonLabelauto1Button_MousePressedEvent(evt);
            }
        });

        extractButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/data1.png"))); // NOI18N
        extractButtonLabel.setToolTipText("Check Youtube status");
        extractButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                extractButtonLabelauto1Button_MousePressedEvent(evt);
            }
        });

        clearButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/rubbish.png"))); // NOI18N
        clearButtonLabel.setToolTipText("Clear");
        clearButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearButtonLabelauto1Button_MousePressedEvent(evt);
            }
        });

        TimeButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/clock.png"))); // NOI18N
        TimeButtonLabel.setToolTipText("set time to start");
        TimeButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TimeButtonLabelframeRateButton_MousePressedEvent(evt);
            }
        });

        capture_xtubethButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/screen.png"))); // NOI18N
        capture_xtubethButtonLabel.setToolTipText("select capture area for xtubeth");
        capture_xtubethButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                capture_xtubethButtonLabelcaptureAreaButton_MousePressedEvent(evt);
            }
        });

        jLabel5.setText("xtubeth");

        capture_h265ButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/screen.png"))); // NOI18N
        capture_h265ButtonLabel.setToolTipText("select capture area for h265");
        capture_h265ButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                capture_h265ButtonLabelcaptureAreaButton_MousePressedEvent(evt);
            }
        });

        jLabel9.setText("h265");

        autorunButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/excel.png"))); // NOI18N
        autorunButtonLabel.setToolTipText("autorun(with Youtube upload - end)");
        autorunButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                autorun_MousePressedEvent(evt);
            }
        });

        capture_openloadButtonLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/screen.png"))); // NOI18N
        capture_openloadButtonLabel1.setToolTipText("select capture area for openload");
        capture_openloadButtonLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                capture_openloadButtonLabel1captureAreaButton_MousePressedEvent(evt);
            }
        });

        jLabel10.setText("openload");

        capture_streamButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/screen.png"))); // NOI18N
        capture_streamButtonLabel.setToolTipText("select capture area for stream");
        capture_streamButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                capture_streamButtonLabelcaptureAreaButton_MousePressedEvent(evt);
            }
        });

        jLabel11.setText("stream");

        autorunButtonLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/excel.png"))); // NOI18N
        autorunButtonLabel1.setToolTipText("autorun(no Youtube)");
        autorunButtonLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                autorun1_MousePressedEvent(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(capture_h265ButtonLabel)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(capture_xtubethButtonLabel)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(capture_streamButtonLabel)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(capture_openloadButtonLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(recordButtonLabel)
                                .addGap(18, 18, 18)
                                .addComponent(frameRateButtonLabel)
                                .addGap(18, 18, 18)
                                .addComponent(TimeButtonLabel)
                                .addGap(18, 18, 18)
                                .addComponent(saveButtonLabel)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(captureAreaButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DurationButtonLabel)
                        .addGap(24, 24, 24)
                        .addComponent(autorunButtonLabel)
                        .addGap(20, 20, 20)
                        .addComponent(autorunButtonLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(uploadButtonLabel)
                        .addGap(20, 20, 20)
                        .addComponent(extractButtonLabel)
                        .addGap(20, 20, 20)
                        .addComponent(clearButtonLabel)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(captureAreaButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DurationButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uploadButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(extractButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autorunButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autorunButtonLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel9))
                            .addGap(0, 0, 0)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(capture_xtubethButtonLabel)
                                .addComponent(capture_h265ButtonLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10))
                            .addGap(0, 0, 0)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(capture_streamButtonLabel)
                                .addComponent(capture_openloadButtonLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(recordButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(frameRateButtonLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TimeButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        autorunButtonLabel1.getAccessibleContext().setAccessibleDescription("autorun(no Youtube)");
    }// </editor-fold>//GEN-END:initComponents

    // method called when record button is pressed
    private void recordButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordButton_MousePressedEvent
        // TODO add your handling code here:
        // check whether the record config is set for recording
        if (isReadyForRecording()) {
            // if its not recording then
            if (!isRecording) {
                // set recording flag as true
                isRecording = true;
                // set the button lable icon to recording
                recordButtonLabel.setIcon(recording);

                try {
                    // start recording
                    //screenRecorder1.startRecording(recConfig);
                    screenRecorder2.startRecording(recConfig);
                } catch (Exception ex) {
                    // notify user about any exception on recording
                    JOptionPane.showMessageDialog(saveButtonLabel, "Cannot record for the given configuration!\nError Info:\n" + ex, "Processor Error", JOptionPane.ERROR_MESSAGE);
                }
            } // else if currently recording then
            else {
                // set the recording flag to false
                isRecording = false;
                // reset the recording button lable to record
                recordButtonLabel.setIcon(record);
                try {
                    // stop recording
                    //screenRecorder1.stopRecording();
                    screenRecorder2.stopRecording();
                    videoInfo.main(recConfig);
                } catch (Exception ex) {
                    // notify user about any exception on recording
                    JOptionPane.showMessageDialog(saveButtonLabel, "Error while stopping the recording!\nError Info:\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_recordButton_MousePressedEvent

    // method called when frame rate button lable is pressed
    private void frameRateButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameRateButton_MousePressedEvent
        // TODO add your handling code here:
        // call frame rate selector
        new FrameRateSelector(recConfig);
        System.out.println("Frame Rate: " + recConfig.getFramesRate() + " fps");
    }//GEN-LAST:event_frameRateButton_MousePressedEvent

    // method called when capture area button label is pressed
    private void captureAreaButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_captureAreaButton_MousePressedEvent
        // TODO add your handling code here:
        // call capture area selector
        new CaptureAreaSelector1(recConfig);

    }//GEN-LAST:event_captureAreaButton_MousePressedEvent

    // method called when save button lableis pressed
    private void saveButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButton_MousePressedEvent
        // TODO add your handling code here:
        // call save file chooser
        new SaveFileChooser(recConfig);
    }//GEN-LAST:event_saveButton_MousePressedEvent

    // method called when the mouse enters the record button label region
    private void recordButton_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordButton_MouseEntered
        // TODO add your handling code here:
        // if not recording then
        if (!isRecording) {
            // show the recording icon
            recordButtonLabel.setIcon(recording);
        }
    }//GEN-LAST:event_recordButton_MouseEntered

    // method called when the mouse enters the record button label region
    private void recordButton_MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordButton_MouseExited
        // TODO add your handling code here:
        // if not recording
        if (!isRecording) {
            // show the record icon
            recordButtonLabel.setIcon(record);
        }
    }//GEN-LAST:event_recordButton_MouseExited


    private void DurationButtonLabelframeRateButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DurationButtonLabelframeRateButton_MousePressedEvent
        // TODO add your handling code here:
        new DurationSelector(recConfig);
        System.out.println("Video Length: " + recConfig.getDuration() / 1000 + " Seconds");
    }//GEN-LAST:event_DurationButtonLabelframeRateButton_MousePressedEvent

    private void uploadButtonLabelauto1Button_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadButtonLabelauto1Button_MousePressedEvent
        // TODO add your handling code here:

        Thread thread = new Thread(new Runnable() {
            public void run() {

                UploadVideo.main(null);

            }
        });
        thread.start();

    }//GEN-LAST:event_uploadButtonLabelauto1Button_MousePressedEvent

    private void extractButtonLabelauto1Button_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extractButtonLabelauto1Button_MousePressedEvent
        // TODO add your handling code here:

        Thread thread = new Thread(new Runnable() {
            public void run() {
                check_myuploads2.main(null);

            }
        });
        thread.start();
    }//GEN-LAST:event_extractButtonLabelauto1Button_MousePressedEvent

    private void clearButtonLabelauto1Button_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonLabelauto1Button_MousePressedEvent

        Thread thread = new Thread(new Runnable() {
            public void run() {
                ClearVideo.main(null);
            }
        });
        thread.start();
    }//GEN-LAST:event_clearButtonLabelauto1Button_MousePressedEvent

    private void TimeButtonLabelframeRateButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimeButtonLabelframeRateButton_MousePressedEvent
        // TODO add your handling code here:
        new TimeSelector(recConfig);
        System.out.println("Time to start recording: " + recConfig.getTime() + " Seconds");
    }//GEN-LAST:event_TimeButtonLabelframeRateButton_MousePressedEvent

    private void capture_xtubethButtonLabelcaptureAreaButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capture_xtubethButtonLabelcaptureAreaButton_MousePressedEvent
        // TODO add your handling code here:
        new CaptureAreaSelector_xtubeth(recConfig);
    }//GEN-LAST:event_capture_xtubethButtonLabelcaptureAreaButton_MousePressedEvent

    private void capture_h265ButtonLabelcaptureAreaButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capture_h265ButtonLabelcaptureAreaButton_MousePressedEvent
        // TODO add your handling code here:
        new CaptureAreaSelector_h265(recConfig);
    }//GEN-LAST:event_capture_h265ButtonLabelcaptureAreaButton_MousePressedEvent

    private void autorun_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autorun_MousePressedEvent
        // TODO add your handling code here:

        Thread thread = new Thread(new Runnable() {
            public void run() {
                final JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(0, 1));
                FileDialog fd = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
                //fd.setDirectory("C:\\");
                fd.setDirectory(System.getProperty("user.home") + "\\Desktop\\");
                fd.setFile("*.xls");
                fd.setVisible(true);
                String filename1 = fd.getFile();
                file = new File(fd.getDirectory() + fd.getFile());
                if (filename1 == null) {
                    System.out.println("You cancelled the choice");
                } else {
                    System.out.println("");
                    System.out.println("start checking");
                    File file1 = LoadFileChooser.file;
                    recConfig.setLoadFile(file1);
                    System.out.println("Your selected file is " + recConfig.getLoadFile());
                    autopress = true;
                    new File(System.getProperty("user.home") + "\\Desktop\\new\\").mkdir();
                    //new File(System.getProperty("user.home")+"\\Desktop\\new\\screen_monitor\\").mkdir();
                    new File(System.getProperty("user.home") + "\\Desktop\\new\\screen_result\\").mkdir();

                    new File(System.getProperty("user.home") + "\\Desktop\\new\\screen_savedvideo\\").mkdir();
                    recConfig.setVideoFile1(new File(System.getProperty("user.home") + "\\Desktop\\new\\screen_savedvideo\\test.mp4"));

                    file = file1;

                    //counter used to check for videoID
                    int x = 0;

                    //total number of rows in the excel sheet
                    int totalrownumber = 0;

                    //this array is used to store all video ID,
                    String[] ar0 = null;

                    try {
                        player01_remove_empty02.main(null);
                        FileInputStream file = new FileInputStream(file1);

                        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                        Document doc = documentBuilder.newDocument();
                        Element orders = doc.createElement("Orders");
                        doc.appendChild(orders);
                        Element order = doc.createElement("Order");
                        orders.appendChild(order);

                        HSSFWorkbook workbook = new HSSFWorkbook(file);
                        HSSFSheet sheet = workbook.getSheetAt(0);
                        Iterator<Row> rowIterator = sheet.iterator();
                        totalrownumber = sheet.getLastRowNum() + 1;
                        System.out.println("total number of row: " + totalrownumber);
                        ar0 = new String[totalrownumber];

                        int j = 100;
                        while (rowIterator.hasNext()) {
                            Row row = rowIterator.next();
                            Iterator<Cell> cellIterator = row.cellIterator();
                            Element test = doc.createElement("Test");
                            order.appendChild(test);

                            int i = 0;
                            while (cellIterator.hasNext() && i < 2) {
                                i++;
                                Cell cell = cellIterator.next();
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_NUMERIC:
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        String st = null;
                                        st = cell.getStringCellValue();
                                        String startstring = "http";
                                        boolean retval = st.startsWith(startstring);
                                        if (retval == false) {
                                            j++;
                                            System.out.println("Item: " + j);
                                            System.out.println(st);
                                            Element title1 = doc.createElement("Filmname");
                                            title1.appendChild(doc.createTextNode(st));
                                            test.appendChild(title1);
                                        } else {
                                            if (st.contains(" ")) {
                                                System.out.println("It contains space in the link and will update it");
                                                st = st.replaceAll(" ", "%20");
                                                System.out.println(st);
                                            } else {
                                                System.out.println("it contains no space");
                                                System.out.println(st);
                                            }

                                            Desktop.getDesktop().browse(new URI(st));
                                            int count = 0;
                                            try {

                                                //System.out.println(recConfig.getVideoFile1()+"00");
                                                Date date = new Date();
                                                SimpleDateFormat dateFormat = new SimpleDateFormat("hh-mm-ss");
                                                String parent = recConfig.getVideoFile1().getParent();
                                                String name = recConfig.getVideoFile().getName();
                                                String removeext = FilenameUtils.removeExtension(name);
                                                String string = parent + "\\" + removeext + "_" + j + "_" + dateFormat.format(date);
                                                File filename = new File(string + ".mp4");
                                                recConfig.setVideoFile1(filename);

                                                if (st.startsWith("http://xtubeth.com")) {
                                                    xtubeth.main(null);
                                                    Thread.sleep(1000 * recConfig.getTime());
                                                    System.out.println("wait " + recConfig.getTime() + "s to start recording");
                                                    screenRecorder_xtubeth.startRecording2(recConfig);
                                                    Thread.sleep(recConfig.getDuration());
                                                    screenRecorder_xtubeth.stopRecording();
                                                    count = tvb.main();
                                                    UploadVideo2.uploadVideo(recConfig.getVideoFile1());

                                                    int count1 = recConfig.getDuration() / 1000;
                                                    String time = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(count1),
                                                            TimeUnit.SECONDS.toMinutes(count1) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(count1)),
                                                            TimeUnit.SECONDS.toSeconds(count1) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(count1)));

                                                    Element duration = doc.createElement("Duration");
                                                    duration.appendChild(doc.createTextNode(time));
                                                    test.appendChild(duration);

                                                } else if (st.startsWith("http://h265")) {
                                                    h265.main(null);
                                                    Thread.sleep(1000 * recConfig.getTime());
                                                    System.out.println("wait " + recConfig.getTime() + "s to start recording");
                                                    screenRecorder_h265.startRecording2(recConfig);
                                                    Thread.sleep(recConfig.getDuration());
                                                    screenRecorder_h265.stopRecording();
                                                    count = tvb.main();
                                                    UploadVideo2.uploadVideo(recConfig.getVideoFile1());

                                                    int count1 = recConfig.getDuration() / 1000;
                                                    String time = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(count1),
                                                            TimeUnit.SECONDS.toMinutes(count1) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(count1)),
                                                            TimeUnit.SECONDS.toSeconds(count1) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(count1)));

                                                    Element duration = doc.createElement("Duration");
                                                    duration.appendChild(doc.createTextNode(time));
                                                    test.appendChild(duration);
                                                } else if (st.startsWith("https://stream.moe")) {

                                                    stream.click(recConfig.getFrameDimension_stream());
                                                    Thread.sleep(1000 * recConfig.getTime());
                                                    System.out.println("wait " + recConfig.getTime() + "s to start recording");
                                                    screenRecorder_stream.startRecording2(recConfig);
                                                    Thread.sleep(recConfig.getDuration());
                                                    screenRecorder_stream.stopRecording();
                                                    count = tvb.main();
                                                    UploadVideo2.uploadVideo(recConfig.getVideoFile1());

                                                    int count1 = recConfig.getDuration() / 1000;
                                                    String time = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(count1),
                                                            TimeUnit.SECONDS.toMinutes(count1) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(count1)),
                                                            TimeUnit.SECONDS.toSeconds(count1) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(count1)));

                                                    Element duration = doc.createElement("Duration");
                                                    duration.appendChild(doc.createTextNode(time));
                                                    test.appendChild(duration);
                                                } else if (st.startsWith("https://openload")) {

                                                    //for checking if the website is 404 or not
                                                    int checking = 0;
                                                    System.out.println("checking" + checking);
                                                    checking = openload.main();

                                                    if (checking == 1) {
                                                        Thread.sleep(1000 * recConfig.getTime());
                                                        System.out.println("wait " + recConfig.getTime() + "s to start recording");

                                                        screenRecorder_openload.startRecording2(recConfig);

                                                        System.out.println("It will only record 5s as found sorry logo");
                                                        Thread.sleep(5000);
                                                        screenRecorder_openload.stopRecording();
                                                        count = tvb.main();
                                                        UploadVideo2.uploadVideo(recConfig.getVideoFile1());

                                                        int count1 = 5;
                                                        String time = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(count1),
                                                                TimeUnit.SECONDS.toMinutes(count1) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(count1)),
                                                                TimeUnit.SECONDS.toSeconds(count1) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(count1)));
                                                        //System.out.println(time);

                                                        Element duration = doc.createElement("Duration");
                                                        duration.appendChild(doc.createTextNode(time));
                                                        test.appendChild(duration);

                                                    } else {
                                                        Thread.sleep(1000 * recConfig.getTime());
                                                        System.out.println("wait " + recConfig.getTime() + "s to start recording");
                                                        screenRecorder_openload.startRecording2(recConfig);
                                                        Thread.sleep(recConfig.getDuration());
                                                        screenRecorder_openload.stopRecording();
                                                        count = tvb.main();
                                                        UploadVideo2.uploadVideo(recConfig.getVideoFile1());

                                                        int count1 = recConfig.getDuration() / 1000;
                                                        String time = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(count1),
                                                                TimeUnit.SECONDS.toMinutes(count1) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(count1)),
                                                                TimeUnit.SECONDS.toSeconds(count1) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(count1)));
                                                        //System.out.println(time);

                                                        Element duration = doc.createElement("Duration");
                                                        duration.appendChild(doc.createTextNode(time));
                                                        test.appendChild(duration);
                                                    }
                                                } else {
                                                    Thread.sleep(1000 * recConfig.getTime());
                                                    System.out.println("wait " + recConfig.getTime() + "s to start recording");
                                                    //screenRecorder1.startRecording2(recConfig);
                                                    screenRecorder2.startRecording2(recConfig);
                                                    Thread.sleep(recConfig.getDuration());
                                                    //screenRecorder1.stopRecording();
                                                    screenRecorder2.stopRecording();
                                                    count = tvb.main();
                                                    UploadVideo2.uploadVideo(recConfig.getVideoFile1());

                                                    int count1 = recConfig.getDuration() / 1000;
                                                    String time = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(count1),
                                                            TimeUnit.SECONDS.toMinutes(count1) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(count1)),
                                                            TimeUnit.SECONDS.toSeconds(count1) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(count1)));
                                                    //System.out.println(time);

                                                    Element duration = doc.createElement("Duration");
                                                    duration.appendChild(doc.createTextNode(time));
                                                    test.appendChild(duration);

                                                }
                                            } catch (Exception ex) {
                                                JOptionPane.showMessageDialog(saveButtonLabel, "Cannot record for the given configuration!\nError Info:\n" + ex, "Processor Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                            Element link = doc.createElement("Link");
                                            link.appendChild(doc.createTextNode(st));
                                            test.appendChild(link);
                                            String str = recConfig.getVideoFile1().getAbsolutePath();
                                            Element mp4 = doc.createElement("MP4");
                                            mp4.appendChild(doc.createTextNode(str));
                                            test.appendChild(mp4);
                                            String st1 = null;

                                            if (count == 1) {
                                                st1 = "TVB logo not found";
                                            } else if (count == 2) {
                                                st1 = "TVB logo found";
                                            } else {
                                                st1 = "TVB logo read Error";
                                            }
                                            Element block = doc.createElement("Block");
                                            block.appendChild(doc.createTextNode(st1));
                                            test.appendChild(block);

                                            String videoID = UploadVideo2.getvideoID();
                                            Element ID = doc.createElement("VideoID");
                                            ID.appendChild(doc.createTextNode(videoID));
                                            test.appendChild(ID);

                                            Robot robot = new Robot();
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_W);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            robot.keyRelease(KeyEvent.VK_W);

                                            //System.out.println("videoid= "+UploadVideo2.getvideoID());
                                            //System.out.println("x="+x);
                                            ar0[x] = UploadVideo2.getvideoID();
                                            //System.out.println("id["+x+"]="+ar0[x]);
                                            x++;
                                            //System.out.println("x="+x);

                                        }
                                        break;
                                }

                            }
                            System.out.println("");
                        }
                        file.close();
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult streamResult = new StreamResult(new File(System.getProperty("user.home") + "\\Desktop\\new\\screen_result.xml"));
                        transformer.transform(source, streamResult);
                        //System.out.println(recConfig.getVideoFile());
                        //player01_excel02.main2(System.getProperty("user.home")+"\\Desktop\\new\\screen_result.xml");

                        player01_excel05.main1(recConfig);
                        player01_sorting.main1(recConfig);
                        player01_deletesheet.main1(recConfig);
                        //System.out.println(file1);
                        //     if (path1.endsWith("xlsx")){
                        //     player01_deletefile.main(file1);}

                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    System.out.println("Program has been finished");
                    System.out.println("");

                    //printout all the video ID
                    //System.out.println(Arrays.toString(ar0));
                    for (int i = 1; i <= totalrownumber; i++) {
                        System.out.println(i + "." + ar0[i - 1] );
                    }
                    System.out.println("");

                    //print out all the blank array
                    String[] ar2 = new String[totalrownumber];
                    //System.out.println(Arrays.toString(ar2));

                    for (int i = 1; i <= totalrownumber; i++) {
                        System.out.print(i + "." + ar2[i - 1] + ((i % 10 == 0) ? "\n" : " "));
                    }
                    System.out.println("");

                    //for monitor is checking is finished
                    int repeat_checking = 1;
                    try {
                        while (repeat_checking == 1) {

                            System.out.println("wait 30seconds and check again");
                            Thread.sleep(30000);

                            //this array is used to store all the video ID
                            String ar1[] = null;

                            for (int k = 0; k < x; k++) {
                                ar1 = check_myuploads1.check_myuploads1(ar0[k]);
                                ar2[k] = ar1[5];
                            }
                            //System.out.println(Arrays.toString(ar2));
                            System.out.println("");
                            //print array in 5numbers per line
                            int i;
                            for (i = 1; i <= x; i++) {
                                System.out.println(i + ". " + ar2[i - 1]);
                            }

                            //used to monitor if there are "null" in the array or not
                            if (Arrays.toString(ar2).contains("null")) {
                                //System.out.println("has null");
                                repeat_checking = 1;
                                //System.out.println("repeat_checking 1= "+repeat_checking);
                            } else {
                                repeat_checking = 0;
                                // System.out.println("repeat_checking 2="+repeat_checking);
                            }

                        }

                        System.out.println("");
                        check_myuploads1.main1(recConfig.getLoadFile().toString());

                        player01_sorting.main(null);
                        player01_deletesheet.main(null);
                        Desktop.getDesktop().open(recConfig.getLoadFile());
                    } catch (Exception ex) {
                        Logger.getLogger(RecordControlPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread.start();
    }//GEN-LAST:event_autorun_MousePressedEvent

    private void capture_openloadButtonLabel1captureAreaButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capture_openloadButtonLabel1captureAreaButton_MousePressedEvent
        // TODO add your handling code here:
        new CaptureAreaSelector_openload(recConfig);
    }//GEN-LAST:event_capture_openloadButtonLabel1captureAreaButton_MousePressedEvent

    private void capture_streamButtonLabelcaptureAreaButton_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capture_streamButtonLabelcaptureAreaButton_MousePressedEvent
        // TODO add your handling code here:
        new CaptureAreaSelector_stream(recConfig);
    }//GEN-LAST:event_capture_streamButtonLabelcaptureAreaButton_MousePressedEvent

    private void autorun1_MousePressedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autorun1_MousePressedEvent
        // TODO add your handling code here:
            // TODO add your handling code here:

        Thread thread = new Thread(new Runnable() {
            public void run() {
                final JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(0, 1));
                FileDialog fd = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
                //fd.setDirectory("C:\\");
                fd.setDirectory(System.getProperty("user.home") + "\\Desktop\\");
                fd.setFile("*.xls");
                fd.setVisible(true);
                String filename1 = fd.getFile();
                file = new File(fd.getDirectory() + fd.getFile());
                if (filename1 == null) {
                    System.out.println("You cancelled the choice");
                } else {
                    System.out.println("");
                    System.out.println("Start checking");
                    File file1 = LoadFileChooser.file;
                    recConfig.setLoadFile(file1);
                    System.out.println("Your selected file is " + recConfig.getLoadFile());
                    autopress = true;
                    new File(System.getProperty("user.home") + "\\Desktop\\new\\").mkdir();
                    //new File(System.getProperty("user.home")+"\\Desktop\\new\\screen_monitor\\").mkdir();
                    new File(System.getProperty("user.home") + "\\Desktop\\new\\screen_result\\").mkdir();

                    new File(System.getProperty("user.home") + "\\Desktop\\new\\screen_savedvideo\\").mkdir();
                    recConfig.setVideoFile1(new File(System.getProperty("user.home") + "\\Desktop\\new\\screen_savedvideo\\test.mp4"));

                    file = file1;

                    //counter used to check for videoID
                    int x = 0;

                    //total number of rows in the excel sheet
                    int totalrownumber = 0;

                    //this array is used to store all video ID,
                    String[] ar0 = null;

                    try {
                        player01_remove_empty02.main(null);
                        FileInputStream file = new FileInputStream(file1);

                        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                        Document doc = documentBuilder.newDocument();
                        Element orders = doc.createElement("Orders");
                        doc.appendChild(orders);
                        Element order = doc.createElement("Order");
                        orders.appendChild(order);

                        HSSFWorkbook workbook = new HSSFWorkbook(file);
                        HSSFSheet sheet = workbook.getSheetAt(0);
                        Iterator<Row> rowIterator = sheet.iterator();
                        totalrownumber = sheet.getLastRowNum() + 1;
                        System.out.println("Total number of row: " + totalrownumber);
                        ar0 = new String[totalrownumber];

                        int j = 100;
                        while (rowIterator.hasNext()) {
                            Row row = rowIterator.next();
                            Iterator<Cell> cellIterator = row.cellIterator();
                            Element test = doc.createElement("Test");
                            order.appendChild(test);

                            int i = 0;
                            while (cellIterator.hasNext() && i < 2) {
                                i++;
                                Cell cell = cellIterator.next();
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_NUMERIC:
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        String st = null;
                                        st = cell.getStringCellValue();
                                        String startstring = "http";
                                        boolean retval = st.startsWith(startstring);
                                        if (retval == false) {
                                            j++;
                                            System.out.print("Item: " + j);
                                            System.out.println(" - "+st);
                                            Element title1 = doc.createElement("Filmname");
                                            title1.appendChild(doc.createTextNode(st));
                                            test.appendChild(title1);
                                        } else {
                                            if (st.contains(" ")) {
                                                System.out.println("It contains space in the link and will update it");
                                                st = st.replaceAll(" ", "%20");
                                                System.out.println(st);
                                            } else {
                                                System.out.println(st);
                                            }

                                            Desktop.getDesktop().browse(new URI(st));
                                            int count = 0;
                                            try {

                                                Date date = new Date();
                                                SimpleDateFormat dateFormat = new SimpleDateFormat("hh-mm-ss");
                                                String parent = recConfig.getVideoFile1().getParent();
                                                String name = recConfig.getVideoFile().getName();
                                                String removeext = FilenameUtils.removeExtension(name);
                                                String string = parent + "\\" + removeext + "_" + j + "_" + dateFormat.format(date);
                                                File filename = new File(string + ".mp4");
                                                recConfig.setVideoFile1(filename);

                                                if (st.startsWith("https://openload")) {
                                                    int checking = 0;
                                                    checking = openload_new.main();//only change this line if found new website.
                                                    if (checking == 1) {
                                                        //found sorry logo
                                                        System.out.println("Wait " + recConfig.getTime() + "s to start recording");
                                                        System.out.println("It will only record 2s as found sorry logo");
                                                        Thread.sleep(1000 * recConfig.getTime());
                                                        screenRecorder2.startRecording2(recConfig);
                                                        Thread.sleep(3000);
                                                        screenRecorder2.stopRecording();
                                                        System.out.println("");
                                                        count=1;
                                                        int count1 = 5;
                                                        String time = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(count1),
                                                                TimeUnit.SECONDS.toMinutes(count1) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(count1)),
                                                                TimeUnit.SECONDS.toSeconds(count1) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(count1)));
                                                        Element block1 = doc.createElement("Block1");                                           
                                                        block1.appendChild(doc.createTextNode("Found - Sorry logo "));                                           
                                                        test.appendChild(block1);
                                                        Element duration = doc.createElement("Duration");
                                                        duration.appendChild(doc.createTextNode(time));
                                                        test.appendChild(duration);
                                                    } else {
                                                        //NOT found sorry logo, record 10s and check tvb
                                                        System.out.println("wait " + recConfig.getTime() + "s to start recording");
                                                        Thread.sleep(1000 * recConfig.getTime());
                                                         screenRecorder2.startRecording2(recConfig);
                                                        Thread.sleep(recConfig.getDuration());
                                                        screenRecorder2.stopRecording();
                                                        System.out.println("");
                                                        count = tvb1.main();
                                                        int count1 = recConfig.getDuration() / 1000;
                                                        String time = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(count1),
                                                                TimeUnit.SECONDS.toMinutes(count1) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(count1)),
                                                                TimeUnit.SECONDS.toSeconds(count1) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(count1)));                         
                                                        Element block1 = doc.createElement("Block1");                                                                                                
                                                        block1.appendChild(doc.createTextNode("NOT found - Sorry logo"));                                                                                                  
                                                        test.appendChild(block1);
                                                        Element duration = doc.createElement("Duration");
                                                        duration.appendChild(doc.createTextNode(time));
                                                        test.appendChild(duration);
                                                    }
                                                } else {

                                                    System.out.println("wait " + recConfig.getTime() + "s to start recording");
                                                    Thread.sleep(1000 * recConfig.getTime());

                                                    screenRecorder2.startRecording2(recConfig);
                                                    Thread.sleep(recConfig.getDuration());
                                                    screenRecorder2.stopRecording();
                                                    count = tvb1.main();

                                                    int count1 = recConfig.getDuration() / 1000;
                                                    String time = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(count1),
                                                            TimeUnit.SECONDS.toMinutes(count1) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(count1)),
                                                            TimeUnit.SECONDS.toSeconds(count1) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(count1)));
                                                    //System.out.println(time);

                                                    Element block1 = doc.createElement("Block1");                                                                                                
                                                    block1.appendChild(doc.createTextNode("Undefined"));                                                                                                  
                                                    test.appendChild(block1);
                                                        
                                                    Element duration = doc.createElement("Duration");
                                                    duration.appendChild(doc.createTextNode(time));
                                                    test.appendChild(duration);

                                                }
                                            } catch (Exception ex) {
                                                JOptionPane.showMessageDialog(saveButtonLabel, "Cannot record for the given configuration!\nError Info:\n" + ex, "Processor Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                            Element link = doc.createElement("Link");
                                            link.appendChild(doc.createTextNode(st));
                                            test.appendChild(link);
                                            String str = recConfig.getVideoFile1().getAbsolutePath();
                                            Element mp4 = doc.createElement("MP4");
                                            mp4.appendChild(doc.createTextNode(str));
                                            test.appendChild(mp4);
                                            String st1 = null;

                                            if (count == 1) {
                                                st1 = "TVB logo not found";
                                            } else if (count == 2) {
                                                st1 = "TVB logo found";
                                            } else {
                                                st1 = "TVB logo read Error";
                                            }
                                            Element block = doc.createElement("Block");
                                            block.appendChild(doc.createTextNode(st1));
                                            test.appendChild(block);
                                            
                                            Robot robot = new Robot();
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_W);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            robot.keyRelease(KeyEvent.VK_W);
                                        }
                                        break;
                                }
                            }
                            System.out.println("");
                        }
                        file.close();
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult streamResult = new StreamResult(new File(System.getProperty("user.home") + "\\Desktop\\new\\screen_result.xml"));
                        transformer.transform(source, streamResult);
                        player01_excel06.main1(recConfig);
                        player01_sorting.main1(recConfig);
                        player01_deletesheet.main1(recConfig);
                        Desktop.getDesktop().open(recConfig.getLoadFile());
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    System.out.println("Program has been finished");                  
                }
            }
        });
        thread.start();
    }//GEN-LAST:event_autorun1_MousePressedEvent

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DurationButtonLabel;
    private javax.swing.JLabel TimeButtonLabel;
    private javax.swing.JLabel autorunButtonLabel;
    private javax.swing.JLabel autorunButtonLabel1;
    private javax.swing.JLabel captureAreaButtonLabel;
    private javax.swing.JLabel capture_h265ButtonLabel;
    private javax.swing.JLabel capture_openloadButtonLabel1;
    private javax.swing.JLabel capture_streamButtonLabel;
    private javax.swing.JLabel capture_xtubethButtonLabel;
    private javax.swing.JLabel clearButtonLabel;
    private javax.swing.JLabel extractButtonLabel;
    private javax.swing.JLabel frameRateButtonLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel recordButtonLabel;
    private javax.swing.JLabel saveButtonLabel;
    private javax.swing.JLabel uploadButtonLabel;
    // End of variables declaration//GEN-END:variables

    // getter for  record config
    public RecordConfig getRecConfig() {
        return recConfig;
    }

    // setter for record config
    public void setRecConfig(RecordConfig recConfig) {
        this.recConfig = recConfig;
    }

    public boolean getboolean() {
        return isReadyForRecording();
    }

    // method to check whether the configuration is set for recording
    public boolean isReadyForRecording() {
        // if capture area is not set request user to select the capture area
        if (recConfig.getFrameDimension() == null) {
            JOptionPane.showMessageDialog(saveButtonLabel, "Capture area not set!\nPlease select capture area.", "Insufficient Configuration", JOptionPane.WARNING_MESSAGE);
            return false;
        } // if the frame rate is not set then request user to set the frame rate
        else if (recConfig.getFramesRate() == 0) {
            JOptionPane.showMessageDialog(saveButtonLabel, "Frame rate not set!\nPlease set the frame rate.", "Insufficient Configuration", JOptionPane.WARNING_MESSAGE);
            return false;
        } // if the video save file is not set then request user to select one
        else if (recConfig.getVideoFile() == null) {
            JOptionPane.showMessageDialog(saveButtonLabel, "Save file not set!\nPlease select a file to save the recorded video.", "Insufficient Configuration", JOptionPane.WARNING_MESSAGE);
            return false;
        } // if all the above condition are met then return true indication the
        // record config is set for recording
        else {
            return true;
        }
    }
}
