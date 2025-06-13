import java.util.Arrays;

public class ArrayComparer {
    public static void main(String[] args) {
        // Pelanggaran pada DCL53-J: Variabel sebaiknya dideklarasikan dengan scope yang
        // minimal untuk program ini variabel a dan b dideklarasikan di scope global dan
        // bertahan sampai program selesai
        // Pelanggaran pada DCL54-J: Konstanta sebaiknya dideklarasikan sebagai
        // konstanta yang spesifik dan immutable seperti 'private static final'
        Integer a = 1000;
        Integer b = 1000;

        // Pelanggaran pada EXP50-J: dapat membingungkan kesamaan objek dengan kesamaan
        // referensi
        // Seharusnya menggunakan .equals() untuk membandingkan objek bukan '=='
        if (a == b) { // Akan print "DIFFERENT" karena membandingkan referensi
            System.out.println("a and b are the SAME");
        } else {
            System.out.println("a and b are DIFFERENT");
        }

        int[] x = { 1, 2, 3 };
        int[] y = { 1, 2, 3 };

        // Pelanggaran pada EXP50-J: dapat membingungkan kesamaan objek dengan kesamaan
        // referensi
        // Seharusnya menggunakan Arrays.equals() untuk membandingkan array bukan
        // .equals()
        if (x.equals(y)) { // Akan print "DIFFERENT" karena membandingkan objek
            System.out.println("x and y are the SAME");
        } else {
            System.out.println("x and y are DIFFERENT");
        }
    }
}