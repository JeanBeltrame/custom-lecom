package com.lecom.testes;

import java.io.BufferedReader;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecom.workflow.robo.RBOpenWebServices;
import com.lecom.workflow.robo.face.GenericWSVO;
import com.lecom.workflow.vo.IntegracaoVO;

import br.com.lecom.atos.servicos.annotation.Execution;
import br.com.lecom.atos.servicos.annotation.RobotModule;
import br.com.lecom.atos.servicos.annotation.Version;



@RobotModule("RBExecutaEtapaProcesso")
@Version({1,0,0})
public class RBExecutaEtapaProcesso {
    
    private static final Logger logger = LoggerFactory.getLogger(RBExecutaEtapaProcesso.class);
    @Execution
    public void executa () {
        String retorno = "0|sucesso";
        logger.info("teste");
        try{
        	BufferedReader buffRead = new BufferedReader(new FileReader("C:\\temp_parametrizacao\\lecom_mysql\\bpm\\AprovaProcesso.properties"));
    		String codProcesso = buffRead.readLine();
//    		while (true) {
//    			if (linha != null) {
//    				System.out.println(linha);
//
//    			} else
//    				break;
//    			linha = buffRead.readLine();
//    		}
    		buffRead.close();
            StringBuilder valores = new StringBuilder();
            valores.append("TESTE5|");
            valores.append("Sim");

            GenericWSVO wsvo = new GenericWSVO();
//            Map mapCamposFormulario = integracaoVO.getMapCamposFormulario();
//            System.out.println("$TXT_COD_FORM" + mapCamposFormulario.get("$TXT_COD_FORM").toString());
            
            wsvo.setCodForm(Integer.parseInt("2"));
            wsvo.setCodProcesso(Integer.parseInt(codProcesso));
            wsvo.setCodEtapa(Integer.parseInt("1"));
            wsvo.setCodCiclo(Integer.parseInt("1"));
            
            wsvo.setLoginUsuario("adm");
            wsvo.setSenhaUsuario("adm");
            wsvo.setValores(valores.toString());
            
            wsvo.setAcao("P");

             retorno = RBOpenWebServices.getInstance().executeWebServices(wsvo, RBOpenWebServices.EXECUTA_ETAPA_PROCESSO);
             
             System.out.println(retorno);
        logger.debug(retorno);
	    }catch(Exception e ){
	        
	        logger.info(e.toString());
	    }
//	    return retorno;
	}
}