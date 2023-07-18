package product.convertor;

import org.springframework.stereotype.Component;
import product.controller.productDTO.ShopDTO;
import product.repository.model.Shop;

import java.util.Collection;
import java.util.List;

@Component
public class ShopConverter {
    private final EmployeeConverter employeeConverter;
    private final AddressConverter addressConverter;

    public ShopConverter(EmployeeConverter employeeConverter, AddressConverter addressConverter) {
        this.employeeConverter = employeeConverter;
        this.addressConverter = addressConverter;
    }

    public Shop convertToEntity(ShopDTO source) {
        Shop result = new Shop();
        result.setName(source.getName());
        result.setAddress(addressConverter.convertToEntity(source.getAddress()));
        return result;
    }

    public ShopDTO convertToDTO(Shop shop) {
        return convertShopToDto(shop);
    }

    public List<ShopDTO> convertToDTO(Collection<Shop> shops) {
        return shops.stream()
                .map(this::convertShopToDto)
                .toList();
    }

    private ShopDTO convertShopToDto(Shop source) {
        ShopDTO result = new ShopDTO();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setAddress(addressConverter.convertToAddressDTO(source.getAddress()));
        result.setEmployees(employeeConverter.convertToEmployeeDTO(source.getEmployees()));
        result.setPhone(source.getPhone());
        return result;
    }
}

