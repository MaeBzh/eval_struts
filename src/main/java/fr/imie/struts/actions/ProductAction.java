package fr.imie.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.imie.struts.javaBeans.Product;
import fr.imie.struts.repositories.ProductRepository;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductAction extends ActionSupport {

    private Product product;
    private List<Product> productsList = new ArrayList<Product>();

    public ProductAction() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Display product details
     *
     * @param productId the id of product we want to display details
     * @return success if product found, else error
     * @throws Exception
     */
    public String getProductDetails(@NotNull int productId) throws Exception {
        String result;
        ProductRepository productRepository = new ProductRepository();
        this.product = productRepository.get(productId);
        if (this.product != null) {
            result = ActionSupport.SUCCESS;
        } else {
            result = ActionSupport.ERROR;
        }

        return result;
    }

    /**
     * Display the list of products
     * @return success if products' list found, else error
     * @throws Exception
     */
    public String getProductsList() throws Exception {
        String result;
        ProductRepository productRepository = new ProductRepository();
        this.productsList = productRepository.getAll();
        if (this.productsList != null) {
            result = ActionSupport.SUCCESS;
        } else {
            result = ActionSupport.ERROR;
        }

        return result;
    }
}
