package umc.study.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.converter.StoreConvertor;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional

public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store createStore(StoreRequestDTO.createDTO storeCreateDto) {
        Store store = StoreConvertor.toStore(storeCreateDto);
        Region region = regionRepository.findById(storeCreateDto.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        store.setRegion(region);
        return storeRepository.save(store);
    }

}
