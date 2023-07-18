package product.convertor;

import org.springframework.stereotype.Component;
import product.controller.productDTO.EmployeeDTO;
import product.repository.model.Employee;
import product.repository.model.Shop;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {
    public Employee convertToEntity(EmployeeDTO source) {
        Shop shop = new Shop(source.getShopId());
        return new Employee(source.getId(),
                source.getName(),
                source.getSurname(),
                shop,
                source.getTitle());
    }

    public EmployeeDTO convertToEmployeeDTO(Employee source) {
        return convertToEmployeeDto(source);
    }

    public List<EmployeeDTO> convertToEmployeeDTO(Collection<Employee> source) {
        return source.stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertToEmployeeDto(Employee source) {
        EmployeeDTO result = new EmployeeDTO();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setShopId(source.getShop().getId());
        result.setSurname(source.getSurname());
        result.setTitle(source.getTitle());
        return result;
    }
}
