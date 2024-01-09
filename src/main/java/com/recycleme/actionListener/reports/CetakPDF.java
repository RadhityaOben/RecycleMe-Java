package com.recycleme.actionListener.reports;

import com.recycleme.db.MySqlConnection;
import com.recycleme.frame.reports.ReportsFrame;
import net.sf.jasperreports.engine.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CetakPDF implements ActionListener {
    private ReportsFrame reportsFrame;
    private String reportType;

    public CetakPDF(ReportsFrame reportsFrame) {
        this.reportsFrame = reportsFrame;
    }

    private static void openFile(String path) throws IOException {
        File file = new File(path);
        Desktop.getDesktop().open(file);
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

            File outDir = new File(frontPath);
            outDir.mkdirs();

            JasperExportManager.exportReportToPdfFile(jasperPrint, exportPath + reportType + ".pdf");

            reportsFrame.showSuccessMessage("Laporan berhasil dicetak");

            openFile(exportPath);
        } catch(JRException ex) {
            reportsFrame.showErrorMessage("Laporan gagal dicetak");
            ex.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
