import java.util.Arrays;

public class TrapWater {
    public static void main(String[] args) {
        int [] height={4,2,0,6,3,2,5};
        int [] maxLeft=new int[height.length];
        int [] maxRight=new int[height.length];
        //Creating maxLeft array
        maxLeft[0]=height[0];
        for (int i=1;i<height.length;i++){
            // Comparing the values to store the previous maximum value of a column
            maxLeft[i]=Math.max(height[i], maxLeft[i-1]);
        }
        //Creating maxRight array
        maxRight[height.length-1]=height[height.length-1];
        for (int i=maxRight.length-2;i>=0;i--){
            // Comparing the values to store the next maximum value of a column
            maxRight[i]=Math.max(height[i],maxRight[i+1]);
            // Here, notice how I've used maxRight[i+1] instead of maxRight[i-1] the simple reason here is 'cuz
            // we are using the loop in reverse manner
        }
        // Now to calculate the totalTrappedWater we have to use the formula totalTrappedWater= Water level - column size
        // (height[i]) So, we need two new variables that is total trapped water and water level

        int totalTrappedWater=0;
        int waterLevel=0;
        for(int i=0;i<height.length;i++){
            waterLevel=Math.min(maxLeft[i],maxRight[i]);
            totalTrappedWater += waterLevel-height[i];
        }
        // Finally we have got the solution
        /*
                Here is the DryRun of the code if you need it
                    left[0]=height[0] = 4
                    left[1]=max(height[1],left[0]) =4
                    left[2]=max(height[2],left[1]) =4
                    left[3]=max(height[3],left[2]) =6
                    left[4]=max(height[4],left[3]) =6
                    left[5]=max(height[5],left[4]) =6
                    left[6]=max(height[6],left[5]) =6

                    left[] ={4,4,4,6,6,6,6}

                    right[6]=height[6]=5
                    right[5]=max(height[5],right[6]) =5
                    right[4]=max(height[4],right[5]) =5
                    right[3]=max(height[3],right[4]) =6
                    right[2]=max(height[2],right[3]) =6
                    right[1]=max(height[1],right[2]) =6
                    right[0]=max(height[0],right[1]) =6

                    right[]={6,6,6,6,5,5,5}

                    now for the last loop

                   i=0
                   maxvalue= min(left[0],right[0]) = min(4,6) =4
                   total value= 0+(4-4)=0

                   i=1
                   maxvalue= min(left[1],right[1]) = min(4,6) =4
                   total value= 0+(4-2)=2

                   i=2
                   maxvalue= min(left[2],right[2]) = min(4,6) =4
                   total value= 2+(4-0)=6

                   i=3
                   maxvalue= min(left[3],right[3]) = min(6,6) =6
                   total value= 6+(6-6)=6

                   i=4
                   maxvalue= min(left[4],right[4]) = min(6,5) =5
                   total value= 6+(5-3)=8

                   i=5
                   maxvalue= min(left[5],right[5]) = min(6,5) =5
                   total value= 8+(5-2)=11

                   i=6
                   maxvalue= min(left[6],right[6]) = min(6,5) =5
                   total value= 11+(5-5)=11
           */
        System.out.println(totalTrappedWater);

        // 15-09-2024. Thank you!! Have a nice day :)

    }
}
