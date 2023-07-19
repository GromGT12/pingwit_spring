package product.service;

import product.controller.productDTO.ShopDTO;

import java.util.Collection;

public interface ShopService {
    ShopDTO getShopById(Integer id);

    Collection<ShopDTO> getAllShops();

    Integer createShop(ShopDTO shopToCreate);

}

