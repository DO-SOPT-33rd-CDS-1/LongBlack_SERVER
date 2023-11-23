package sopt.longBlack.dto.response;

import lombok.AllArgsConstructor;
import sopt.longBlack.domain.paragraph.Paragraph;
import sopt.longBlack.domain.paragraph.ParagraphType;


public record ParagraphGetResponse(String content, ParagraphType paragraphType) {

    public static ParagraphGetResponse of(Paragraph paragraph) {
        return new ParagraphGetResponse(paragraph.getContent(), paragraph.getParagraphType());
    }
}
