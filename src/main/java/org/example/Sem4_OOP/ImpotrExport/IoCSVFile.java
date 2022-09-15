package org.example.Sem4_OOP.ImpotrExport;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.example.Sem4_OOP.TaskScheduler.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DimS on 13.09.2022
 */
public class IoCSVFile{
    public static List<String[]> getListFields(String path){
        try {
            File file = new File(path);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            //CSVReader csvReader = new CSVReader(reader);
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).build()) {
                return csvReader.readAll();
            }
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeFieldsToFile(String path, Task[] records){
        File file = new File(path);
        try {
            List<Task> recs = Arrays.asList(records);
            Writer writer = new FileWriter(file);

            ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
            mappingStrategy.setType(Task.class);
            String[] columns = new String[]{"priority", "ownerName", "dateDeadline" };
            writer.append("priority, ownerName, dateDeadline\n");
            mappingStrategy.setColumnMapping(columns);
            StatefulBeanToCsvBuilder<Task> builder= new StatefulBeanToCsvBuilder(writer);
            StatefulBeanToCsv beanWriter =
                    builder.withMappingStrategy(mappingStrategy).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            beanWriter.write(recs);
            writer.close();
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}
