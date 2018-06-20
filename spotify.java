import java.io.IOException;
//Sort the letters in the string s by the order they occur in the second string
class SpotifyApp
{   

    public static void main(String[] args) throws IOException
    {
        String s1 = "weather";
        String s2 = "therapyw";
       String myString = sortByString(s1, s2);
       System.out.println(myString);

       String s3 = "good";
       String s4 = "odg";
        String myString2 = sortByString(s3, s4);
        System.out.println(myString2);

    }
    //----------------------------------------------------------------
    public static String sortByString (String s, String t){
        String finalString = "";
        for(int i = 0; i< t.length(); i++){
            char c = t.charAt(i);

            for(int j = 0; j<s.length();j++){
                char d = s.charAt(j);
                if(c == d){
                 finalString += c;   
                }
            }
        }

        return finalString;
    }
}