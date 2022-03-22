package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description ChessPieceUnitFactory
 * @Date 2022/3/22 11:21
 */
public class ChessPieceUnitFactory {
    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

    static {
        pieces.put(1, new ChessPieceUnit(1, "车", ChessPieceUnit.Color.BLACK));
        pieces.put(2, new ChessPieceUnit(2, "马", ChessPieceUnit.Color.BLACK));
        //...省略摆放其他棋子的代码...
    }

    public static ChessPieceUnit getChessPiece(int chessPieceId) {
        return pieces.get(chessPieceId);
    }
}
