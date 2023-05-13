package test;
/**
 * 小美正在参加一个比赛。
 *
 * 这个比赛总共有 2k 个人参加（包括小美），编号为1,2,...,2k，
 * 开始的时候所有人都在同一个小组。比试的规程如下：假设当前小组
 * 有 n 个人（n 为偶数），那么编号大小前 n/2 人分为一个新的小组，
 * 后 n/2 人分为一个新的小组，然后两个小组内部分别比试，决出各自的胜者，
 * 然后两个小组的胜者进行比试，胜者作为当前小组的优胜者，直到决出最初的小组的优胜者
 * 。当然一个人的小组优胜者肯定是他自己。例如如果当前小组有 4 个人，编号为1,2,3,4
 * ，那么就会将 1,2 分为一组，3,4分为一组分别比试，然后 1,2 中的胜者和 3,4 中的
 * 胜者再进行比试，决出整个小组的胜者。
 *
 * 由于每个人的能力各不相同，小美预测了所有人两两比试时的胜者，现在小美想知道预测最
 * 终的胜者是谁。
 * 2
 * 1 2 3 1
 * 2 2 3 2
 * 3 3 3 3
 * 1 2 3 4
 *
 * 3
 *
 * 样例解释
 *
 * 首先 1,2,3,4 一组,1,2一组，3,4一组， 1,2比试，胜者为2 ，
 * 3,4一组，胜者为3 ，然后2,3 比试，胜者为3 ，故最后的胜者为 3。
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] t = new int[n+1];
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        int[] c = new int[n+1];
        for(int i=0;i<n;i++){
            t[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            c[i] = b[i] - a[i];
        }
        int sum = 0;
        int[] dp = new int[m+1];
        for(int i=0;i<n;i++){
            for(int j=t[i];j<=m;j++){
                dp[j] = Math.max(dp[j],dp[j-t[i]] + c[i]);
                sum = dp[j];
            }
        }
        System.out.println(sum);
    }
}