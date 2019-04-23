package _931_AndrasiBarboiMV;

import _931_AndrasiBarboiMV.Domain.Nota;
import _931_AndrasiBarboiMV.Domain.Student;
import _931_AndrasiBarboiMV.Domain.TemaLab;
import _931_AndrasiBarboiMV.Exceptions.ValidatorException;
import _931_AndrasiBarboiMV.Repository.MemoryRepository.StudentRepo;
import _931_AndrasiBarboiMV.Repository.MemoryRepository.TemaLabRepo;
import _931_AndrasiBarboiMV.Validator.StudentValidator;
import _931_AndrasiBarboiMV.Validator.TemaLabValidator;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

public class TopDownTest {
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
    public void test_shouldSuccessfullyAddStudentAndAssignment() throws ValidatorException {
        StudentValidator vs=new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(vs);
        Student student = new Student(
                "testId",
                "testName",
                3112,
                "testMail",
                "testTeacher"
        );
        TemaLabValidator vs2=new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(vs2);
        TemaLab temaLab = new TemaLab(
                1,
                "temaLab",
                6,
                4
        );

        assertTrue(studentRepo.findAll().spliterator().getExactSizeIfKnown()==0
        && temaLabRepo.findAll().spliterator().getExactSizeIfKnown()==0);
        studentRepo.save(student);
        temaLabRepo.save(temaLab);
        assertTrue(studentRepo.findAll().spliterator().getExactSizeIfKnown()==1
                && temaLabRepo.findAll().spliterator().getExactSizeIfKnown()==1);
    }

    @Test
    public void test_shouldSuccessfullyAddStudentAndAssignmentAndGrade() throws ValidatorException {
        StudentValidator vs=new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(vs);
        Student student = new Student(
                "testId",
                "testName",
                3112,
                "testMail",
                "testTeacher"
        );
        TemaLabValidator vs2=new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(vs2);
        TemaLab temaLab = new TemaLab(
                1,
                "temaLab",
                6,
                4
        );

        Validator.NotaValidator vs3=new Validator.NotaValidator();
        Repository.MemoryRepository.NotaRepo notaRepo = new Repository.MemoryRepository.NotaRepo(vs3);
        Nota grade = new Nota(
                1,
                "testId",
                1,
                9.0,
                LocalDateTime.now()
        );

        assertTrue(studentRepo.findAll().spliterator().getExactSizeIfKnown()==0
                && temaLabRepo.findAll().spliterator().getExactSizeIfKnown()==0
        && notaRepo.findAll().spliterator().getExactSizeIfKnown()==0);
        studentRepo.save(student);
        temaLabRepo.save(temaLab);
        notaRepo.save(grade);
        assertTrue(studentRepo.findAll().spliterator().getExactSizeIfKnown()==1
                && temaLabRepo.findAll().spliterator().getExactSizeIfKnown()==1
                && notaRepo.findAll().spliterator().getExactSizeIfKnown()==1);
    }
}
