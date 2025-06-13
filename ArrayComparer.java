import java.util.Arrays;

public class ArrayComparer {
    public static void main(String[] args) {
        // Gunakan deklarasi variabel dalam scope lokal, hanya saat dibutuhkan (DCL53-J)
        // Gunakan konstanta final jika nilainya tidak berubah (DCL54-J)
        final Integer a = 1000;
        final Integer b = 1000;

        // Gunakan .equals() untuk membandingkan nilai objek (EXP50-J)
        if (a.equals(b)) {
            System.out.println("a and b have the SAME");
        } else {
            System.out.println("a and b have DIFFERENT");
        }

        int[] x = { 1, 2, 3 };
        int[] y = { 1, 2, 3 };

        // Gunakan Arrays.equals() untuk membandingkan isi array, bukan referensinya
        // (EXP50-J)
        if (Arrays.equals(x, y)) {
            System.out.println("x and y arrays have the SAME");
        } else {
            System.out.println("x and y arrays have DIFFERENT");
        }
    }
}
