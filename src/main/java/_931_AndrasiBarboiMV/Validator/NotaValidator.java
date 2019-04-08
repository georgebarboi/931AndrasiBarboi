package Validator;


import _931_AndrasiBarboiMV.Domain.Nota;
import _931_AndrasiBarboiMV.Exceptions.ValidatorException;
import _931_AndrasiBarboiMV.Validator.IValidator;

public class NotaValidator implements IValidator<Nota> {

    public void validate(Nota n) throws ValidatorException {
        String errors="";
        if(n.getId()<=0){
            errors+="Id invalid\n";
        }
        if(n.getStudentId().equals("") || n.getStudentId()==null){
            errors+="Id student invalid\n";
        }
        if(n.getTemaLabId()<=0){
            errors+="Id tema invalid\n";
        }
        if(n.getValoare()<=0 || n.getValoare()>10 ){
            errors+="Valoare invalida\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}