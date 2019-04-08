package _931_AndrasiBarboiMV.Validator;


import _931_AndrasiBarboiMV.Exceptions.ValidatorException;

public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}