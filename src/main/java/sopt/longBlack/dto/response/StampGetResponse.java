package sopt.longBlack.dto.response;

public record StampGetResponse(
        Long stampCount
) {
    public static StampGetResponse of(Long stampCount) {
        return new StampGetResponse(stampCount);
    }
}
