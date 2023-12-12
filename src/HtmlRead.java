import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {

        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;

            Scanner scan = new Scanner(System.in);
            System.out.println("enter your keyword:");
            String keyword = scan.nextLine();

            while ( (line = reader.readLine()) != null ) {

                //System.out.println(line);
                if(line.contains("href=")) {
                    int start = line.indexOf("href");

                    String link = line.substring(start+6);
                    //System.out.println(link);

                        int singleQuote = link.indexOf("'");
                        //System.out.println(singleQuote);
                        int doubleQuote = link.indexOf('"');
                        //System.out.println(doubleQuote);

                        if (singleQuote==-1){
                            //int end = link.indexOf('"');
                            String newLink = link.substring(0, doubleQuote);
                            if(newLink.contains("https")||link.contains("www")){
                                if(newLink.contains(keyword)){
                                    System.out.println(newLink);
                                }
                            }
                        }else if (doubleQuote == -1){
                            //int end = link.indexOf("'");
                            String newLink = link.substring(0, singleQuote);
                            if(newLink.contains("https")||link.contains("www")){
                                if(newLink.contains(keyword)){
                                    System.out.println(newLink);
                                }
                            }
                        }else if (singleQuote<doubleQuote){
                            String newLink = link.substring(0, singleQuote);
                            if(newLink.contains("https")||link.contains("www")){
                                if(newLink.contains(keyword)){
                                    System.out.println(newLink);
                                }                            }
                        }else{
                            String newLink = link.substring(0, doubleQuote);
                            if(newLink.contains("https")||link.contains("www")){
                                if(newLink.contains(keyword)){
                                    System.out.println(newLink);
                                }                            }
                        }


                }
            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

}

//contains method - checks if char sequence is in a string
//contains(CharSequence

//indexOf(String str)
//returns the index within the string of the first occurrence of the specified substring

//indexOf(String str, int fromIndex)
//starts at the fromIndex-th character

//lastIndexOf(String str)
//returns index of last occurrence

//substring(int beginIndex)
//returns a string that is a substring of this string