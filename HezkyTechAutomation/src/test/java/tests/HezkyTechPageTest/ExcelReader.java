package tests.HezkyTechPageTest;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<String[]> getAllCertificateData(String filePath) {
        List<String[]> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            // We assume row 0 is the header row, so start from row 1
            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowCount; i++) {
                // We have 4 columns: External Sensor, Calibration Date, Expiry Date, CertificatePath
                String[] rowData = new String[4];
                rowData[0] = sheet.getRow(i).getCell(0).getStringCellValue(); // External Sensor
                rowData[1] = sheet.getRow(i).getCell(1).getStringCellValue(); // Calibration Date
                rowData[2] = sheet.getRow(i).getCell(2).getStringCellValue(); // Expiry Date
                rowData[3] = sheet.getRow(i).getCell(3).getStringCellValue(); // Certificate Path

                dataList.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
