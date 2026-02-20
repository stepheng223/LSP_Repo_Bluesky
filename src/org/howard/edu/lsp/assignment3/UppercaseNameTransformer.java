package org.howard.edu.lsp.assignment3;

public class UppercaseNameTransformer implements Transformer {

    @Override
    public void apply(ProductRecord record) {
        record.setName(record.getName().toUpperCase());
    }
}