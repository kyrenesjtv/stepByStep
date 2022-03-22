package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description ChessBoard
 * @Date 2022/3/22 11:18
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
        chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 1, 0));
        //...省略摆放其他棋子的代码...
    }
}
