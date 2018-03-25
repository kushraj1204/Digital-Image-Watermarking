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
public class matrixopn {
    double mat[][];
    
    double[][] getLL(double matrix[][])
    {   int rows=(matrix.length)/2;
        int columns=(matrix[0].length)/2;
        mat=new double[rows][columns];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {    
                mat[i][j]=matrix[i][j];
            }
        }
        return mat;
    }
        
        double[][] getHL(double matrix[][])
    {   int rows=(matrix.length)/2;
        int columns=(matrix[0].length)/2;
        mat=new double[rows][columns];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {    
                mat[i][j]=matrix[i][j+columns];
            }
        }
        return mat;
    }
    
        
        
        
            double[][] getLH(double matrix[][])
    {   int rows=(matrix.length)/2;
        int columns=(matrix[0].length)/2;
        mat=new double[rows][columns];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {    
                mat[i][j]=matrix[i+rows][j];
            }
        }
        return mat;
    }
            
            
            
                double[][] getHH(double matrix[][])
    {   int rows=(matrix.length)/2;
        int columns=(matrix[0].length)/2;
        mat=new double[rows][columns];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {    
                mat[i][j]=matrix[i+rows][j+columns];
            }
        }
        return mat;
    }
    
    
          double[][] getoriginal(double LL[][],double HL[][], double LH[][],double HH[][] )
    {   int rows=(LL.length)*2;
        int columns=(LL[0].length)*2;
        mat=new double[rows][columns];
        for(int i=0;i<(rows)/2;i++)
        {
            for(int j=0;j<(columns)/2;j++)
            {    
                mat[i][j]=LL[i][j];
                mat[i][j+LL[0].length]=HL[i][j];
                mat[i+LL.length][j]=LH[i][j];
                mat[i+LL.length][j+LL[0].length]=HH[i][j];
            }
        }
        return mat;
    }          
                
    
    
    
}
