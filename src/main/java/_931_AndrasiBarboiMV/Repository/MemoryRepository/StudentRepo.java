package _931_AndrasiBarboiMV.Repository.MemoryRepository;


import _931_AndrasiBarboiMV.Domain.Student;
import _931_AndrasiBarboiMV.Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}