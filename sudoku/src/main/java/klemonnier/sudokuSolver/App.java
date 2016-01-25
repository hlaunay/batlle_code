package klemonnier.sudokuSolver;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
//        System.out.println( "Hello World!" );
//        for (int i=0; i < args.length; i++) {
//        	System.out.println(args[i]);
//        }
    	System.out.println();
    	if (args.length != 1) {
    		System.out.println("Wrong number of arguments");
    	} else {
    		Grid grid = new Grid();
    		File gridFile = new File(args[0]);
    		grid.parseFile(gridFile);
    		grid.displayGrid();
    		System.out.println();
    		grid.solveSudoku();
    	}
    }
}
