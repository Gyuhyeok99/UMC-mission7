package umc.study.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.MissionConverter;
import umc.study.converter.StoreConvertor;
import umc.study.domain.Mission;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission createMission(MissionRequestDTO.createDTO createDTO) {
        Mission mission = MissionConverter.toMission(createDTO);
        Store store = storeRepository.findById(createDTO.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        mission.setStore(store);
        return missionRepository.save(mission);
    }
}
