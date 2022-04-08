
package J1.S.H211;

import java.util.Arrays;

public class ArrayIntList {
    private int[] elementData;
    private int size;
    ArrayIntList(){
        
    }
    ArrayIntList(int size ,int[]elementData){
        this.size=size;
        this.elementData=elementData;
    }
    public ArrayIntList fromCounts(){
        int Size = 0;
        int number = 0;
        for(int i=0; i<this.size;i+=2){
              Size+= Math.abs(this.elementData[i]);
        }
        int[] ArrayInt = new int[Size]; 
        for(int i=0; i<this.size;i+=2){
            
            
            for( int j=number; j<Math.abs(this.elementData[i])+number;j++){
                if(i!=this.size-1){
                    ArrayInt[j]=this.elementData[i+1];
                }
                else{
                    ArrayInt[j]=this.elementData[i];
                }
            }
            number += Math.abs(this.elementData[i]);
        }
        return new ArrayIntList(Size,ArrayInt);
    }
//3 2 4 1
    
    @Override
    public String toString() {
        return "ArrayIntList{" + "elementData=" + Arrays.toString(this.elementData) + ", size=" + size + '}';
    }


}
