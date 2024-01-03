import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.io.BufferedWriter.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double panjang, lebar, tinggi;
        int jumlah, i;

        System.out.print("Masukkan jumlah balok yang ingin dibeli : ");
        jumlah = scanner.nextInt();

        try { //exception
            for (i = 0; i < jumlah; i++) {
                System.out.println("Masukkan ukuran balok ke-" + (i + 1) + " : ");
                System.out.println("Masukkan panjang balok : ");
                panjang = scanner.nextDouble();

                System.out.println("Masukkan lebar balok : ");
                lebar = scanner.nextDouble();

                System.out.println("Masukkan tinggi balok : ");
                tinggi = scanner.nextDouble();

                if (BalokKayu.isValidDimensions(panjang, lebar, tinggi)) {
                    double volume = BalokKayu.hitungVolume(panjang, lebar, tinggi);

                    System.out.println();
                    System.out.println("Volume balok kayu ke-" + (i + 1) + " : " + volume);
                    System.out.println("Volume balok kayu ke-" + (i + 1) + " berhasil disimpan ke file 'volume balok.txt' .");
                    System.out.println();
                    //simpan volume balok ke dalam file txt
                    simpanVolumeKeFile(volume);
                } else {
                    System.out.println("Maaf, nilai panjang/lebar/tinggi tidak memenuhhi syarat.");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Inputan harus berupa angka !!");
        }
    }

    private static void simpanVolumeKeFile(double volume) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("volume balok.txt", true));
                writer.write("volume balok kayu : " + volume);
                writer.newLine();
                writer.close();
        }catch (IOException e){
            System.out.println("Terjadi kesalahan dalam menyimpan file");
        }
    }
}
