package umc.study.service.storeService;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    public Store createStore(StoreRequestDTO.createDTO storeCreateDto);
}
