import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        long max = -1;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        } // 초기화 완료

        long s1 = 0;
        long s2 = 0;
        long s3 = 0;

        // 1번 경우
        for(int r1=1; r1<N-1; r1++) {
            for(int r2=r1+1; r2<N; r2++) {
                s1 = 0;
                s2 = 0;
                s3 = 0;
                // 사각형1
                for(int r=0; r<r1; r++) {
                    for(int c=0; c<M; c++) {
                        s1 += arr[r][c];
                    }
                }
                // 사각형2
                for(int r=r1; r<r2; r++) {
                    for(int c=0; c<M; c++) {
                        s2 += arr[r][c];
                    }
                }
                // 사각형3
                for(int r=r2; r<N; r++) {
                    for(int c=0; c<M; c++) {
                        s3 += arr[r][c];
                    }
                }
                long mul = s1*s2*s3;
                max = Math.max(max, mul);
            }
        }
        // 2번 경우
        for(int c1=1; c1<M-1; c1++) {
            for(int c2=c1+1; c2<M; c2++) {
                s1 = 0;
                s2 = 0;
                s3 = 0;
                // 사각형1
                for(int r=0; r<N; r++) {
                    for(int c=0; c<c1; c++) {
                        s1 += arr[r][c];
                    }
                }
                // 사각형2
                for(int r=0; r<N; r++) {
                    for(int c=c1; c<c2; c++) {
                        s2 += arr[r][c];
                    }
                }
                // 사각형3
                for(int r=0; r<N; r++) {
                    for(int c=c2; c<M; c++) {
                        s3 += arr[r][c];
                    }
                }
                long mul = s1*s2*s3;
                max = Math.max(max, mul);
            }
        }

        // 3번 경우
        for(int r1=1; r1<=N-1; r1++) {
            for(int c1=1; c1<=M-1; c1++) {
                s1 = 0;
                s2 = 0;
                s3 = 0;
                // 사각형1
                for(int r=0; r<r1; r++) {
                    for(int c=0; c<c1; c++) {
                        s1 += arr[r][c];
                    }
                }
                // 사각형2
                for(int r=0; r<r1; r++) {
                    for(int c=c1; c<M; c++) {
                        s2 += arr[r][c];
                    }
                }
                // 사각형3
                for(int r=r1; r<N; r++) {
                    for(int c=0; c<M; c++) {
                        s3 += arr[r][c];
                    }
                }
                long mul = s1*s2*s3;
                max = Math.max(max, mul);
            }
        }

        // 4번 경우
        for(int r1=1; r1<=N-1; r1++) {
            for (int c1 = 1; c1 <= M - 1; c1++) {
                s1 = 0;
                s2 = 0;
                s3 = 0;
                // s1
                for(int r=0; r<r1; r++) {
                    for(int c=0; c<M; c++) {
                        s1 += arr[r][c];
                    }
                }
                // s2
                for(int r=r1; r<N; r++) {
                    for(int c=0; c<c1; c++) {
                        s2 += arr[r][c];
                    }
                }
                // s3
                for(int r=r1; r<N; r++) {
                    for(int c=c1; c<M; c++) {
                        s3 += arr[r][c];
                    }
                }
                long mul = s1*s2*s3;
                max = Math.max(max, mul);
            }
        }

        // 5번 경우
        for(int r1=1; r1<=N-1; r1++) {
            for(int c1=1; c1<=M-1; c1++) {
                s1 = 0;
                s2 = 0;
                s3 = 0;
                // s1
                for(int r=0; r<r1; r++) {
                    for(int c=0; c<c1; c++) {
                        s1 += arr[r][c];
                    }
                }
                // s2
                for(int r=r1; r<N; r++) {
                    for(int c=0; c<c1; c++) {
                        s2 += arr[r][c];
                    }
                }
                // s3
                for(int r=0; r<N; r++) {
                    for(int c=c1; c<M; c++) {
                        s3 += arr[r][c];
                    }
                }
                long mul = s1*s2*s3;
                max = Math.max(max, mul);
            }
        }

        // 6번 경우
        for(int r1=1; r1<=N-1; r1++) {
            for (int c1 = 1; c1 <= M - 1; c1++) {
                s1 = 0;
                s2 = 0;
                s3 = 0;
                // s1
                for(int r=0; r<N; r++) {
                    for(int c=0; c<c1; c++) {
                        s1 += arr[r][c];
                    }
                }
                // s2
                for(int r=0; r<r1; r++) {
                    for(int c=c1; c<M; c++) {
                        s2 += arr[r][c];
                    }
                }
                // s3
                for(int r=r1; r<N; r++) {
                    for(int c=c1; c<M; c++) {
                        s3 += arr[r][c];
                    }
                }
                long mul = s1*s2*s3;
                max = Math.max(max, mul);
            }
        }
        System.out.println(max);

    }
}
