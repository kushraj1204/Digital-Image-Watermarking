/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watermark;

import static java.lang.Math.log10;
import static java.lang.Math.sqrt;

/**
 *
 * @author Kush
 */
public class parameters {
    
     public static double mse(double[][] img1,double[][] img2)
    {
        
        double mse,noise;
        noise=0;
        for(int i=0;i<img1.length;i++)
        {   for(int j=0;j<img2[0].length;j++)
            {   
                noise += (img1[i][j] - img2[i][j]) * (img1[i][j] - img2[i][j]);
               
            }
        }
        mse=noise/(img1.length*img1[0].length);
        
    return mse;
    }
     
     
     
     public static double nc(double[][] img1,double[][] img2)
     {  
         double nc,a=0,b=0,c=0;
         for(int i=0;i<img1.length;i++)
        {   for(int j=0;j<img2[0].length;j++)
            {   
                a=a+(img1[i][j]*img2[i][j]);
                b=b+(img1[i][j]*img1[i][j]);
                c=c+(img2[i][j]*img2[i][j]);
                if(img1[i][j]<0)
                    System.out.println(img1[i][j]+"    1 "+i+" "+j);
                if(img2[i][j]<0)
                    System.out.println(img2[i][j]+"    2 "+i+" "+j);
               
            }
        
     }
     //System.out.println(a+" "+b+" "+c);
    nc=a/(sqrt(b)*sqrt(c));
         
         
         return nc; 
     
     } 
}
