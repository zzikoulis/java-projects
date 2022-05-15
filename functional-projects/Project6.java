package gr.aueb.cf.projects10;

/**
 * Βρίσκει τον υπο-πίνακα με το μεγαλύτερο άθροισμα.
 * Θεωρούμε πως έχουμε ένα τοπικό μέγιστο άθροισμα καθώς διατρέχουμε τον πίνακα.
 * Προσθέτουμε το τοπικό μέγιστο με το επόμενο στοιχείου του πίνακα.
 * Εάν το νέο τοπικό μέγιστο είναι μεγαλύτερο ή ίσο του στοιχείου αυτού, τότε το τοπικό μέγιστο ισούται με το στοιχείο
 * αυτό και θεωρούμε πως ο υποπίνακας ξεκινά από εκεί (με την μεταβλητή from).
 * Εάν το νέο πια τοπικό μέγιστο είναι μεγαλύτερο ή ίσο του γενικού μέγίστου, τότε γενικό μέγιστο ιστούται με το
 * τοπικό μέγιστο και θεωρούμε πως ο υποπίνακας φτάνει μέχρι εκεί (με την μεταβλητή to)
 */
public class Project6 {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int localMaximum = arr[0], globalMaximum = arr[0];
        int from = 0, to = 0;

        for(int i = 1; i < arr.length; i++) { // πολυπλοκότητα O(n) - n : στοιχεία του πίνακα
            localMaximum += arr[i];

            if(arr[i] >= localMaximum) {
                localMaximum = arr[i];
                from = i;
            }

            if(localMaximum >= globalMaximum) {
                globalMaximum = localMaximum;
                to = i;
            }
        }

        System.out.println("Maximum sum subarray is:");
        System.out.printf("{%d", arr[from]);
        for(int i = from + 1; i <= to; i++) {
            System.out.printf(", %d", arr[i]);
        }
        System.out.println("}");
        System.out.printf("with sum = %d\n", globalMaximum);
    }
}
