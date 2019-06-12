package ControleDeArquivos;

public class ConverteBytes {

    private void ConverteBytes(long bytes) {
        long kilobyte = 1024;
        long megabyte = kilobyte * 1024;
        long gigabyte = megabyte * 1024;
        long terabyte = gigabyte * 1024;

        if ((bytes >= 0) && (bytes < kilobyte)) {
            System.out.println(bytes + " B");

        } else if ((bytes >= kilobyte) && (bytes < megabyte)) {
            System.out.println((bytes / kilobyte) + " KB");

        } else if ((bytes >= megabyte) && (bytes < gigabyte)) {
            System.out.println((bytes / megabyte) + " MB");

        } else if ((bytes >= gigabyte) && (bytes < terabyte)) {
            System.out.println((bytes / gigabyte) + " GB");
            
        } else if (bytes >= terabyte){
            System.out.println((bytes / terabyte) + " TB");
            
        } else {
            System.out.println(bytes + " Bytes");
            
        }   

    }
    

    public static void main(String[] args) {
        
        ConverteBytes realSize = new ConverteBytes();
        realSize.ConverteBytes(483352637);

    }

}
