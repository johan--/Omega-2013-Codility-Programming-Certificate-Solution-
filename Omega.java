 public static int falling_disks(int[] A, int[] B) {

        int[] mins = new int[A.length];
        mins[0] = A[0];
        int[] minIndex = new int[A.length];
        minIndex[0] = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < mins[i - 1]) {
                mins[i] = A[i];
                minIndex[i] = i;
            } else {
                mins[i] = mins[i - 1];
                minIndex[i] = minIndex[i - 1];
            }
        }
        int end = A.length - 1;
        for (int i = 0; i < B.length; i++) {
            while (mins[end] < B[i]) {
                end = minIndex[end] - 1;
                if (end == -1) {
                    return i;
                }
            }
            end--;
            if (end == -1) {
                return i + 1;
            }
        }
        return B.length;
    }
