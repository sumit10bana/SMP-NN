
package stock_market;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class STOCK_MARKET {

    public static FileReader fp;
    public static String Date;
    public static  int set=0;
    public static String fileName;
    
    public void setFileName(String ss) {
        fileName = ss;
    }
    
    public static void Training() throws IOException {
        Vector input_data = new Vector(  );
        fp = new FileReader(fileName);
        Data_Cleaning oo = new Data_Cleaning();
        input_data = oo.CLean();
        
        
     Vector norm;
     Normalize ob = new Normalize();
     norm = ob.normal( input_data );
     Training obj;
     
      obj = new Training();
      obj.train_func( norm );
        
    }
    public static void func() throws IOException
    {
        
        
         
        fp = new FileReader(fileName);
        BufferedReader br = new BufferedReader( fp );
        String s , s1 , s2;
        int n = 0;
        String[] str;
        int cou = 0;
        Vector vv;
        
       System.out.println(Date);
        while(  ( s = br.readLine() ) != null )
        {
           
  
               n++;
               if( n == 1 )
                    continue;
             
               
                StringTokenizer tok1 = new StringTokenizer( s );
                str = new String[ tok1.countTokens() ];
                int i = 0 , len;
                while( tok1.hasMoreTokens() ) {
                     s1 = tok1.nextToken();
                     len = s1.length();
                     s1 = s1.substring(1 , len - 3);
                     s1 = s1.trim();
   

                     Date = Date.trim();
                    //  System.out.println(Date);
                     
                     System.out.println("s1 = " + s1);
                     if( Date.equalsIgnoreCase(s1) ) {
                       
                        System.out.println("matches");
                           Training.index = n - 1;
                           set=1;
                     }
                   
                     i++;
                     if( i == 1 )
                         break;
                }
                
               
        }
        if(set!=1)
           System.out.print("can not be predicted");
        else
        {
        Training.Calculate_Result();
        }
    }
     
}
