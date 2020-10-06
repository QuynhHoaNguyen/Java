

public class nombreDeDiviseurs {

    public static int nombreDeDiviseurs(int numbre){
        int count = 1;
        for (int i = 1; i <= numbre/2; i++) {
            int result = numbre % i;
            if (result == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int max = 1;
        int []b = new int[50];
        for(int i = 0; i <= 10; i++){
            if(nombreDeDiviseurs(i) >= max){
                max = nombreDeDiviseurs(i);
            }
            b[i] = nombreDeDiviseurs(i);
        }
        for(int i = 0; i<= 10; i++){
            if(b[i] == max){
                System.out.println(i);
            }
        }
        System.out.printf("\nVơi so luong uoc nhieu nhat la %d uoc.", max);
    }
}
