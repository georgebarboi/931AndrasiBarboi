package _931_AndrasiBarboiMV.Service.TxtFileService;


import _931_AndrasiBarboiMV.Domain.HasId;
import _931_AndrasiBarboiMV.Exceptions.ValidatorException;
import _931_AndrasiBarboiMV.Repository.TxtFileRepository.AbstractFileRepository;
import _931_AndrasiBarboiMV.Validator.IValidator;

public abstract  class AbstractService <ID,E extends HasId<ID>> {
    private IValidator<E> v;
    private AbstractFileRepository<ID,E> repo;
    public AbstractService(AbstractFileRepository repo){
        this.repo=repo;
    }
    //@Override
    public void add(String[] params) throws ValidatorException {
        E entity = repo.extractEntity(params);
        repo.save(entity);
    }
    public void del(ID id) throws ValidatorException {
        //E entity = repo.extractEntity(params);
        repo.delete(id);
    }
    public void upd(String[] params) throws ValidatorException {
        E entity = repo.extractEntity(params);
        repo.update(entity);
    }
    public Iterable<E> getAll(){
        return repo.findAll();
    }
    public E getById(ID id){
        return repo.findOne(id);
    }
    public int size(){
        return (int) repo.size();
    }

}

