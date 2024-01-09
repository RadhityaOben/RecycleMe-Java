package com.recycleme.actionListener.reports;

import com.recycleme.db.MySqlConnection;
import com.recycleme.frame.reports.ReportsFrame;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.event.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PreviewPDF implements ActionListener {
    private ReportsFrame reportsFrame;
    private String reportType;

    public PreviewPDF(ReportsFrame reportsFrame) {
        this.reportsFrame = reportsFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(reportsFrame.getComboBoxPilihan().equals("Masyarakat")) {
            reportType = "masyarakatReport";
        } else if(reportsFrame.getComboBoxPilihan().equals("Kurir")) {
            reportType = "kurirReport";
        } else if(reportsFrame.getComboBoxPilihan().equals("Dropbox")) {
            reportType = "dropboxReport";
        }

        try{
            String frontPath = "src/main/resources/reports/";
            String path = frontPath + reportType + ".jrxml";
            String exportPath = "src/main/export/";
            JasperReport jasperReport = JasperCompileManager.compileReport(path);

            Map<String, Object> parameters = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, MySqlConnection.getInstance().getConnection());

            JasperViewer.viewReport(jasperPrint, false);
        } catch(JRException ex) {
            reportsFrame.showErrorMessage("Preview gagal ditampilkan");
            ex.printStackTrace();
        }
    }
}
