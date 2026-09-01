class Solution {
    public record Direction(int r, int c) {}

    Direction[] directions = {
            new Direction(0, 1),
            new Direction(1, 0),
            new Direction(0, -1),
            new Direction(-1, 0),
    };

    public static class state {
        int r;
        int c;
        int e;
        int clm;

        public state(final int r, final int c, final int e, final int clm) {
            this.r = r;
            this.c = c;
            this.e = e;
            this.clm = clm;
        }
    }


    public int minMoves(String[] classroom, int energy) {
        int startRow =0, startCol =0;
        int[][] litterBitPos = new int[20][20];
        int maxEnergy = energy;
        int totalLitters = 0;
        for (int r=0; r < classroom.length; r++) {
            for (int c=0; c < classroom[r].length(); c++) {
                if(classroom[r].charAt(c) == 'S') {
                    startRow = r;
                    startCol = c;
                }
                else if (classroom[r].charAt(c) == 'L') {
                    litterBitPos[r][c] = totalLitters;
                    totalLitters++;
                }
            }
        }
        int allCollected = (1 << totalLitters) - 1;
        if(allCollected == 0)
            return 0;

        boolean[][][][] visited = new boolean[classroom.length][classroom[0].length()][maxEnergy+1][1 << totalLitters];

        Queue<state> q = new LinkedList<>();
        q.add(new state(startRow, startCol, energy, 0));
        visited[startRow][startCol][energy][allCollected] = true;

        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                state curr = q.poll();
                int r = curr.r;
                int c = curr.c;
                int e = curr.e;
                int clm = curr.clm;

                if(clm == allCollected)
                    return moves;
                if(e ==0)
                    continue;
                for (Direction d : directions) {
                    int nr = r + d.r;
                    int nc = c + d.c;

                    if(nr < 0 || nr >= classroom.length || nc < 0 || nc >= classroom[0].length())
                        continue;

                    int nm = clm;
                    char cell = classroom[nr].charAt(nc);
                    if(cell == 'X')
                        continue;
                    int ne = e - 1;
                    if(cell == 'R')
                        ne = maxEnergy;
                    else if(cell == 'L') {
                        int p = litterBitPos[nr][nc];
                        nm |= (1<<p);
                    }

                    if(!visited[nr][nc][ne][nm]) {
                        visited[nr][nc][ne][nm] = true;
                        q.add(new state(nr, nc, ne, nm));
                    }

                }
            }
            moves++;
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna