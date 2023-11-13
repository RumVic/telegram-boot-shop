package springboottelegrambot.storage.api;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import springboottelegrambot.storage.entity.Product;

import java.util.Optional;
import java.util.UUID;

public interface IProductStorage extends JpaRepository<Product,UUID> {

    Optional<Product> findById(@NonNull UUID id);

    Page<Product> findAll(@NonNull Pageable pageable);

}
