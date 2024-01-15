package com.school.student.service;

import com.school.student.entity.ClassEntity;
import com.school.student.entity.StudentEntity;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {
    public static List<StudentEntity> readStudentsFromExcel(MultipartFile file) throws IOException {
    List<StudentEntity> students = new ArrayList<>();

    try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator.hasNext()){
            rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            StudentEntity studentDTO = createStudentDTOFromRow(row);
            students.add(studentDTO);
        }
    }

    return students;
}

private static StudentEntity createStudentDTOFromRow(Row row) {
    StudentEntity studentEntity = new StudentEntity();

    // Assuming cell 0 contains the roll number (numeric or string)
    Cell rollNumberCell = row.getCell(0);
    if (rollNumberCell != null) {
        if (rollNumberCell.getCellType() == CellType.NUMERIC) {
            studentEntity.setRoll_number((int) rollNumberCell.getNumericCellValue());
        } else if (rollNumberCell.getCellType() == CellType.STRING) {
            try {
                studentEntity.setRoll_number(Integer.parseInt(rollNumberCell.getStringCellValue()));
            } catch (NumberFormatException e) {
                // Handle the exception if the string cannot be parsed to an integer
                e.printStackTrace();
            }
        }
    }
    System.out.println(studentEntity.getRoll_number());

    // Assuming cell 1 contains the name (string)
    Cell nameCell = row.getCell(1);
    if (nameCell != null && nameCell.getCellType() == CellType.STRING) {
        studentEntity.setName(nameCell.getStringCellValue());
    }
    System.out.println(studentEntity.getName());

    // Assuming cell 2 contains the class ID (numeric)
    Cell classIdCell = row.getCell(2);
    if (classIdCell != null && classIdCell.getCellType() == CellType.NUMERIC) {
        int classId = (int) classIdCell.getNumericCellValue();
        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(classId);
        studentEntity.setClassEntity(classEntity);
        System.out.println(studentEntity.getClassEntity());
    }

    return studentEntity;
}

}
