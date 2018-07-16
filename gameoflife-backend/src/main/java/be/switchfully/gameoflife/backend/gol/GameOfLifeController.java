package be.switchfully.gameoflife.backend.gol;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = GameOfLifeController.WORLD_BASE_URL)
public class GameOfLifeController {

    static final String WORLD_BASE_URL = "/api/gol";
    private static Logger logger = Logger.getLogger(GameOfLifeController.class);

    @PostMapping(value = "/phase")
    public List<List<Boolean>> nextGeneration(@RequestBody List<List<Boolean>> currentWorld) {
        logger.info(currentWorld);
//        Collections.shuffle(currentWorld);
        return currentWorld;
    }

    public static int counter(List<List<Boolean>> world, int row, int col) {
        int counter = checkNormalCases(world, row, col)+checkUpperCorners(world, row, col)+checkLowerCorners(world, row, col);
        if (world.get(row).get(col)) {
            counter = counter - 1;
        }
        return counter;
    }

    private static int checkLowerCorners(List<List<Boolean>> world, int row, int col) {
    int counter = 0;
        if (row == world.size() - 1) {
            if (col == 0) {
                for (int rij = row - 1; rij < row + 1; rij++) {
                    for (int kol = col; kol < col + 2; kol++) {
                        if (world.get(rij).get(kol)) {
                            counter++;
                        }
                    }
                }
            }
            if (col == world.size() - 1) {
                for (int rij = row - 1; rij < row + 1; rij++) {
                    for (int kol = col - 1; kol < col + 1; kol++) {
                        if (world.get(rij).get(kol)) {
                            counter++;
                        }

                    }
                }
            }
        }
        return counter;
    }

    private static int checkUpperCorners(List<List<Boolean>> world, int row, int col) {
        int counter = 0;
        if (row == 0) {
            if (col == world.size() - 1) {
                for (int rij = row; rij < row + 2; rij++) {
                    for (int kol = col - 1; kol < col + 1; kol++) {
                        if (world.get(rij).get(kol)) {
                            counter++;
                        }

                    }
                }
            }
            if (col == 0) {
                for (int rij = row; rij < row + 2; rij++) {
                    for (int kol = col; kol < col + 2; kol++) {
                        if (world.get(rij).get(kol)) {
                            counter++;
                        }

                    }
                }
            }
        }
        return counter;
    }

    private static int checkNormalCases(List<List<Boolean>> world, int row, int col) {
        int counter = 0;
        if (row != 0 && row != world.size() - 1 && col != 0 && col != world.size() - 1) {
            for (int rij = row - 1; rij < row + 2; rij++) {
                for (int kol = col - 1; kol < col + 2; kol++) {
                    if (world.get(rij).get(kol)) {
                        counter++;
                    }

                }
            }
        }
        return counter;
    }
}
