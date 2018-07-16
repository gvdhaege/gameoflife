package be.switchfully.gameoflife.backend.gol;

import be.switchfully.gameoflife.backend.UnitTest;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameOfLifeControllerTest extends UnitTest {
    List<List<Boolean>> testGrid;

    @Before
    public void setUp() throws Exception {
        testGrid = new ArrayList<>();

        List<Boolean> rij1 = new ArrayList<>();
        List<Boolean> rij2 = new ArrayList<>();
        List<Boolean> rij3 = new ArrayList<>();

        rij1.add(false);
        rij1.add(true);
        rij1.add(true);
        rij2.add(false);
        rij2.add(true);
        rij2.add(true);
        rij3.add(true);
        rij3.add(false);
        rij3.add(true);

        testGrid.add(rij1);
        testGrid.add(rij2);
        testGrid.add(rij3);


    }

    @Test
    public void givenAWorldIfWeAskForStateWithCoordinates1_1_shouldReturnCorrectStateOfCell() throws Exception {
        boolean actual = testGrid.get(1).get(1);
        boolean expected = true;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void givenAWorldIfWeAskForStateWithCoordinates0_0_shouldReturnCorrectState() throws Exception {
        boolean actual = testGrid.get(0).get(0);
        boolean expected = false;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void givenCoordinates1_1_ShouldReturnInCorrectNumberOfNeighbours() throws Exception {
        int row = 1;
        int col = 1;
        int actual = GameOfLifeController.counter(testGrid, row, col);

        Assertions.assertThat(actual).isEqualTo(5);
    }

    @Test
    public void givenCoordinates0_0_shouldReturnCorrectCounter() throws Exception {
        int row = 0;
        int col = 0;
        int actual = GameOfLifeController.counter(testGrid, row, col);

        Assertions.assertThat(actual).isEqualTo(2);

    }
    @Test
    public void givenCoordinates2_2_shouldReturnCorrectCounter() throws Exception {
        int row = 2;
        int col = 2;
        int actual = GameOfLifeController.counter(testGrid, row, col);

        Assertions.assertThat(actual).isEqualTo(2);

    }

    @Test
    public void givenCoordinates0_2_shouldReturnCorrectCounter() throws Exception {
        int row = 0;
        int col = 2;
        int actual = GameOfLifeController.counter(testGrid,row,col);

        Assertions.assertThat(actual).isEqualTo(3);
    }
    @Test
    public void givenCoordinates2_0_shouldReturnCorrectCounter() throws Exception {
        int row = 2;
        int col = 0;
        int actual = GameOfLifeController.counter(testGrid,row,col);

        Assertions.assertThat(actual).isEqualTo(1);
    }
}