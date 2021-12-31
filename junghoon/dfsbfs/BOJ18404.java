package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18404 {
	
	/* ������ ����Ʈ
	 * 
	 * ����: NxN ũ�� ü������ Ư���� ��ġ�� �ϳ��� ����Ʈ�� �����Ѵ�. 
	 *      �̶� M���� ����� ������ ��ġ ���� �־����� ��, �� ����� ���� ��� ���� ����Ʈ�� �ּ� �̵� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 *      ����Ʈ�� �Ϲ����� ü��(Chess)������ �����ϰ� �̵��� �� �ִ�. ���� ����Ʈ�� ��ġ�� (X,Y)��� �� ��, ����Ʈ�� ������ 8������ ��ġ �߿��� �ϳ��� ��ġ�� �̵��Ѵ�.
	 *      (X-2,Y-1), (X-2,Y+1), (X-1,Y-2), (X-1,Y+2), (X+1,Y-2), (X+1,Y+2), (X+2,Y-1), (X+2,Y+1)
	 *      N=5�� ��, ����Ʈ�� (3,3)�� ��ġ�� �����Ѵٸ� �̵� ������ ��ġ�� ������ ����. 
	 *      ����Ʈ�� �����ϴ� ��ġ�� K, �̵� ������ ��ġ�� ��������� ǥ���Ͽ���.
	 *      ���� ��� N=5, M=3�̰�, ����Ʈ�� (2,4)�� ��ġ�� �����Ѵٰ� ��������. 
	 *      ���� ����� ���� ��ġ�� ���ʴ�� (3,2), (3,5), (4,5)��� ����. �̶� �� ����� ���� ��� ���� �ּ� �̵� ���� ����غ���. 
	 *      �Ʒ� �׸������� ����� ���� ��ġ�� E�� ǥ���Ͽ���. ��, �� �������� ��ġ ���� ��Ÿ�� ���� (��,��)�� ���·� ǥ���Ѵ�.
	 *      �� ����� ���� ��� ���� �ּ� �̵� ���� ���ʴ�� 1, 2, 1�� �ȴ�.
	 * 
	 * �Է�: ù° �ٿ� N�� M�� ������ �������� ���еǾ� �ڿ����� �־�����. 
	 *      (1 �� N �� 500, 1 �� M �� 1,000) 
	 *      ��° �ٿ� ����Ʈ�� ��ġ (X, Y)�� �ǹ��ϴ� X�� Y�� ������ �������� ���еǾ� �ڿ����� �־�����. (1 �� X, Y �� N) 
	 *      ��° �ٺ��� M���� �ٿ� ���� �� ����� ���� ��ġ (A, B)�� �ǹ��ϴ� A�� B�� ������ �������� ���еǾ� �ڿ����� �־�����. (1 �� A, B �� N)
	 *      ��, �Է����� �־����� ��� ������ ��ġ�� �ߺ����� ������, ����Ʈ�� ������ �� �ִ� ��ġ�θ� �־�����.
	 * 
	 * ���: ù° �ٿ� �� ����� ���� ��� ���� �ּ� �̵� ���� ������ �������� �����Ͽ� ����Ѵ�.
	 *      ��, ����� ���� �Է� �ÿ� ����� �� ������ �־����� ������ �°� ���ʴ�� ����Ѵ�.
	 * 
	 *     
	 * */
	
	 static int N, M;
	    static int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	    static int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
	    static int arr[][];
	    static boolean visit[][];
	    static int cnt[][];
	    
	    static int atoi(String str) {
	        return Integer.parseInt(str);
	    }
	    
	    static void bfs(int x, int y) {
	        Queue<Integer> q = new ArrayDeque<>();
	        q.offer(x);
	        q.offer(y);
	        visit[x][y] = true;
	 
	        while (!q.isEmpty()) {
	            int X = q.poll();
	            int Y = q.poll();
	            for (int i = 0; i < 8; i++) {
	                int dX = X + dx[i];
	                int dY = Y + dy[i];
	                if(!isRangeTrue(dX,dY)) continue;
	                if(visit[dX][dY]) continue;
	                q.offer(dX);
	                q.offer(dY);
	                visit[dX][dY] = true;
	                cnt[dX][dY] = cnt[X][Y] + 1;
	            }
	        }
	    }
	 
	    static boolean isRangeTrue(int x, int y) {
	        return x > 0 && x <= N && y > 0 && y <= N;
	    }
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        StringBuilder sb = new StringBuilder();
	 
	        N = atoi(st.nextToken());
	        M = atoi(st.nextToken());
	 
	        st = new StringTokenizer(br.readLine());
	 
	        int start = atoi(st.nextToken());
	        int end = atoi(st.nextToken());
	 
	        arr = new int[N + 1][N + 1];
	        visit = new boolean[N + 1][N + 1];
	        cnt = new int[N + 1][N + 1];
	 
	        bfs(start, end);
	 
	        for (int i = 0; i < M; i++) {
	            st = new StringTokenizer(br.readLine());
	            int s1 = atoi(st.nextToken());
	            int s2 = atoi(st.nextToken());
	            sb.append(cnt[s1][s2] + " ");
	        }
	 
	        System.out.println(sb);
	    }
	 
	
}
