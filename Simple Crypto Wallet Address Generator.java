// ECCKeyGenerator.java

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

public class ECCKeyGenerator {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            ECGenParameterSpec ecsp = new ECGenParameterSpec("secp256r1");
            kpg.initialize(ecsp);

            KeyPair kp = kpg.generateKeyPair();
            PrivateKey privKey = kp.getPrivate();
            PublicKey pubKey = kp.getPublic();

            System.out.println("Private Key (Base64):");
            System.out.println(Base64.getEncoder().encodeToString(privKey.getEncoded()));
            System.out.println("\nPublic Key (Base64):");
            System.out.println(Base64.getEncoder().encodeToString(pubKey.getEncoded()));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
