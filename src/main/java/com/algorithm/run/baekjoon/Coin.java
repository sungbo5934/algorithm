package com.algorithm.run.baekjoon;

import java.util.Scanner;

public class Coin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int[] dp = new int[k + 1];

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] += dp[j- coins[i]];
                }
            }
        }

        System.out.println(dp[k]);
    }
}
