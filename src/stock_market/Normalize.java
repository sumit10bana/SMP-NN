
package stock_market;

import java.util.Vector;

public class Normalize {
    
    public static double mean;
    public Vector normal( Vector a )
    {
        Vector ans = new Vector();
        
        Object y;
        String s;
       
        ans.clear();
        
        double f1 , f2;
        
        double nn = 0;
        
         for(Object object : a ) {
           
            Vector vv = (Vector)object;
            Vector put = new Vector();
            
            for( int j = 0; j < 3; j++ ) {
             y = vv.get(j);
             s =  y.toString();
             f1 = Double.valueOf(s).doubleValue(); 
             if( f1 > mean )
             mean =  f1;
             nn++;
            }
         
        }  
        
       
         for(Object object : a ) {
           
            Vector vv = (Vector)object;
            Vector put = new Vector();
            for( int j = 0; j < 3; j++ ) {
             y = vv.get(j);
             s =  y.toString();
             f1 = Double.valueOf(s).doubleValue(); 
             f2 =  (double)( (double)f1 / ( (double)mean  ) );
             put.add( f2 );
           
            }
            ans.add( put );
        }  
        
         Object obje;
         int cou = 702;
       
        return ans;
    }
}
