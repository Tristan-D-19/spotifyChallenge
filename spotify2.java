import java.io.IOException;
// Decode a string by expanding the values contained within a bracket by its multiplier

class StackX
   {
   private int maxSize;
   private char[] stackArray;
   private int top;
//--------------------------------------------------------------
   public StackX(int s)       // constructor
      {
      maxSize = s;
      stackArray = new char[maxSize];
      top = -1;
      }
//--------------------------------------------------------------
   public void push(char j)  // put item on top of stack
      {
      stackArray[++top] = j;
      }
//--------------------------------------------------------------
      public void refresh(){


      }

//---------------------------------------------------------------
   public char pop()         // take item from top of stack
      {
      return stackArray[top--];
      }
//--------------------------------------------------------------
   public char peek()        // peek at top of stack
      {
      return stackArray[top];
      }
//--------------------------------------------------------------

public int size()         // return size
{ return top+1; }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
      {
      return (top == -1);
      }
//--------------------------------------------------------------
public char peekN(int n)  // return item at index n
{ return stackArray[n]; }      
//--------------------------------------------------------------
public void displayStack(String s)
{
System.out.print(s);
System.out.print("Stack (bottom-->top): ");
for(int j=0; j<size(); j++)
   {
   System.out.print( peekN(j) );
   System.out.print(' ');
   }
System.out.println("");
}      
//--------------------------------------------------------------
   }  // end class StackX
///////////////////////////////////////////////////////////////////////////////
class BracketSplitter
   {
    private StackX theStack;
   private String input;                   // input string
   String word = "";
   int mul = 0; 
//--------------------------------------------------------------
   public BracketSplitter(String in)        // constructor
      {
        input = in; 
        int stackSize = input.length();
        theStack = new StackX(stackSize);
    
    }
//--------------------------------------------------------------

public void InToPost(String in)   // constructor
{
input = in;

}
//--------------------------------------------------------------
public String doTrans()      // decode
{
      
for(int j=0; j<input.length(); j++)      // for each char
   {
   char ch = input.charAt(j);            // get it


   switch(ch)
      {
      case '[':               // it's a left bracket
      
         theStack.push(ch);   // push it
         break;
      case ']':               // it's a right bracket
        String s = gotBracket(ch);        // go pop operators
       
        char temp = theStack.pop();
        
        mul = Character.getNumericValue(temp);
        
         word = expand(mul, s);
         break;
      default:                // must be an operand
      if(Character.isDigit(ch))                  // it's + or -
        {       
           
            if (mul == 0)
            mul = Character.getNumericValue(ch);
            else {

                for(int i = 0; i<word.length();i++){
                   
                    theStack.push(word.charAt(i));
                    
                   
                }
                word = ""; //reset word
                mul = Character.getNumericValue(ch);
            }
            gotMul(ch, 1);      // go pop operators
            break;
        }
       else 
         {
            word = word + ch; // write it to word
            
            break;
         }
      }  // end switch
   
   }  // end for

while( !theStack.isEmpty() )     // pop remaining opers
   {

   word = word + theStack.pop(); // write to word
   }

return word;                   // return word
}  // end doTrans()
//--------------------------------------------------------------
public  void gotMul(char opThis, int prec1)
{                                // got operator from input
   
while( !theStack.isEmpty() )
   {
   char opTop = theStack.pop();
   if( opTop == '[' )            // if it's a '('
      {
      theStack.push(opTop);      // restore '('
      break;
      }
   else                          // it's an operator
      {
      int prec2;                 // precedence of new op
        
      if(Character.isDigit(opTop))  // find new op prec

         prec2 = 1;
      else
         prec2 = 2;
      if(prec2 < prec1)          // if prec of new op less
         {                       //    than prec of old
            
         theStack.push(opTop);   // save newly-popped op
         break;
         }
      else                       // prec of new not less
      {
        theStack.push(opTop); 
        
         break;
      }
      }  // end else (it's an operator)
   }  // end while
theStack.push(opThis);           // push new operator
}  // end gotOp()
//--------------------------------------------------------------
public  String gotBracket(char ch)
{  
    String output = "";                         // got right bracket from input
while( !theStack.isEmpty() )
   {
   char chx = theStack.pop();
   if( chx == '[' )           // if popped '('
   {
    //    System.out.println("found closing bracket");
      break;  
                    }                 // we're done
   else if (Character.isDigit(chx))                      // if popped operator
     { 
        
        break;
     }
     else{
        word = chx + word ;  // word it
      output = output + chx;
     
     }
  
   }  // end while
   output =  word ;  // word it
   return output;
}  
//--------------------------------------------------------------
public String expand(int mul, String s){
    
    String output = word;
    StringBuilder builder = new StringBuilder();
    
    for(int i = 0;i< mul;i++)
    {
        builder.append(word);
    }

    output = builder.toString();
   
return output;
}

//---------------------------------------------------------------
   }  // end class BracketSplitter
////////////////////////////////////////////////////////////////   
class SpotifyApp2
{   
   
    public static void main(String[] args) throws IOException
    {
     String s1 = "4[ab]";
     String s2 = "2[b3[a]]";


     decodeString(s1);
     decodeString(s2);
    }
    //---------------------------------------------------------------
    public static void decodeString (String s){
        BracketSplitter theChecker = new BracketSplitter(s);
        String finalString = theChecker.doTrans(); 
        System.out.println(finalString);

    }


}