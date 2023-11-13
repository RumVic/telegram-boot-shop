package springboottelegrambot.service.api;

import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IService<IDTO, ODTO, OUTPage> {
    ODTO create (IDTO idto);
    OUTPage read (Pageable pageable);
    ODTO update(UUID id, Long dtUpdate,IDTO item);
    void delete(UUID id);
}
