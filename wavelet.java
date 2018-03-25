/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watermark;

/**
 *
 * @author Kush
 */
public class wavelet {
    
    double[][] forwardwavlet(double[][] img)
    {
         //BufferedImage bimg = ImageIO.read(new File("F:\\KUSH\\pics\\dv.jpg"));// reading the image
        int width          = img[0].length;
        int height         = img.length;
       
        double img1[][]=new double[height][width];//holds horizontal pass result
        double img2[][]=new double[height][width];//holds vertical pass result
        int halfwidth=width/2;
        int halfheight=height/2;
        // horizontal pass starts --
        for(int i=0;i<height;i++)
        {   
            for(int j=0;j<halfwidth;j++)
            {   
                    img1[i][j]=(img[i][2*j]+img[i][(2*j)+1]);
                    img1[i][j+halfwidth]=(img[i][2*j]-img[i][(2*j)+1]);
                   
            }
        }
        //--ends here
        
        
        //vertical pass starts||
           for(int i=0;i<width;i++)
        {   
            for(int j=0;j<halfheight;j++)
            {   
                
                    img2[j][i]=(img1[j*2][i]+img1[(j*2)+1][i]);
                
                    img2[j+halfheight][i]=(img1[j*2][i]-img1[(j*2)+1][i]);
            }
        }
           // ||ends here
        for(int i=0;i<width;i++)
        {   
            for(int j=0;j<height;j++)
            {   
                
                   img2[i][j]=img2[i][j]/2;
            }
        }
        return img2;
      
    }
    double[][] inversewavlet(double[][] img2)
    {
        
         int width          = img2[0].length;
        int height         = img2.length;
       
        double img1[][]=new double[height][width];//holds horizontal pass result
        double img[][]=new double[height][width];//holds vertical pass result
        int halfwidth=width/2;
        int halfheight=height/2;
    //Inverse DWT starts
    for(int i=0;i<width;i++)
        {   
            for(int j=0;j<height;j++)
            {   
                
                   img2[i][j]=img2[i][j]*2;
            }
        }
         
    
    
    
    //vertical pass
       for(int i=0;i<width;i++)
        {   
            for(int j=0;j<halfheight;j++)
            {   
                img1[2*j][i]=(img2[j][i]+img2[(j+halfheight)][i])/2;
                img1[(2*j)+1][i]=img2[j][i]-img1[2*j][i];
                   
            }
        }
       //ends
       
     
       
       
       //horizontal pass
        for(int i=0;i<height;i++)
        {   
            for(int j=0;j<halfwidth;j++)
            {   
                    img[i][2*j]=(img1[i][j]+img1[i][(j+halfwidth)])/2;
                    img[i][2*j+1]=img1[i][j]-img[i][2*j];
                   
            }
        }
        //ends
        
    
    
    
    return img;
    }
    
    
    
    
}
