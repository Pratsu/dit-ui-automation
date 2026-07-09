package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    public static Object[][] getTestData(String filePath, String sheetName) {

        Object[][] data = null;

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rows - 1][cols];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rows; i++) {

                Row row = sheet.getRow(i);

                for (int j = 0; j < cols; j++) {

                    Cell cell = row.getCell(j);

                    data[i - 1][j] = formatter.formatCellValue(cell);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}