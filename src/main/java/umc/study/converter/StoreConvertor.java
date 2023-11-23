package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConvertor {

    public static Store toStore(StoreRequestDTO.createDTO createDTO) {
        return Store.builder()
                .name(createDTO.getName())
                .address(createDTO.getAddress())
                .build();
    }

    public static StoreResponseDTO.createResultDTO toAddResultDTO(Store store) {
        return StoreResponseDTO.createResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

}
