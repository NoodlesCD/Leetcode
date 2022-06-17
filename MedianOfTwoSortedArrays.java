/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = mergeArray(nums1, nums2);
        
        if (arr.length % 2 != 0) {
            double pos = arr.length / 2 + 0.5;
            return arr[(int) pos];
        } else if (arr.length == 2) {
            double result = arr[0] + arr[1];
            System.out.println(result);
            return result / 2;
        } else {
            double pos1 = arr.length / 2 - 0.5;
            double pos2 = arr.length / 2 + 0.5;
            double result = arr[(int) pos1] + arr[(int) pos2];
            return result / 2;
        }
    }
    
    public int[] mergeArray(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];

        int arr1pos = 0;
        int arr2pos = 0;

        for (int i = 0; i < arr3.length; i++) {
            if (arr1pos >= arr1.length) {
                arr3[i] = arr2[arr2pos];
                arr2pos++;
                continue;
            } else if (arr2pos >= arr2.length) {
                arr3[i] = arr1[arr1pos];
                arr1pos++;
                continue;
            }

            if (arr1[arr1pos] < arr2[arr2pos]) {
                arr3[i] = arr1[arr1pos];
                arr1pos++;
            } else {
                arr3[i] = arr2[arr2pos];
                arr2pos++;
            }
        }

        return arr3;
    }
}
