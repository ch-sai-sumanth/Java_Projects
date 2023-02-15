import java.util.Scanner;

//Lives : o o o
//Input : X
//Word :  hello -> .ell.
//not used : abcd . f . .
//----------------------------
public class HangManGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Starting the game");
        String[] wordList = { "input","output","mouse","keyboard","computer","printer","ram","cpu"};

        String randomWord=wordList[(int) (Math.random() * wordList.length)];
        System.out.println("HINT : The word is of "+randomWord.length()+" letters");

        //creating a char array for storing the letters
        char[] letters=new char[randomWord.length()];

        String notUsed="abcdefghijklmnopqrstuvwxyz";

        //inserting (dots) in char array
        for(int i=0;i<letters.length;i++)
             letters[i]='.';

        int lives=3;

        while(lives>0)
        {
            System.out.print("Lives: ");
            for(int i=0;i<lives;i++)
                System.out.print("O ");

            System.out.println();


            boolean isGuessedCorrect=false;
            System.out.print("Input a letter: ");
            System.out.println();
            char l=sc.next().charAt(0);

            for(int i=0;i<randomWord.length();i++)
            {
                if(l==randomWord.charAt(i)){
                    letters[i]=l;
                    isGuessedCorrect=true;
                    notUsed=notUsed.replace(l,'.');
                }
            }

            if(!isGuessedCorrect)
                lives--;

            for(int i=0;i<letters.length;i++)
            {
                System.out.print(letters[i]);
            }
            System.out.println();

            boolean isGameFinished=true;
            for(int i=0;i<letters.length;i++)
            {
                if(letters[i]=='.')
                    isGameFinished=false;
            }
          
            System.out.println(notUsed);

            if(isGameFinished)
            {
                System.out.println("******  You Won the game ******");
                break;
            }
            System.out.println("-----------------------");
            if(lives==0)
            {
                System.out.println("You lost the game");
            }

        }
        sc.close();
        System.out.println("Game finished");

    }
}
