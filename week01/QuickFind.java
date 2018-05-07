public class QuickFind {
  private int[] id;

  public QuickFind(int n) {
    id = new int[n];

    for (int i = 0; i < id.length; i++)
      id[i] = i;
  }

  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  public void union(int p, int q) {
    if (id[p] == id[q]) return;

    int oq = id[q];

    for (int i = 0; i < id.length; i++)
      if (id[i] == oq)
        id[i] = id[p];
  }
}
