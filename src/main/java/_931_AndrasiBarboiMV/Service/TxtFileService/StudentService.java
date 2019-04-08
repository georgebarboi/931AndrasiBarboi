package _931_AndrasiBarboiMV.Service.TxtFileService;


import _931_AndrasiBarboiMV.Domain.Student;
import _931_AndrasiBarboiMV.Repository.TxtFileRepository.StudentFileRepo;

public class StudentService extends AbstractService<String,Student> {
    //StudentFileRepo stdRepo;
    public StudentService(StudentFileRepo stdRepo){
        super(stdRepo);
    }
    /*
    @Override
    public Student extractEntity(String[] info){
        return new Student("","",2,"","");
    }
    */
}


