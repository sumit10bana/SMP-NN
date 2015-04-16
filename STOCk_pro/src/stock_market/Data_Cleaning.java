
package stock_market;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class Data_Cleaning {
    
    public Vector CLean() throws IOException
    {
        FileReader fp;
        Vector input_data = new Vector( );
        
        
        fp = STOCK_MARKET.fp;
        BufferedReader br = new BufferedReader( fp );
        String s , s1 , s2;
        int n = 0;
        String[] str;
        int cou = 0;
        Vector vv;
        while(  ( s = br.readLine() ) != null )
        {
               n++;
               if( n == 1 )
                    continue;
            
               
                Vector v = new Vector();
                
                
                s = s.substring( 17 );
                StringTokenizer tok1 = new StringTokenizer( s );
                str = new String[ tok1.countTokens() ];
                int i = 0 , len;
                while( tok1.hasMoreTokens() ) {
                     s1 = tok1.nextToken();
                     len = s1.length();
                     s1 = s1.substring(0 , len - 3);
                     str[i] = s1;
                     float f1 = Float.valueOf(s1.trim()).floatValue();
                  
                     v.add(s1);

                     i++;
                     if( i == 3 )
                         break;
                }
                
               
                input_data.add( v );
                
                cou++;
        }

        
        return input_data;
    }
    
    
    
}
