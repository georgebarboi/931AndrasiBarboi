package _931_AndrasiBarboiMV.Service.TxtFileService;


import _931_AndrasiBarboiMV.Domain.Nota;
import _931_AndrasiBarboiMV.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer,Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
