package com.lyn.learn.jianzhioffer;

public class GetNumberOfK {

    public int getNumberOfK(int[] array, int k){
        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);
        return lastK - firstK + 1 < 0 ? 0 : lastK - firstK + 1;
    }

    int indexOfFirstK = 0;
    public int getFirstK(int[] array, int k, int start, int end){

        if(start + 1 >= end){
            if(array[start] == k || array[end] == k){
                return indexOfFirstK;
            }else{
                return 0;
            }
        }

        int mid = start + (end - start) / 2;
        indexOfFirstK = mid;
        if(array[mid] < k ){
            indexOfFirstK = getFirstK(array, k, mid, end);
        }else if(array[mid] > k){
            indexOfFirstK = getFirstK(array, k, start, mid);
        }else{
            if(mid - 1 > start){
                if(array[mid - 1] == k){
                    indexOfFirstK = getFirstK(array, k, start, mid);
                }
            }else if(mid - 1 == start){
                if(array[start] == k){
                    indexOfFirstK = start;
                }
            }
        }
        return indexOfFirstK;

    }

    int indexOfLastK = 0;
    public int getLastK(int[] array, int k, int start, int end){
        if(start + 1 >= end){
            if(array[start] == k || array[end] == k){
                return indexOfLastK;
            }else{
                return -2;
            }
        }

        int mid = start + (end - start) / 2;
        indexOfLastK = mid;
        if(array[mid] < k ){
            indexOfLastK  = getLastK(array, k, mid, end);
        }else if(array[mid] > k){
            indexOfLastK  = getLastK(array, k, start, mid);
        }else{
            if(mid + 1 < end){
                if(array[mid + 1] == k){
                    indexOfLastK  = getLastK(array, k, mid, end);
                }
            }else if(mid + 1 == end){
                if(array[end] == k){
                    indexOfLastK = end;
                }
            }
        }
        return indexOfLastK ;
    }

    public static void main(String[] args){
        GetNumberOfK getNumberOfK = new GetNumberOfK();

        int[] array = {1,2,3,4,5,5,5,6,7};
        System.out.println(getNumberOfK.getNumberOfK(array, 8));
    }
}
