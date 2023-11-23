package umc.study.service.missionService;

import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    public Mission createMission(MissionRequestDTO.createDTO createDTO);
    public MemberMission challenging(MissionRequestDTO.challengingDTO challengingDTO);
}
