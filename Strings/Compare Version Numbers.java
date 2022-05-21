public class Solution {
    public int compareVersion(String A, String B) {
        ArrayList<Double> version1 = new ArrayList<Double>();
        ArrayList<Double> version2 = new ArrayList<Double>();

        String[] aux = A.split("\\.");
        for (int i = 0; i < aux.length; ++i) {
            Double num = Double.parseDouble(aux[i]);
            version1.add(num);
        }
        aux = B.split("\\.");
        for (int i = 0; i < aux.length; ++i) {
            Double num = Double.parseDouble(aux[i]);
            version2.add(num);
        }

        // preprocessing - remove trailing zeros from back
        while (version1.get(version1.size() - 1) == 0) {
            version1.remove(version1.size() - 1);
        }
        while (version2.get(version2.size() - 1) == 0) {
            version2.remove(version2.size() - 1);
        }

        // System.out.println(version1.toString());
        // System.out.println(version2.toString());

        for (int i = 0; i < Math.min(version1.size(), version2.size()); ++i) {
            Double ver1 = version1.get(i);
            Double ver2 = version2.get(i);

            if (ver1 > ver2)
                return 1;
            else if (ver2 > ver1)
                return -1;
            else {
                // both versions are same
                continue;
            }
        }

        // out of for loop, all the subversions matched, hence check length
        if (version1.size() < version2.size()) {
            return -1;
        } else if (version2.size() < version1.size()) {
            return 1;
        } else {
            // both version are same
            return 0;
        }
    }
}
