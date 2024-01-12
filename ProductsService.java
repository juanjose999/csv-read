package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsService implements ProductService{

    private List<Product> productos;

    public ProductsService (){
        this.productos = new ArrayList<>();
    }
    @Override
    public void addCvsToObject(Product producto){
        this.productos.add(producto);
    }
    @Override
    public void readProductsFromCsv(String rutaAbsoluta){
        try {
            String rutaArchivo = rutaAbsoluta;
            File file = new File(rutaArchivo);
            Scanner fileScanner = new Scanner(file);
            //Saltar el encabezado del CSV
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(",");
                if (productInfo.length >= 6) {
                    Product nuevoProducto = new Product(productInfo[0], productInfo[1], productInfo[2], productInfo[3], productInfo[4], productInfo[5]);
                    addCvsToObject(nuevoProducto);
                }if(productInfo.length<6){
                    continue;
                }
                //TODO implement the logic to transform this code so it can convert the information in each line into a Product objet
            }
            System.out.println("productos agreados el la lista correctamente.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void imprimirListaProducts(){
        for (Product p:productos){
            System.out.println(p.toString());;
        }
    }
}
