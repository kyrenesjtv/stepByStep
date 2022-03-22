package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author huojianxiong
 * @Description ChessPieceUnit
 * @Date 2022/3/22 11:20
 */
@Data
@AllArgsConstructor
public class ChessPieceUnit {
    private int id;
    private String text;
    private ChessPieceUnit.Color color;

    public static enum Color {
        RED, BLACK
    }
}
