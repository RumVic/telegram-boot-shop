package springboottelegrambot.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springboottelegrambot.dto.idto.ProductInput;
import springboottelegrambot.dto.odto.OutPage;
import springboottelegrambot.dto.odto.ProductOutput;
import springboottelegrambot.service.api.IProductService;
import java.util.UUID;


@Component
@Transactional(readOnly = true)
public class ProductService implements IProductService {

    @Override
    public ProductOutput create(ProductInput productInput) {
        return null;
    }

    @Override
    public OutPage read(Pageable pageable) {
        return null;
    }

    @Override
    public ProductOutput update(UUID id, Long dtUpdate, ProductInput item) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }


}
