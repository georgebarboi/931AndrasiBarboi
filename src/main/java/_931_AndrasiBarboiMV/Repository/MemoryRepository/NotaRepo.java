package Repository.MemoryRepository;


import _931_AndrasiBarboiMV.Domain.Nota;
import _931_AndrasiBarboiMV.Repository.MemoryRepository.AbstractCrudRepo;
import _931_AndrasiBarboiMV.Validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota> {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}