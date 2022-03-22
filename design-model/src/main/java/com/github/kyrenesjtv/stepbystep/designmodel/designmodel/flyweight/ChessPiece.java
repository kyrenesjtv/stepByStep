package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author huojianxiong
 * @Description ChessPiece
 * @Date 2022/3/22 11:15
 */
@Data
@AllArgsConstructor
public class ChessPiece {
    private ChessPieceUnit chessPieceUnit;
    
    private int positionX;
    private int positionY;

}
