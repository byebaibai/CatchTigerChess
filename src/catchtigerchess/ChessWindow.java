/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchtigerchess;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import mouseclick.ChessClick;
/**
 *
 * @author heyanbai
 */
public class ChessWindow extends JFrame {
    
    public static ChessBoarder chessBoarder;
    private static String PlayerNow;
    ChessBoardCanvas chessCanvas;
    /**
     * Creates new form ChessWindow
     */
    public ChessWindow() {
        initComponents();
        PlayerNow = new String("Tiger");
        chessBoarder = new ChessBoarder();
        
        this.setTitle("CatchTigerChess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        chessCanvas = new ChessBoardCanvas();
        chessCanvas.setBounds(0, 0, 500, 700);
        
        chessCanvas.repaint();
        chessCanvas.addMouseListener(new ChessClick());
        gameBoard.add(chessCanvas);
    }
    public static void setPlayer(){
        System.out.println(PlayerNow);
        if(PlayerNow.equals("Tiger")) PlayerNow = "Dog";
        else PlayerNow = "Tiger";
    }
    public static String getPlayer(){
        return PlayerNow;
    }
    public static ChessPieces[][] getChessPieces(){
        return chessBoarder.getChessPieces();
    }
    
    public static void eatChess(int x, int y){
        if(PlayerNow.equals("Tiger")){
            if(x-1>=0 && x-1<=4 && x+1>=0 &&x+1<=4){
                if( (chessBoarder.hasRoad(x,y,x-1,y) && chessBoarder.hasPiece(x-1, y)) && (chessBoarder.hasPiece(x+1, y)&& chessBoarder.hasRoad(x,y,x+1,y))){
                chessBoarder.eatPiece(x-1, y);
                chessBoarder.eatPiece(x+1, y);
                chessBoarder.killDog(2);
                }
            }
            if(y-1>=0 &&y-1<=6 && y+1>=0&&y+1<=6){
                if((chessBoarder.hasRoad(x,y,x,y-1) && chessBoarder.hasPiece(x, y-1)) && (chessBoarder.hasPiece(x, y+1) && chessBoarder.hasRoad(x,y,x,y+1))){
                chessBoarder.eatPiece(x, y-1);
                chessBoarder.eatPiece(x, y+1);
                chessBoarder.killDog(2);
                } 
            }
            if(x-1>=0 && x-1<=4 && x+1>=0 && x+1<=4 && y-1>=0 &&y-1<=6 && y+1>=0&&y+1<=6){
                if((chessBoarder.hasRoad(x,y,x-1,y-1) && chessBoarder.hasPiece(x-1, y-1)) && (chessBoarder.hasPiece(x+1, y+1) && chessBoarder.hasRoad(x,y,x+1,y+1))){
                chessBoarder.eatPiece(x-1, y-1);
                chessBoarder.eatPiece(x+1, y+1);
                chessBoarder.killDog(2);
                }
               if((chessBoarder.hasRoad(x,y,x-1,y+1) && chessBoarder.hasPiece(x-1, y+1)) && (chessBoarder.hasPiece(x+1, y-1) && chessBoarder.hasRoad(x,y,x+1,y-1))){
                chessBoarder.eatPiece(x-1, y+1);
                chessBoarder.eatPiece(x+1, y-1);
                chessBoarder.killDog(2);
                }
            }
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameBoard = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gameBoard.setBackground(new java.awt.Color(60, 255, 65));
        gameBoard.setPreferredSize(new java.awt.Dimension(375, 525));

        javax.swing.GroupLayout gameBoardLayout = new javax.swing.GroupLayout(gameBoard);
        gameBoard.setLayout(gameBoardLayout);
        gameBoardLayout.setHorizontalGroup(
            gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        gameBoardLayout.setVerticalGroup(
            gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(525, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gameBoard;
    // End of variables declaration//GEN-END:variables
}
