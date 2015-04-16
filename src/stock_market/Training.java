
package stock_market;

import java.util.Random;
import java.util.Vector;
import java.util.*;
import java.awt.*;
import javax.swing.*;


public class Training {
// parameters of HMM  
   public static double[][][][] weight = new double[4][6][6][4];
   public static double[][][] theta = new double[6][6][4];
   public static double[][][][] dw =  new double[4][6][6][4];
   public static double[][][] dth = new double[6][6][4];
   public static double[] error = new double[4];
   public static double[] gradient = new double[4];
   public static double[] hid_out = new double[6];
   public static double[] hid_out1 = new double[6];
   public static double[][][] error_gradient = new double[6][6][4];
   public static double[] v  = new double[4];
     public static int epoch2;
     public static String st;
   public static String data_arr[][]=new String[5][7];
    public static String error1;
   public static int Epoch_count = 0;
   public static double alpha ;
  
   public static int index; 
   public static Vector input;
   static int train;
   public static String value;
      
    public static void HMM_Model( Vector in , Vector outp )
    {
       int k=0;
      
      
        Vector states, hidden_states;
        double x;
        Object y;
        String s;
        double[] real_out = new double[4];
        
        
        double[] desired_out  = new double[4];
        double f1;
        for( int j = 0; j < 3; j++ ) {
             y = in.get(j);
             s =  y.toString();
             f1 = Double.valueOf(s).doubleValue(); 
             v[j] = f1;
        }
        
        for( int j = 0; j < 3; j++ ) {
             y = outp.get(j);
             s =  y.toString();
             f1 = Double.valueOf(s).doubleValue(); 
             desired_out[j] = f1;
        }
        
        
        for (int sat = 1; sat < 5; sat++ ) {
                x = 0;
                
                for (int j = 0; j < 3; j++ ) {
                    f1 = v[j];
                    x = x + f1 * ( weight[j+1][sat][0][0] );
                }
            hid_out1[sat] = sigmoid( x - theta[sat][0][0]);
        }
        
        double X;
        for ( int outn = 1; outn < 5; outn++ ) {
                x = 0;
                for ( int hidd = 1; hidd < 3; hidd++ ) {
                    x += hid_out1[hidd] * weight[0][hidd][outn][0];
                }
                X = x - theta[0][outn][0];
                hid_out[outn] = sigmoid( X );
                
        }
        
        for ( int outn = 1; outn <= 3; outn++ ) {
            x = 0;
            for (int j = 1; j < 5; j++ ) {
        
                    x += hid_out[j] * weight[0][0][j][outn];
               
            }
            X = x - theta[0][0][outn];
            real_out[outn - 1] = sigmoid( X );
            error[outn - 1] = desired_out[outn - 1] - real_out[outn - 1];
            error_gradient[0][0][outn] = real_out[outn-1] * ( 1 -  real_out[outn-1] ) * error[outn -1 ];
           
     

        }
        double err;
        for ( int outn = 1; outn <= 5; outn++ ) {
            err = 0;
            for (int j = 1; j <= 3; j++ ) {
        
                    err = err + error_gradient[0][0][j] * weight[0][0][outn][j];
            }
            error_gradient[0][outn][0] = hid_out[outn] * ( 1 - hid_out[outn] ) * err ;
        }
        
        
        for ( int hid = 1; hid < 6; hid++ ) {
            
            err = 0;
            for ( int i = 1; i <= 5; i++ ) {
                err = err + error_gradient[0][i][0] * weight[0][hid][i][0];
            }
            error_gradient[hid][0][0] = hid_out1[hid] * ( 1 - hid_out1[hid] ) * err ;
        }
        
   
        weight_update();
        theta_update();
        
  
    }
    public static  double sigmoid( double x )
    {
        double ret,ret1;
       
        ret = (double) ((double)1 / (double)( 1  + Math.exp( -x ) ));
       
        double a=Math.exp(x);
        double b=Math.exp(-x);
        ret1=(a-b)/(a+b);
        return ret;
    }
    public static  void random_weight()
    {
        Random r = new Random();
        for (int i = 0; i < 4; i++ )
            for ( int j = 0; j < 6; j++ )
                for ( int k = 0; k < 6; k++ )
                    for ( int m = 0; m < 4; m++ )
                            weight[i][j][k][m] = r.nextDouble();
    }
    
    public static void fillRandTheta()
    {
        Random rnd = new Random();
        for(int i = 0; i < 6; i++) 
             for ( int j = 0; j < 6; j++ )
                for ( int k = 0; k < 4; k++ )
                theta[i][j][k] = rnd.nextDouble();
           
    }
    public static  void weight_update()
    {
        
       for ( int i = 1; i <= 5; i++  )
           for (int j = 1; j <= 3; j++ )
               weight[0][0][i][j] += ( alpha * hid_out[i] * error_gradient[0][0][j] ) ;
       
       for ( int i = 1; i <= 5; i++  )
           for (int j = 1; j <= 5; j++ )
               weight[0][i][j][0] += ( alpha * hid_out1[i] * error_gradient[0][j][0] ) ;
       
       
       
       for ( int i = 1; i <= 3; i++ )
           for ( int j = 1; j <= 5; j++ )
               weight[i][j][0][0] += ( alpha * v[i-1] * error_gradient[j][0][0] ) ;
       
       
    }
    
    
    public static void theta_update()
    {
        for ( int i = 1; i <= 3; i++ )
            theta[0][0][i] = theta[0][0][i] + ( alpha * -1 * error_gradient[0][0][i] );
        
        for ( int i = 1; i <= 5; i++ )
            theta[0][i][0] = theta[0][i][0] + ( alpha * -1 * error_gradient[0][i][0] );
        
        
        for ( int i = 1; i <= 5; i++ )
            theta[i][0][0] = theta[i][0][0] + ( alpha * -1 * error_gradient[i][0][0] );
        
        
       
    }
    
    public static void error( Vector in , Vector outp )
    {
       int k=0;
      
      
        Vector first_layer;
        double x;
        Object y;
        String s;
        double[] real_out = new double[4];
        
        
        double[] desired_out  = new double[4];
        double f1;
        for( int j = 0; j < 3; j++ ) {
             y = in.get(j);
             s =  y.toString();
             f1 = Double.valueOf(s).doubleValue(); 
             v[j] = f1;
        }
        
        for( int j = 0; j < 3; j++ ) {
             y = outp.get(j);
             s =  y.toString();
             f1 = Double.valueOf(s).doubleValue(); 
             desired_out[j] = f1;
        }
        
        
        for (int sat = 1; sat <= 5; sat++ ) {
                x = 0;
                
                for (int j = 0; j < 3; j++ ) {
                    f1 = v[j];
                    x = x + f1 * ( weight[j+1][sat][0][0] );
                }
            hid_out1[sat] = sigmoid( x - theta[sat][0][0]);
        }
        
        double X;
        for ( int outn = 1; outn <= 5; outn++ ) {
                x = 0;
                for ( int hidd = 1; hidd <= 5; hidd++ ) {
                    x += hid_out1[hidd] * weight[0][hidd][outn][0];
                }
                X = x - theta[0][outn][0];
                hid_out[outn] = sigmoid( X );
                
        }
        
        for ( int outn = 1; outn <= 3; outn++ ) {
            x = 0;
            for (int j = 1; j <= 5; j++ ) {
        
                    x += hid_out[j] * weight[0][0][j][outn];
               
            }
            X = x - theta[0][0][outn];
            real_out[outn - 1] = sigmoid( X );
            error[outn - 1] = desired_out[outn - 1] - real_out[outn - 1];
            error_gradient[0][0][outn] = real_out[outn-1] * ( 1 -  real_out[outn-1] ) * error[outn -1 ];
           
     

        }
        double err;
        for ( int outn = 1; outn <= 5; outn++ ) {
            err = 0;
            for (int j = 1; j <= 3; j++ ) {
        
                    err = err + error_gradient[0][0][j] * weight[0][0][outn][j];
            }
            error_gradient[0][outn][0] = hid_out[outn] * ( 1 - hid_out[outn] ) * err ;
        }
        
        
        for ( int hid = 1; hid < 6; hid++ ) {
            
            err = 0;
            for ( int i = 1; i <= 5; i++ ) {
                err = err + error_gradient[0][i][0] * weight[0][hid][i][0];
            }
            error_gradient[hid][0][0] = hid_out1[hid] * ( 1 - hid_out1[hid] ) * err ;
        }
        
   
        weight_update();
        theta_update();
        
  
    }
    public static void calculate()
    {
         Vector in , out;
      
      for ( int epoch = 0; epoch <= epoch2; epoch++ ) {
          
          
        for ( int i = 0; i < train - 1; i++ ) {
            in = (Vector)input.get(i);
            out =(Vector)input.get(i+1);
   
            error( in , out  );
          
            
        }
       
       

      }
    }
    public static  void train_func( Vector vv )
    {
        
        input = vv;
       
        train =( 7 * vv.size() ) / 10;
        random_weight();
        fillRandTheta();
        System.out.println("Training started");
        
        calculate();
        System.out.println("Training Over");
    
    }
    
     public static void Calculate_Result()
        {
            
        index = index - 1;
        Vector inn = (Vector)input.get( index );
        double[] arr = new double[3];
        double[] desired_out  = new double[4];
        double f1;
        String s;
        Object y;
        for( int j = 0; j < 3; j++ ) {
             y = inn.get(j);
             s =  y.toString();
             f1 = Double.valueOf(s).doubleValue(); 
             
             arr[j] = f1;
        }
        for ( int outn = 1; outn <= 3; outn++ ) {
          //  System.out.println(arr[outn-1]);
            
        }
        double x;
        for (int sat = 1; sat <= 5; sat++ ) {
                x = 0;
                
                for (int j = 0; j < 3; j++ ) {
                    f1 = arr[j];
                    x = x + f1 * ( weight[j+1][sat][0][0] );
                }
            hid_out1[sat] = sigmoid( x - theta[sat][0][0]);
        }
        
        double X;
         double[] outpu = new double[3];
        for ( int outn = 1; outn <= 5; outn++ ) {
                x = 0;
                for ( int hidd = 1; hidd <= 5; hidd++ ) {
                    x += hid_out1[hidd] * weight[0][hidd][outn][0];
                }
                X = x - theta[0][outn][0];
                hid_out[outn] = sigmoid( X );
               
        }
        
        
        for ( int outn = 1; outn <= 3; outn++ ) {
            outpu[outn-1] = 0;
        }
        
        for ( int outn = 1; outn <= 3; outn++ ) {
                x = 0;
                for ( int hidd = 1; hidd <= 5; hidd++ ) {
                    x += hid_out[hidd] * weight[0][0][hidd][outn];
                }
                X = x - theta[0][0][outn];
                outpu[outn-1] = sigmoid( X );
             //   System.out.println(outpu[outn-1] + " f");
               
        }
        
        for ( int outn = 1; outn <= 3; outn++ ) {
            //System.out.println("palash");
        // System.out.println(outpu[outn-1]);
        }
        
        Vector real = (Vector)input.get( index  );
        double[] store = new double[3];
         for( int j = 0; j < 3; j++ ) {
             y = real.get(j);
             s =  y.toString();
             f1 = Double.valueOf(s).doubleValue(); 
             store[j] = f1;
        }
         
         double m = Normalize.mean;
      
        
         
         value = "Calculated_Value           Real_Vale\n";
         String ss;
         
         
         data_arr[3][0]=date_input.y;
         int j1=1;
         if(date_input.y.equalsIgnoreCase("13-May-14"))
         {
           for ( int i = 0; i < 3; i++ )
         {
            
            ss =  outpu[i] * m  +   "    " + store[i] * m  + "   ";
            data_arr[3][j1++]=""+outpu[i] * m;
            data_arr[3][j1++]="-";
            ss += "\n";
            value += ss;
         }
     
      predictedResult my1=new predictedResult(data_arr);
      
      my1.setVisible(true);
      my1.setSize(1050,590);
     } else
        {
         for ( int i = 0; i < 3; i++ )
         {
            
            ss =  outpu[i] * m  +   "    " + store[i] * m  + "   ";
          data_arr[3][j1++]=""+outpu[i] * m;
            data_arr[3][j1++]=""+store[i] * m;
            ss += "\n";
            value += ss;
         }
        
        predictedResult my1 = new predictedResult(data_arr);
      
       my1.setVisible(true);
       my1.setSize(1050,590);
        }    
        
    }
    
}
