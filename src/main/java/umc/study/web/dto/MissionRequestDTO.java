package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.NotChallenging;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createDTO{
        @NotNull
        private Integer reward;
        @Future
        private LocalDate deadline;
        @NotBlank
        private String missionSpec;
        @ExistStore
        private Long storeId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class challengingDTO{
        @NotChallenging
        private Long missionId;
    }
}
