package dfsbfs;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ11725 {
	/* Ʈ���� �θ� ã��
	 * 
	 * ����: ��Ʈ ���� Ʈ���� �־�����. �̶�, Ʈ���� ��Ʈ�� 1�̶�� ������ ��, �� ����� �θ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� ����� ���� N (2 �� N �� 100,000)�� �־�����. ��° �ٺ��� N-1���� �ٿ� Ʈ�� �󿡼� ����� �� ������ �־�����.
	 * 
	 * ���: ù° �ٺ��� N-1���� �ٿ� �� ����� �θ� ��� ��ȣ�� 2�� ������ ������� ����Ѵ�.
	 * 
	 * Ǯ��: �湮 �迭�� ���� ���߰� �ִ� ������ �湮���� �ʾ����� count 1������ DFS Ž��
	 *      DFS Ž������ 4����� Ȯ���ϸ鼭 ���߰� �ְ� �湮���� ������ DFS Ž�� �Ŀ� ���߹��� �� Ž��
	 *     
	 * */
    static int n ;
    static ArrayList<Integer>[] list;
    static int[] parents;
    static boolean[] check;
    
    private static void dfs(int v){
        if(check[v]){
            return;
        }
        check[v] =true;
        for (int vv: list[v]) {
            if(!check[vv]){
                parents[vv] = v;
                dfs(vv);
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        list = new ArrayList[n+1];
        parents = new int[n+1];
        check = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int j = 1; j <n ; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        for (int k = 1; k <=n ; k++) {
            if(!check[k]){
                dfs(k);
            }
        }
        for (int i = 2; i <=n ; i++) {
            System.out.println(parents[i]);
        }

    }

}
