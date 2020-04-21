package eg.gov.iti.jets.utilty;

import eg.gov.iti.jets.model.Purchase;
import eg.gov.iti.jets.model.dto.ProductDto;
import eg.gov.iti.jets.model.dto.PurchaseDto;

public class PurchaseMapper {
    public static PurchaseDto mapPurchase(Purchase purchase) {
        ProductDto productDto = ProductMapper.mapToProductDto(purchase.getProduct());
        return new PurchaseDto(purchase.getQuantity(), purchase.getProductBuyPrice(), productDto);
    }
}
