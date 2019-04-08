package _931_AndrasiBarboiMV;
import _931_AndrasiBarboiMV.Exceptions.ValidatorException;
import _931_AndrasiBarboiMV.Repository.XMLFileRepository.NotaXMLRepo;
import _931_AndrasiBarboiMV.Repository.XMLFileRepository.StudentXMLRepo;
import _931_AndrasiBarboiMV.Repository.XMLFileRepository.TemaLabXMLRepo;
import _931_AndrasiBarboiMV.Service.XMLFileService.NotaXMLService;
import _931_AndrasiBarboiMV.Service.XMLFileService.StudentXMLService;
import _931_AndrasiBarboiMV.Service.XMLFileService.TemaLabXMLService;
import _931_AndrasiBarboiMV.UI.ui;
import _931_AndrasiBarboiMV.Validator.StudentValidator;
import _931_AndrasiBarboiMV.Validator.TemaLabValidator;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        Validator.NotaValidator vn=new Validator.NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();

    }
}