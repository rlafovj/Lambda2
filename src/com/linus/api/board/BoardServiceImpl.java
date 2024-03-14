package com.linus.api.board;

public class BoardServiceImpl implements BoardService {
    private static BoardService instance = new BoardServiceImpl();

    private BoardServiceImpl(){}

    public static BoardService getInstance(){
        return instance;
    }


}
