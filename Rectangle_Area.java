package LeetCode;

/**
 * Created by YIZHONGQI on 18/11/2016.
 */
public class Rectangle_Area {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int op = 0;
        if(!(B >= H || F >= D || E >= C || A >= G))
            op = overlap(A,C,E,G)*overlap(B,D,F,H);
        return area(A,B,C,D)+area(E,F,G,H)-op;

    }

    public int area(int A, int B, int C, int D){
        return (C-A)*(D-B);
    }

    public int overlap(int A, int B, int C, int D){
        int start;
        int end;
        if(A <= C)
            start = C;
        else
            start = A;
        if(B <= D)
            end = B;
        else
            end = D;
        return end - start;
    }
}
