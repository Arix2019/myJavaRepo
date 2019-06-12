package DecriptadorAES;

public class PrincipalDecriptAES {

    public static void main(String[] args) {
        try {
            DecriptadorAES aes = new DecriptadorAES("lv39eptivuhaqqsr");
            
            String encData = aes.encrypt("Amarnath");
            System.out.println("Encrypted Data: " + encData);
            String decData = aes.decrypt(encData);
            System.out.println("Decrypted Data: " + decData);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
