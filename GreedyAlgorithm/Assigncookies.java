class Solution {
    public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
        //your code goes here
        Arrays.sort(Student);
        Arrays.sort(Cookie);

        int l=0;
        int r=0;

        while(l<Student.length && r<Cookie.length){
            if(Cookie[r]>=Student[l]){
              l++;
            }
            r++;
        }
        return l;
    }
}