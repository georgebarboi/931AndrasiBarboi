package _931_AndrasiBarboiMV;


import _931_AndrasiBarboiMV.Domain.Student;
import _931_AndrasiBarboiMV.Domain.TemaLab;
import _931_AndrasiBarboiMV.Exceptions.ValidatorException;
import _931_AndrasiBarboiMV.Repository.MemoryRepository.StudentRepo;
import _931_AndrasiBarboiMV.Repository.MemoryRepository.TemaLabRepo;
import _931_AndrasiBarboiMV.Validator.StudentValidator;
import _931_AndrasiBarboiMV.Validator.TemaLabValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for Memory Repository
 */
public class MemoryRepositoryTest
{
    @Test
    public void test_shouldSuccessfullyAddStudent() throws ValidatorException {
        StudentValidator vs=new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(vs);
        Student student = new Student(
                "testId",
                "testName",
                3112,
                "testMail",
                "testTeacher"
        );
        assertTrue(studentRepo.findAll().spliterator().getExactSizeIfKnown()==0);
        studentRepo.save(student);
        assertTrue(studentRepo.findAll().spliterator().getExactSizeIfKnown()==1);
    }

    @Test
    public void test_shouldSuccessfullyAddAssignment() throws ValidatorException {
        TemaLabValidator vs=new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(vs);
        TemaLab temaLab = new TemaLab(
                1,
                "temaLab",
                6,
                4
        );
        assertTrue(temaLabRepo.findAll().spliterator().getExactSizeIfKnown()==0);
        temaLabRepo.save(temaLab);
        assertTrue(temaLabRepo.findAll().spliterator().getExactSizeIfKnown()==1);
    }

    @Test
    public void test_shouldThrowWhenGivenIncorrectGroupId(){
        StudentValidator vs=new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(vs);
        Student student = new Student(
                "testId",
                "testName",
                -5,
                "testMail",
                "testTeacher"
        );
        assertTrue(studentRepo.findAll().spliterator().getExactSizeIfKnown()==0);
        try{
            studentRepo.save(student);
            assertTrue(false);
        }catch(ValidatorException ex){
            assertTrue(ex.getMessage().contains("Grupa invalid"));
        }
    }
    @Test
    public void test_shouldThrowWhenGivenNullStudent(){
        StudentValidator vs=new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(vs);
        Student student = null;
        try{
            studentRepo.save(student);
            assertTrue(false);
        }catch(IllegalArgumentException ex){
            assertTrue(ex.getMessage().contains("Entity can not be null!\n"));
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_ShouldThrowWhenGivenNullAssignment() {
        TemaLabValidator vs=new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(vs);
        TemaLab temaLab = null;

        try{
            temaLabRepo.save(temaLab);
            assertTrue(false);
        }catch(IllegalArgumentException ex){
            assertTrue(ex.getMessage().contains("Entity can not be null!\n"));
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }
}
