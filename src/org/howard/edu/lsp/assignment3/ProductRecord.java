package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents one valid product row from products.csv plus derived fields.
 * Stores originalCategory to preserve A2 transformation logic.
 */
public class ProductRecord {
    private final int productId;
    private String name;
    private BigDecimal price;
    private String category;

    // Needed for rule: premium category depends on original category
    private final String originalCategory;

    // Derived output field
    private String priceRange = "";

    public ProductRecord(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.originalCategory = category;
    }

    public int getProductId() { return productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getOriginalCategory() { return originalCategory; }

    public String getPriceRange() { return priceRange; }
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }
}