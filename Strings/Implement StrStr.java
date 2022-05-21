public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String haystack, final String needle) {

        // Obvious cases
        if (needle.length() == 0 || haystack.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle))
                return i;
        }

        return -1;
    }
}
