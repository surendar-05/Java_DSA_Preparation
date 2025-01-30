// class Solution {
//     public double median(int[] arr1, int[] arr2) {
      
//       int sorted [] =new int [arr1.length+arr2.length];

//       int i=0;
//       int j=0;
//       int k=0;

//       while(i<arr1.length && j<arr2.length){
//         if(arr1[i]>arr2[j]){
//             sorted[k++]=arr2[j];
//             j++;
//         }
//         else if(arr1[i]==arr2[j]){
//             sorted[k++]=arr1[i];
//             sorted[k++]=arr2[j];
//             i++;
//             j++;
//         }
//         else{
//             sorted[k++]=arr1[i];
//             i++;
//         }
//       } 

//      while(i!=arr1.length){
//         sorted[k++]=arr1[i++];
//      }
//      while(j!=arr2.length){
//         sorted[k++]=arr2[j++];
//      }
    
//      if(sorted.length%2==0){
//         return (double)(sorted[sorted.length/2]+sorted[(sorted.length/2)-1])/2;
//      }
    
//     return (double)(sorted[sorted.length/2]);
//     }
// }

// class Solution {
//     public double median(int[] arr1, int[] arr2) {
//       //By using Hypothetical Array

//        int i=0;
//        int j=0;
//        int count=0;
//        int ind1=(arr1.length+arr2.length)/2;
//        int ind2=(((arr1.length+arr2.length)/2)-1);
//        int index1=-1;
//        int index2=-1;

//       while(i<arr1.length && j<arr2.length){
//         if(arr1[i]<arr2[j]){
//             if(count==ind1){
//               index1=arr1[i];
//             }
//             if(count==ind2){
//                 index2=arr1[i];
//             }
//             count++;
//             i++;
            
//         }
        
//         else{
//            if(count==ind1){
//               index1=arr2[j];
//             }
//             if(count==ind2){
//                 index2=arr2[j];
//             }
//             count++;
//             j++;
//         }
//       } 

//      while(i!=arr1.length){
//         if(count==ind1){
//               index1=arr1[i];
//             }
//             if(count==ind2){
//                 index2=arr1[i];
//             }
//             count++;
//             i++;
//      }
//      while(j!=arr2.length){
//        if(count==ind1){
//               index1=arr2[j];
//             }
//             if(count==ind2){
//                 index2=arr2[j];
//             }
//             count++;
//             j++;
//      }
    
//      if((arr1.length+arr2.length)%2==0){
//         return (index1 + index2) / 2.0;
//      }
    
//     return (double)(index1);
     
//     }
// }




class Solution {
    public double median(int[] arr1, int[] arr2) {
        int n1=arr1.length;
        int n2=arr2.length;

        if(n1>n2) return median(arr2,arr1);//Consider the smallest array
       
        int n=n1+n2;

        int left=(n1+n2+1)/2;

        int low=0;
        int high=n1;

        while(low<=high){
          int mid1=(low+high)/2;

          int mid2=left-mid1;

          int l1=(mid1>0)?arr1[mid1-1]:Integer.MIN_VALUE;

          int l2=(mid2>0)?arr2[mid2-1]:Integer.MIN_VALUE;

          int r1=(mid1<n1)?arr1[mid1]:Integer.MAX_VALUE;

          int r2=(mid2<n2)?arr2[mid2]:Integer.MAX_VALUE;


          if(l1<=r2 && l2<=r1){

            if(n%2==1) return Math.max(l1,l2);

            else{
              return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
          }
          else if(l1>r2){
            high=mid1-1;
          }
          else{
            low=mid1+1;
          }

        }

     return 0.0;
    }
}























