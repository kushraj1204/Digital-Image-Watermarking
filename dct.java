/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watermark;

import static java.lang.Math.sqrt;

/**
 *
 * @author Kush
 */
public class dct {
    
    public static double[]  DCT1(double[] data)
        {
            double[] result = new double[data.length];
            double c = Math.PI / (2.0 * data.length);
            double scale = Math.sqrt(2.0 / data.length);

            for (int k = 0; k < data.length; k++)
            {
                double sum = 0;
                for (int n = 0; n < data.length; n++)
                    sum += data[n] * Math.cos((2.0 * n + 1.0) * k * c);
                result[k] = scale * sum;
            }

            data[0] = result[0] / sqrt(2);
            for (int i = 1; i < data.length; i++)
                data[i] = result[i];
            
            return data;
        }

        /// <summary>
        ///   Inverse Discrete Cosine Transform.
        /// </summary>
        /// 
        public static double[] IDCT1(double[] data)
        {
            double[] result = new double[data.length];
            double c = Math.PI / (2.0 * data.length);
            double scale = Math.sqrt(2.0 / data.length);

            for (int k = 0; k < data.length; k++)
            {
                double sum = data[0] / sqrt(2);
                for (int n = 1; n < data.length; n++)
                    sum += data[n] * Math.cos((2 * k + 1) * n * c);

                result[k] = scale * sum;
            }

            for (int i = 0; i < data.length; i++)
                data[i] = result[i];
        return data;
        }


        /// <summary>
        ///   Forward 2D Discrete Cosine Transform.
        /// </summary>
        /// 
        public static double[][] DCT2(double[][] data)
        {
            int rows = data.length;
            int cols = data[0].length;

            double[] row = new double[cols];
            double[] col = new double[rows];

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < row.length; j++)
                    row[j] = data[i][j];

                row=DCT1(row);

                for (int j = 0; j < row.length; j++)
                    data[i][j] = row[j];
            }

            for (int j = 0; j < cols; j++)
            {
                for (int i = 0; i < col.length; i++)
                    col[i] = data[i][j];

               col= DCT1(col);

                for (int i = 0; i < col.length; i++)
                    data[i][j] = col[i];
            }
            return data;
        }
 public static double[][] IDCT2(double[][] data)
        {
            int rows = data.length;
            int cols = data[0].length;

            double[] row = new double[cols];
            double[] col = new double[rows];

            for (int j = 0; j < cols; j++)
            {
                for (int i = 0; i < row.length; i++)
                    col[i] = data[i][j];

                col=IDCT1(col);

                for (int i = 0; i < col.length; i++)
                    data[i][j] = col[i];
            }

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < row.length; j++)
                    row[j] = data[i][j];

                row=IDCT1(row);

                for (int j = 0; j < row.length; j++)
                    data[i][j] = row[j];
            }
            return data;
        }

    
}
