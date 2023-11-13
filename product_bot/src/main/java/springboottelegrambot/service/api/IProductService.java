package springboottelegrambot.service.api;


import springboottelegrambot.dto.idto.ProductInput;
import springboottelegrambot.dto.odto.OutPage;
import springboottelegrambot.dto.odto.ProductOutput;

public interface IProductService extends IService<ProductInput, ProductOutput, OutPage> {
}
