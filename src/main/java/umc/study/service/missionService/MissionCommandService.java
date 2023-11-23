package umc.study.service.missionService;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.StoreRequestDTO;

public interface MissionCommandService {

    public Mission createMission(MissionRequestDTO.createDTO createDTO);
}
