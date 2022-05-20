public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);

        int rooms = K;

        int arrivalIter = 0;
        int departIter = 0;

        while (arrivalIter < arrive.size() && departIter < depart.size()) {

            // System.out.println(arrivalIter);

            // Case 1 : rooms are available
            if (rooms > 0) {
                rooms--;
                arrivalIter++;
            } else if (rooms == 0) {
                // check if people have departed
                while (departIter < depart.size() && depart.get(departIter) <= arrive.get(arrivalIter)) {
                    rooms++;
                    departIter++;
                }

                // out of while loop, check if we could clear up rooms
                if (rooms == 0)
                    return false;
            }
        }

        return true;
    }
}
