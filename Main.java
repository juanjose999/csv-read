import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import model.ProductsService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*lector de csv construido por mi
        ProductsService productsService = new ProductsService();
        productsService.readProductsFromCsv("C:\\Users\\Juan Jose\\Desktop\\Programacion\\ejerciciosJava\\ejercicioCvs\\csv-reader-java\\resources\\inventory.csv");
        productsService.imprimirListaProducts();*/

        String csvRutaFile = "C:\\Users\\Juan Jose\\Desktop\\Programacion\\ejerciciosJava\\ejercicioCvs\\csv-reader-java\\resources\\inventory.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvRutaFile))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Procesar cada línea del archivo CSV
                for (String value : nextLine) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}