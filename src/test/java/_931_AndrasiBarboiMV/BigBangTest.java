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

public class BigBangTest {
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
    public void test_SuccessfullyAddGrade() throws ValidatorException {
        Validator.NotaValidator vs=new Validator.NotaValidator();
        Repository.MemoryRepository.NotaRepo notaRepo = new Repository.MemoryRepository.NotaRepo(vs);
        Nota grade = new Nota(
                1,
                "testStudentName",
                6,
                9.0,
                LocalDateTime.now()
        );
        assertTrue(notaRepo.findAll().spliterator().getExactSizeIfKnown()==0);
        notaRepo.save(grade);
        assertTrue(notaRepo.findAll().spliterator().getExactSizeIfKnown()==1);
    }

    @Test
    public void test_SAGSuccessfullyAdd() throws ValidatorException {
        TemaLabValidator vt = new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(vt);
        TemaLab temaLab = new TemaLab(
                1,
                "temaLab",
                6,
                4
        );
        assertTrue(temaLabRepo.findAll().spliterator().getExactSizeIfKnown() == 0);
        temaLabRepo.save(temaLab);
        assertTrue(temaLabRepo.findAll().spliterator().getExactSizeIfKnown() == 1);


        StudentValidator vs = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(vs);
        Student student = new Student(
                "testId",
                "testName",
                3112,
                "testMail",
                "testTeacher"
        );
        assertTrue(studentRepo.findAll().spliterator().getExactSizeIfKnown() == 0);
        studentRepo.save(student);
        assertTrue(studentRepo.findAll().spliterator().getExactSizeIfKnown() == 1);

        Validator.NotaValidator vg = new Validator.NotaValidator();
        Repository.MemoryRepository.NotaRepo notaRepo = new Repository.MemoryRepository.NotaRepo(vg);
        Nota grade = new Nota(
                1,
                "testStudentName",
                6,
                9.0,
                LocalDateTime.now()
        );
        assertTrue(notaRepo.findAll().spliterator().getExactSizeIfKnown() == 0);
        notaRepo.save(grade);
        assertTrue(notaRepo.findAll().spliterator().getExactSizeIfKnown() == 1);
    }

}
