
public class MissingTile {
    public static void tileGrid(Grid board) {
        tilingHelper(board.size(), 0,0, board.getPaintedCellX(), board.getPaintedCellY(), board);
    }

    public static void tilingHelper(int size, int topX, int topY, int paintedX, int paintedY, Grid bd) {
        if (size < 2) return;
        int q = getQ(bd, topX , topY, paintedX, paintedY, size);
        if (size == 2) {
                bd.setTile(paintedX, paintedY, getOrientation(q));
        } else {
            int[] xs = new int[]{size / 2 - 1 + topX, size / 2 + topX, size / 2 - 1 + topX, size / 2 + topX};
            int[] ys = new int[]{size / 2 - 1 + topY, size / 2 - 1 + topY, size / 2 + topY, size/ 2 + topY};
            int fooX = xs[q - 1];
            int fooY = ys[q - 1];
            xs[q - 1] = paintedX;
            ys[q - 1] = paintedY;

            tilingHelper(size / 2, topX, topY, xs[0], ys[0], bd);
            tilingHelper(size / 2, topX + size/2, topY , xs[1], ys[1], bd);
            tilingHelper(size / 2, topX, topY + size/2, xs[2], ys[2], bd);
            tilingHelper(size / 2, topX + size/2, topY+size/2, xs[3], ys[3], bd);
            bd.setTile(fooX, fooY, getOrientation(q));
        }

    }

    //      Q1 = topleft-> X,Y<  size/2
//      Q2 = topright-> X < size/2 , Y >= size/2
//    Q3 = botleft-> X >= size/2 , Y < size/2
//    Q4 = botright-> X,Y >= size/2
    public static int getQ(Grid bd, int topX , int topY , int paintedX, int paintedY, int size) {
        if (size / 2 > paintedX-topX && size / 2 > paintedY-topY) {
            return 1;
        }
        if (size / 2 <= paintedX-topX  && size / 2 > paintedY-topY) return 2;
        if (size / 2 > paintedX-topX && size / 2 <= paintedY-topY) return 3;
        else return 4;
//        if (bd.size()/2 >= paintedX && bd.size()/2 >= paintedY) return 4;

    }

    public static int getOrientation(int q) {
        if (q == 1) {
            return 3;
        } else if (q == 2) {
            return 0;
        } else if (q == 3) {
            return 2;
        } else {                                            // q == 4
            return 1;
        }
    }


}
