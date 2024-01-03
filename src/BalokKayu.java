public class BalokKayu {
    public static double hitungVolume(double panjang, double lebar, double tinggi){
        return panjang * lebar * tinggi;
    }

    public static boolean isValidDimensions(double panjang, double lebar, double tinggi){
        return panjang > lebar && lebar > tinggi;
    }
}
