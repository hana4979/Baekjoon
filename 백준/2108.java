import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(bf.readLine());

		Arrays.sort(arr);

		System.out.println((int) mean(arr)); // 산술평균
		System.out.println(median(arr)); // 중앙값
		System.out.println(mode(arr)); // 최빈값
		System.out.println(range(arr)); // 범위

	}

	// 산술평균 : N개의 수들의 합을 N으로 나눈 값
	public static double mean(int[] arr) {
		double value = 0;

		for (int num : arr)
			value += num;
		value = value / arr.length;

		return Math.round(value);
	}

	// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
	public static int median(int[] arr) {
		return arr[arr.length / 2];
	}

	// 220330 mode 구현중...
	// 최빈값 : N개의 수들 중 가장 많이 나타나는 값
	public static int mode(int[] arr) {
		int[] freq = new int[arr.length]; // 빈도수 담을 배열

		for (int i = 0; i < arr.length; i++) {
			if (i == 0)
				freq[i] += 1;

			for (int j = i; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					freq[j] += 1;
					continue;
				}
			}
			freq[i] += 1;
		}

		int[] copy = new int[freq.length];
		for (int i = 0; i < freq.length; i++) { // 배열 복사
			copy[i] = freq[i];
		}

		Arrays.sort(freq); // 오름차순 정렬 --> 문제 1. 빈도를 기준으로 정렬하면 어떤 정수가 많이 나왔는지 모름.

		int len = freq.length - 1;
		if (freq[len] == freq[len - 1]) { // --> 문제 2. 값 하나 불러올 때 ArrayIndexOutOfBoundsException 오류
			// 최빈값이 몇 번째에 있는지 찾기
			for (int i = len - 1; i > 0; i--) {
				if (freq[i] != freq[len]) {
					return freq[i]; // 문제 3. 리턴값은 빈도값이 아니라 입력한 수여야 함
				}
			}
		} else {
			return freq[1];
		}
		
		return 0;

	}

	// 범위 : N개의 수들 중 최댓값과 최솟값의 차이
	public static int range(int[] arr) {
		if (arr.length == 1) // 입력값이 하나 == 범위 존재 X
			return 0;
		else if (arr[0] < 0 && arr[arr.length - 1] < 0) // 두 값 모두 음수
			return Math.abs(arr[0] - (arr[arr.length - 1]));
		else
			return Math.abs(arr[0]) + Math.abs(arr[arr.length - 1]);
	}
}

// 220405 최빈값(Mode)부분 어떻게든 살려보려 했으나 다시 짜야할 듯
