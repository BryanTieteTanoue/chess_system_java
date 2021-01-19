/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardGame;

/**
 *
 * @author Bryan
 */
public class Board {
    
    private int rows, columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Erro aco criar o tabuleiro: é necessário pelo menos uma linha e coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    
    public Piece piece(int row, int column) {
        if ( !positionExists(row, column)) {
            throw new BoardException("A posição não esta no tabuleiro");
        }
        return pieces[row][column];
    }
    
    public Piece piece(Position position) {
        if ( !positionExists(position)) {
            throw new BoardException("A posição não esta no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("Já tem uma peça na posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;  //por ser "protected" podemos acessar livremente já que está no mesmo pacote
    }
    
    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    
    private boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }
    
    public boolean thereIsAPiece(Position position){
        if ( !positionExists(position)) {
            throw new BoardException("A posição não esta no tabuleiro");
        }
        return piece(position) != null;
    }
    
}
