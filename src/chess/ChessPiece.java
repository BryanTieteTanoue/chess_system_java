/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

/**
 *
 * @author Bryan
 */
public abstract class ChessPiece extends Piece{
    
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    } //não quero que uma cor de peça seja modificada
    
    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
    
    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return (p != null) && (p.getColor() != color);
    }
    
}
