
    public static int partition(int p, int from, int to,
                                 int[] a, int[] three) {
            int i = from;
            for(int j = from; j<to; j++){
                if(a[j]<=p){
                    three[0]++;
                    int temp =a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                }
                if(a[j]>=p){
                    three[2]++;
                }
            }
           int temp =a[i];
           a[i] = a[to];
           a[to] = temp;
           three[1] = (a.length-1) - (three[2]+three[0]);
          return i;
        }