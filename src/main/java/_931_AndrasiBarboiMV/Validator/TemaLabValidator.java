package _931_AndrasiBarboiMV.Validator;


import _931_AndrasiBarboiMV.Domain.TemaLab;
import _931_AndrasiBarboiMV.Exceptions.ValidatorException;

public class TemaLabValidator implements IValidator<TemaLab> {

    public void validate(TemaLab t) throws ValidatorException {
        if(t.getId()== null || t.getId().equals("s")){
            throw new ValidatorException("Nr tema invalid\n");
        }else if(t.getDescriere()== null || t.getDescriere().equals("")) {
            throw new ValidatorException("Descriere tema invalida\n");
        }else if(t.getSaptammanaPredarii()<=0 || t.getSaptammanaPredarii()>14) {
            throw new ValidatorException("Sapatamana predarii invalida\n");
        }else if(t.getTermenLimita()<=0 || t.getTermenLimita()>14) {
            throw new ValidatorException("Termen limita invalid\n");
        }
    }
}
