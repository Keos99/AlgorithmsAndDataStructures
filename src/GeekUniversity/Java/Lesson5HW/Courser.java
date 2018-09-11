package GeekUniversity.Java.Lesson5HW;

public class Courser {
    private int [][] chessfield = new int[8][8];
    private int [] movx = {1,2,2,1,-1,-2,-2,-1};
    private int [] movy = {-2,-1,1,2,2,1,-1,-2};
    private int step = 1;
    private int count = 0;

    public static void main(String[] args) {
        Courser courser = new Courser();
        courser.startPosition(0,0);
        courser.move(0,0);
        courser.showchessfield();
    }

    public void startPosition (int x, int y) {
        chessfield[x][y] = step;
    }

    public boolean move (int x, int y) {
        count++;
        int tempx;
        int tempy;

        if (isend()) return true;

        for (int i = 0; i < 8; i++) {
            tempx = x + movx[i];
            tempy = y + movy[i];

            if (!isInRangeAndEmpty(tempx,tempy)) continue;
            step++;
            chessfield[tempx][tempy] = step;

            if (!move(tempx, tempy)){
                step--;
                chessfield[tempx][tempy] = 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isend (){
        for (int i = 0; i < chessfield.length; i++) {
            for (int j = 0; j < chessfield.length; j++) {
                if (chessfield[i][j] == 0) return false;
            }
        }
        return true;
    }

    public boolean isInRangeAndEmpty (int x, int y) {
        return (x >= 0 && x < chessfield.length && y >= 0 && y < chessfield.length) && (chessfield[x][y] == 0);
    }

    public void showchessfield(){
        for (int i = 0; i < chessfield.length; i++) {
            for (int j = 0; j < chessfield.length; j++) {
                System.out.print(chessfield[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(count);
    }

}
