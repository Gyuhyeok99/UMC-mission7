package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConvertor {

    public static Store toStore(StoreRequestDTO.addDTO addDTO) {
        return Store.builder()
                .name(addDTO.getName())
                .address(addDTO.getAddress())
                .build();
    }

    public static StoreResponseDTO.addResultDTO toAddResultDTO(Store store) {
        return StoreResponseDTO.addResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

}
