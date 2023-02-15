package TikTakToe;

import java.util.Random;
import java.util.Scanner;


abstract class Player
{
   String name;
   char mark;

   abstract void makeMove();
   
   boolean isValidMove(int row, int col)
   {
      if(row>=0 && row<=2 && col>=0 && col<=2)
      {
         if(TikTacToe.board[row][col]==' ')
         {
            return true;
         }
      }
      return false;
   }

}

class HumanPlayer extends Player    //sub class of Player

{
   HumanPlayer(String name, char mark)
   {
      this.name=name;
      this.mark=mark;
   }

   void makeMove()
   {
      Scanner sc=new Scanner(System.in);
      int row,col;
      do{
      System.out.println("Enter the row and col");
      row=sc.nextInt();
      col=sc.nextInt();
      }while(!isValidMove(row,col));

      TikTacToe.placeMark(row, col, mark);
   }
}

class ComputerPlayer extends Player  //sub class of Player

{

   ComputerPlayer(String name, char mark)
   {
      this.name=name;
      this.mark=mark;
   }
   void makeMove()
   {
      int row,col;
      do
      {
         Random r=new Random();
         row=r.nextInt(3);
         col=r.nextInt(3);
      }while(!isValidMove(row, col));

      TikTacToe.placeMark(row, col, mark);
   }
   
}


class TikTacToe
{
   static char[][] board;

   public TikTacToe() // constructor that allocates space to board
   {
      board=new char[3][3];
      initBoard();
   }

   void initBoard()  //initialization of board
   {
      for(int i=0;i<board.length;i++)
      {
         for(int j=0;j<board[0].length;j++)
         {
            board[i][j]=' ';
         }
      }
   }

   static void displayBoard()    //method that displays board
   {
      System.out.println("-------------");
      for(int i=0;i<board.length;i++)
      {
         System.out.print("| ");
         for(int j=0;j<board[0].length;j++)
         {
           System.out.print(board[i][j]+" | ");
         }
         System.out.println();
      System.out.println("-------------");
      }
   }

   static void placeMark(int row,int col,char mark)  //method that places mark with (row,col) on board

   {
      if(row>=0 && row<=2 && col>=0 && col<=2)
      {
         board[row][col]=mark;
      }
      else{
         System.out.println("Incalid Position");
      }
     
   }

//Checking conditions here
   static boolean checkColWin()
   {
      for(int col=0;col<=2;col++)
      {
         if(board[0][col]!=' ' && board[0][col]==board[1][col] && board[1][col]==board[2][col])
         {
            return true;
         }
      }
      return false; 
   } 

   static boolean checkRowWin()
   {
      for(int row=0;row<=2;row++)
      {
         if( board[row][0]!=' ' && board[row][0]==board[row][1] && board[row][1]==board[row][2])
         {
            return true;
         }
      }
      return false;
   }

   static boolean checkDiagWin()
   {
      if(board[0][0]!=' ' && (board[0][0]==board[1][1] && board[1][1]==board[2][2] ) || 
         board[0][2]!=' ' && (board[0][2]==board[1][1] && board[1][1]==board[2][0]) )
       {
         return true;
       }
       return false;
   }

   static boolean checkDraw()
   {
      for(int row=0;row<=2;row++)
      {
         for(int col=0;col<=2;col++)
         {
            if(board[row][col]==' ')
            {
               return false;
            }

         }
      }
      return true;
   }
}

//Main Class
public class LaunchGame {
   public static void main(String[] args) {
   
      TikTacToe t=new TikTacToe();
      
      Player p1=new HumanPlayer("sai", 'X');
      Player p2=new ComputerPlayer("AI",'O');

      Player cp;
      cp=p1;

      while(true)
      {
         System.out.println(cp.name +" turn ");
      cp.makeMove();

      TikTacToe.displayBoard();
      if(TikTacToe.checkColWin() || TikTacToe.checkRowWin() || TikTacToe.checkDiagWin())
      {
         System.out.println(cp.name +" has won the game");
         break;
      }
      else if(TikTacToe.checkDraw())
      {
         System.out.println("Game is Draw");
         break;
      }
      else
      {
         if(cp==p1)
            cp=p2;
         else
            cp=p1;
      }
      }
      
   }
}
