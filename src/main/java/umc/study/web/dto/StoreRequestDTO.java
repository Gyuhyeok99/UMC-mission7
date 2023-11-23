package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ExistRegion;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

public class StoreRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createDTO {
        @NotBlank
        private String name;
        @NotBlank
        private String address;
        @ExistRegion
        private Long regionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewDTO {
        String title;
        Float score;
        String body;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO{
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO{
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }

}
