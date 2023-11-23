package umc.study.service.missionService;

        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import umc.study.apiPayload.code.status.ErrorStatus;
        import umc.study.apiPayload.exception.handler.MemberHandler;
        import umc.study.apiPayload.exception.handler.MissionHandler;
        import umc.study.apiPayload.exception.handler.RegionHandler;
        import umc.study.apiPayload.exception.handler.StoreHandler;
        import umc.study.converter.MemberMissionConverter;
        import umc.study.converter.MissionConverter;
        import umc.study.converter.StoreConvertor;
        import umc.study.domain.Member;
        import umc.study.domain.Mission;
        import umc.study.domain.Region;
        import umc.study.domain.Store;
        import umc.study.domain.mapping.MemberMission;
        import umc.study.repository.MemberMissionRepository;
        import umc.study.repository.MemberRepository;
        import umc.study.repository.MissionRepository;
        import umc.study.repository.StoreRepository;
        import umc.study.web.dto.MemberRequestDTO;
        import umc.study.web.dto.MissionRequestDTO;

        import java.util.Optional;

        import static umc.study.apiPayload.code.status.ErrorStatus.MEMBER_NOT_FOUND;
        import static umc.study.apiPayload.code.status.ErrorStatus.MISSION_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Mission createMission(MissionRequestDTO.createDTO createDTO) {
        Mission mission = MissionConverter.toMission(createDTO);
        Store store = storeRepository.findById(createDTO.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        mission.setStore(store);
        return missionRepository.save(mission);
    }

    @Override
    public MemberMission challenging(MissionRequestDTO.challengingDTO request) {
        Member member = memberRepository.findById(1L)
                    .orElseThrow(() -> new MemberHandler(MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                    .orElseThrow(() -> new MissionHandler(MISSION_NOT_FOUND));

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request);
        newMemberMission.setMember(member);
        newMemberMission.setMission(mission);

            return memberMissionRepository.save(newMemberMission);

    }
}
