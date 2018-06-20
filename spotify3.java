import java.io.IOException;
import java.io.*;  
////////////////////////////////////////////////////////////////   
class SpotifyApp3
{   
   //Take in an input target coin value and evaluate a set of coins possible solution
    public static void main(String[] args) throws IOException
    {
        
        System.out.println("please enter a coin that you would like to evaluate: ");
        int target = getInt();
       int [] array = getSet();
       
       int answer = changePossibilities(target, array );
        System.out.println(answer);
    }
    //-----------------------------------------------------------------------------------
    public static int changePossibilities(int amount,int []coinDenom) {

        int size = coinDenom.length;

    int solutions = recCount(coinDenom,size,amount);
      
    return solutions;
    }
    //-----------------------------------------------------------------------------------
    public static int recCount( int coinSet[], int setSize, int target )   
    {
        
        if (target == 0) //base case 
            return 1;      
        
        if (target < 0) //incorrect solution
            return 0;
      
        if (setSize <=0 && target >= 1) //incorrect solution
            return 0; 
       
        // sum of coinset[size --] 
        return recCount( coinSet, setSize - 1, target ) + recCount( coinSet, setSize, target-coinSet[setSize-1] );
    }
    //----------------------------------------------------------------------------------------
    public static int [] getSet () throws IOException
    {

        System.out.println("enter number of coins");
        int size = getInt();
        int [] array = new int[size];
        
        for(int i = 0;i<=size-1;i++)
        {
           System.out.print("Enter coins ");
            array[i] = getInt();
        }
        
        return array;
    }

    //-------------------------------------------------------------
   public static int getInt() throws IOException
   {
   String s = getString();
   return Integer.parseInt(s);
   }
   //--------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
}