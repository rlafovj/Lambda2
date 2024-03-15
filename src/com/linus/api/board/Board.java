package com.linus.api.board;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"id"})
public class Board {
    private Long id;
    private String boardName;
    private String boardType;

    @Builder(builderMethodName = "builder")
    public Board(String boardName, String boardType){
        this.boardName = boardName;
        this.boardType = boardType;
    }
}
