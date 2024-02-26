import java.util.Scanner;

public class Canvas {

    final public int WIDTH = 10;
    final public int HEIGHT = 10;
    private char[][] canvas = new char[HEIGHT][WIDTH];
    Coordinate coordinates = new Coordinate(0, 0);
    
    Canvas() {
        coordinates.setConstraints(0, WIDTH - 1, 0, HEIGHT - 1);

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                this.canvas[i][j] = '*';
            }
        }

    }
    
    
    public void printCanvas() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.printf(" %c ", this.canvas[i][j]);
            }
            System.out.println();
        }
    }    

    public void printPosition() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.printf(" %c ",
                    ( (i == this.coordinates.y) && (j == this.coordinates.x) ) ? '@' : this.canvas[i][j]);
            }
            System.out.println();
        }
    }

    public void start() {
        System.out.println("Started");
       
        while (true) {
            char input = getMove();

            if (input == 'q') {
                break;
            } else {
                handleInput(input);
                System.out.printf("Current Coordinates: (%d, %d)\n",
                                    this.coordinates.x, this.coordinates.y);
            }

        }

    }


    private char getMove() {
        char input;
        @SuppressWarnings("resource")
        Scanner myScanner = new Scanner(System.in);

        input = myScanner.next().charAt(0);

        return input;
    }


    /**
     * Commands:
     * * u: move up
     * * d: move down
     * * r: move right
     * * l: move left
     * * p: place point
     * * o: see position
     * * q: quit
     * * s: see map
     * * h: print help
     */
    private void handleInput(char inp) {

        switch (inp) {
            case 'u':
                coordinates.goUp(1);
                break;
            case 'd':
                coordinates.goDown(1);
                break;
            case 'r':
                coordinates.goRight(1);
                break;
            case 'l':
                coordinates.goLeft(1);
                break;
            case 'p':
                placePoint(this.coordinates.x, this.coordinates.y);
                break;
            case 'o':
                // this.printPosition();
                this.printPosition();
                break;
            case 's':
                this.printCanvas();
                break;
            case 'h':
                printHelp();
                break;

        }

    }

    private void placePoint(int x, int y) {
        this.canvas[y][x] = '#';
    }

    private void printHelp() {
        String helpString = new String();
        helpString = """
            Commands List:
                u: move up
                d: move down
                r: move right
                l: move left
                p: place point
                s: see map
                h: print help  
                q: quit     
                """;
        System.out.println(helpString);
    }

}
