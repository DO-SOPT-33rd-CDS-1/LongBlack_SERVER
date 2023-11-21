package sopt.longBlack.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostType {
    L("비즈니스"),
    B("일의 의미"),
    C("패션 트렌드"),
    K("착한 소비");

    private final String description;
}
