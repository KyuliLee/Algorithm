package week8;
class PGS_카펫 {
    public int[] solution(int brown, int yellow) {
        
        int plus = (brown/2)-2;
        int mul = yellow;
        
        int[] arr = findWH(plus, mul);
       
        if(arr[0] < arr[1]) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        arr[0] = arr[0] + 2;
        arr[1] = arr[1] + 2;
        return arr;
    }
    
    public static int[] findWH(int plus, int mul) {
        for(int i=1; i<=plus-1; i++) {
            int w = i;
            int h = plus-i;
            if(w*h == mul) {
                return new int[] {w, h};
            }
        }
        return new int[] {0, 0};
    }
}