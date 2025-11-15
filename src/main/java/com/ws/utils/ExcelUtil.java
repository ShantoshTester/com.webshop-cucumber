package com.ws.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    // Step 1 : create the workbook
    private Workbook getWorkBook(String excelFilePath) throws Exception
    {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    // Step 2 : get the sheet by name
    private Sheet getSheetByName(String excelFilePath, String sheetName) throws Exception
    {
        Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
        return sheet;
    }

    // Step 3 : get the row
    private Row getRow(Sheet sheet, int rowNumber)
    {
        return sheet.getRow(rowNumber);
    }

    // Step 4 : get header row number
    private int getHeaderRowNumber(Sheet sheet)
    {
        Row row;
        int totalRows = sheet.getLastRowNum();
        for(int currentRow=0; currentRow <= totalRows; currentRow++)
        {
            row=getRow(sheet, currentRow);
            if(row != null)
            {
                short totalColumn = row.getLastCellNum();
                for(int currentColumn=0 ; currentColumn< totalColumn; currentColumn++)
                {
                    Cell cell;
                    cell=row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if(cell.getCellType()==CellType.STRING)
                    {
                        return row.getRowNum();
                    }
                    else if(cell.getCellType()==CellType.NUMERIC)
                    {
                        return row.getRowNum();
                    }
                    else if(cell.getCellType()==CellType.BOOLEAN)
                    {
                        return row.getRowNum();
                    }
                    else if(cell.getCellType()==CellType.ERROR)
                    {
                        return row.getRowNum();
                    }
                }
            }
        }
        return (-1);
    }

    // Step 5 : get cell data
    private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn)
    {
        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
        Cell cell;
        if(row == null)
        {
            if(sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .getCellType()!=CellType.BLANK)
            {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        }
        else
        {
            cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() == CellType.STRING)
            {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK)
                {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                }
            }
            else if (cell.getCellType() == CellType.NUMERIC)
            {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK)
                {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
            }
            else if (cell.getCellType() == CellType.BLANK)
            {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK)
                {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            }
            else if (cell.getCellType() == CellType.BOOLEAN)
            {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK)
                {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                }
            }
            else if (cell.getCellType() == CellType.ERROR)
            {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK)
                {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                }
            }
        }
        return columnMapdata;
    }

    // Step 6 : read the complete sheet
    private List<Map<String, String>> readSheet(Sheet sheet)
    {
        Row row;
        int totalRow = sheet.getPhysicalNumberOfRows();
        List<Map<String, String>> excelRows = new ArrayList<>();
        int headerRowNumber = getHeaderRowNumber(sheet);
        if(headerRowNumber != -1)
        {
            short totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
            int setCurrentRow = 1;
            for(int currentRow= setCurrentRow; currentRow<=totalRow; currentRow++)
            {
                row = getRow(sheet, sheet.getFirstRowNum()+currentRow);
                LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();
                for(int currentColumn = 0; currentColumn<totalColumn; currentColumn++)
                {
                    columnMapData.putAll(getCellValue(sheet, row, currentColumn));
                }
                excelRows.add(columnMapData);
            }
        }
        return excelRows;
    }

    // Step 7 : get the data from the sheet
    public List<Map<String, String>> getData(String excelFilePath, String sheetName) throws Exception
    {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        return readSheet(sheet);
    }
}

