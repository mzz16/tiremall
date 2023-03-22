package com.tireshoppingmall.home.product;

import java.util.List;

public interface ProductMapper {

	List<ProductGroupDTO> getProductGroup(ProductSelector search);

	int getProductGroupCount(ProductSelector search);

	int getProductGroupBrandCount(ProductSelector search);

	List<ProductGroupDTO> getProductBrandGroup(ProductSelector search);

	String getMinInchOfGroup(ProductGroupDTO pGroup);

	String getMaxInchOfGroup(ProductGroupDTO pGroup);

	String getMinPriceOfGroup(ProductGroupDTO pGroup);

	String getMaxPriceOfGroup(ProductGroupDTO pGroup);

	List<ProductGroupDTO> getProductGroupJson(ProductSelector search);

	ProductDTO getProduct(ProductDTO pDTO);

	List<ProductDTO> getProductSizes(ProductDTO pDTO);
}
