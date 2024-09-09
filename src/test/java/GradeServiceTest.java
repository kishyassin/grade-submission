import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;

public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @BeforeEach
    void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getGradesFromRepositoryTest() {
        // Mocking the behavior of gradeRepository.getStudentGrades() to return a list of grades
        when(gradeRepository.getStudentGrades()).thenReturn(Arrays.asList(
            new Grade("Yassine","Maths",  "A+"),
            new Grade("Med","Fr",  "B+")
        ));

        // Calling the service method to get the grades
        List<Grade> result = gradeService.getStudentGrades();

        // Assertions to validate the results
        assertEquals(2, result.size()); // Check that the size of the returned list is correct
        assertEquals("Yassine", result.get(0).getName()); // Validate the first grade's name
        assertEquals("A+", result.get(0).getScore()); // Validate the first grade's score
        assertEquals("Med", result.get(1).getName()); // Validate the second grade's name
    }
}
