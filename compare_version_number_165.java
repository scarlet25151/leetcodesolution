public class compare_version_number_165 {
    public int compareVersion(String version1, String version2) {
        String[] p1 = version1.split(".");
        String[] p2 = version2.split(".");
        int ver1 = 0, ver2 = 0;
        if (p1.length >= p2.length) {
            for (int i = 0; i < p1.length; ++i) {
                ver1 = ver1 * 10 + Integer.parseInt(p1[i]);
                ver2 = ver2 * 10 + (i > p2.length ? 0 : Integer.parseInt(p2[i]));
            }
        } else {
            for (int i = 0; i < p2.length; ++i) {
                ver1 = ver1 * 10 + (i > p1.length ? 0 : Integer.parseInt(p1[i]));
                ver2 = ver2 * 10 + Integer.parseInt(p2[i]);
            }
        }
        int res;
        if (ver1 > ver2) res = 1;
        else if (ver1 < ver2) res = -1;
        else res = 0;
        return res;
    }

}
