package Pemira.Controller;

import Pemira.Model.ViewRecordsModel;
import Pemira.View.ViewRecords;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ViewRecordsController {
    private ViewRecords view;
    private ViewRecordsModel model;

    public ViewRecordsController(ViewRecords view) {
        this.view = view;
        this.model = new ViewRecordsModel();
    }

    public void navigateToAdminOptions() {
        new Pemira.View.AdminOptions().setVisible(true);
        view.setVisible(false);
    }

    public void loadRecords() {
        try {
            List<String[]> records = model.getVoterRecords();
            DefaultTableModel tblModel = new DefaultTableModel(new Object[]{"NIM", "Name", "Age", "Tingkat", "Kelas", "Email", "Vote"}, 0);
            for (String[] record : records) {
                tblModel.addRow(record);
            }
            view.populateTable(tblModel);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(view, "Error loading records: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exportRecords() {
        DefaultTableModel tblModel = (DefaultTableModel) view.getCatatanSuaraTable().getModel();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Export to CSV");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV files (*.csv)", "csv"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (FileWriter csvWriter = new FileWriter(fileToSave + ".csv")) {
                // Write column headers
                for (int i = 0; i < tblModel.getColumnCount(); i++) {
                    csvWriter.write(tblModel.getColumnName(i) + ",");
                }
                csvWriter.write("\n");

                // Write rows
                for (int i = 0; i < tblModel.getRowCount(); i++) {
                    for (int j = 0; j < tblModel.getColumnCount(); j++) {
                        csvWriter.write(tblModel.getValueAt(i, j).toString() + ",");
                    }
                    csvWriter.write("\n");
                }

                csvWriter.flush();
                JOptionPane.showMessageDialog(null, "Export successful!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error exporting data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
