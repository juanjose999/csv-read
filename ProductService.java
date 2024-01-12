package model;

public interface ProductService {
    void addCvsToObject(Product product);
    void readProductsFromCsv(String filePath);
    void imprimirListaProducts();
}
