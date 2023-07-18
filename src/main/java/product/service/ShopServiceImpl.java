package product.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import product.controller.productDTO.ShopDTO;
import product.convertor.ShopConverter;
import product.exсeption.PingwitNotFoundExсeption;
import product.repository.ShopRepository;
import product.repository.model.Shop;

import java.util.Collection;

@Service
@Transactional(readOnly = true)
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ShopConverter shopConverter;

    public ShopServiceImpl(ShopRepository shopRepository, ShopConverter shopConverter) {
        this.shopRepository = shopRepository;
        this.shopConverter = shopConverter;
    }

    @Override
    public ShopDTO getShopById(Integer id) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new PingwitNotFoundExсeption("Product not found: " + id));
        return shopConverter.convertToDTO(shop);
    }

    @Override
    public Collection<ShopDTO> getAllShops() {
        return shopConverter.convertToDTO(shopRepository.findAll());
    }

    @Override
    public Integer createShop(ShopDTO shopToCreate) {
        Shop shop = shopConverter.convertToEntity(shopToCreate);
        Shop savedShop = shopRepository.save(shop);
        return savedShop.getId();
    }
}
