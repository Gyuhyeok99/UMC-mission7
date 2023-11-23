package umc.study.domain.mapping;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15)")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;


    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getMemberMissionList().remove(this);
        }
        this.member = member;
        if (member != null) {
            member.getMemberMissionList().add(this);
        }
    }

    public void setMission(Mission mission) {
        if (this.mission != null) {
            this.mission.getMemberMissionList().remove(this);
        }
        this.mission = mission;
        if (mission != null) {
            mission.getMemberMissionList().add(this);
        }
    }

    public void setStatus() {
        this.status = MissionStatus.CHALLENGING;
    }


}
