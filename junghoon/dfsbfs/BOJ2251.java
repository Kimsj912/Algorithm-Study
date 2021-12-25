package dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2251 {
	/* ����
	 * 
	 * ����: ���� ���ǰ� A, B, C(1��A, B, C��200) ������ �� ���� ������ �ִ�. 
	 *      ó������ ���� �� ������ ��� �ְ�, �� ��° ������ ����(C ����) �� �ִ�. 
	 *      ���� � ���뿡 ����ִ� ���� �ٸ� �������� ��� ���� �� �ִµ�, �̶����� �� ������ ��ų�, �ٸ� �� ������ ���� �� ������ ���� ���� �� �ִ�. 
	 *      �� �������� �սǵǴ� ���� ���ٰ� �����Ѵ�.
	 *      �̿� ���� ������ ��ġ�ٺ��� �� ��° ����(�뷮�� C��)�� ����ִ� ���� ���� ���� ���� �ִ�. 
	 *      ù ��° ����(�뷮�� A��)�� ��� ���� ��, �� ��° ����(�뷮�� C��)�� ������� �� �ִ� ���� ���� ��� ���س��� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� �� ���� A, B, C�� �־�����.
	 * 
	 * ���: ù° �ٿ� �������� �����Ͽ� ���� ����Ѵ�. �� �뷮�� ������������ �����Ѵ�.
	 * 
	 * Ǯ��: ������ 3�� -> ���� �̵� ������ ���� 6����
	 *     
	 * */
	
	static int a, b, c;
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		visited = new boolean[a + 1][b + 1][c + 1];

		ArrayList<int[]> list = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 0, 0, c });

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			if (visited[temp[0]][temp[1]][temp[2]])
				continue;
			visited[temp[0]][temp[1]][temp[2]] = true;

			if (temp[0] == 0)
				ans.add(temp[2]);

			if (temp[0] + temp[1] > a) { 
				q.add(new int[] { a, temp[0] + temp[1] - a, temp[2] });
			} else { 
				q.add(new int[] { temp[0] + temp[1], 0, temp[2] });
			}

			if (temp[0] + temp[1] > b) { 
				q.add(new int[] { temp[0] + temp[1] - b, b, temp[2] });
			} else { 
				q.add(new int[] { 0, temp[0] + temp[1], temp[2] });
			}

			if (temp[0] + temp[2] > a) {
				q.add(new int[] { a, temp[1], temp[0] + temp[2] - a });
			} else { 
				q.add(new int[] { temp[0] + temp[2], temp[1], 0 });
			}

			if (temp[0] + temp[2] > c) {
				q.add(new int[] { temp[0] + temp[2] - c, temp[1], c });
			} else { 
				q.add(new int[] { 0, temp[1], temp[0] + temp[2] });
			}

			if (temp[1] + temp[2] > b) {
				q.add(new int[] { temp[0], b, temp[1] + temp[2] - b });
			} else { 
				q.add(new int[] { temp[0], temp[1] + temp[2], 0 });
			}

			if (temp[1] + temp[2] > c) { 
				q.add(new int[] { temp[0], temp[1] + temp[2] - c, c });
			} else {
				q.add(new int[] { temp[0], 0, temp[1] + temp[2] });
			}
		}

		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++)
			System.out.print(ans.get(i) + " ");
	}
	

}
