package _931_AndrasiBarboiMV.Repository.MemoryRepository;

import _931_AndrasiBarboiMV.Domain.TemaLab;
import _931_AndrasiBarboiMV.Repository.MemoryRepository.AbstractCrudRepo;
import _931_AndrasiBarboiMV.Validator.IValidator;

public class TemaLabRepo extends AbstractCrudRepo<Integer,TemaLab> {

    public TemaLabRepo(IValidator<TemaLab> v){

        super(v);
    }

    public void prelungireTermenLimita(TemaLab t,int saptCurenta){
        if(saptCurenta<=t.getSaptammanaPredarii()){
            t.setTermenLimita(t.getTermenLimita()+1);
            update(t);
        }
    }

}