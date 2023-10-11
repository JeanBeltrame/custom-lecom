package com.lecom.testes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecom.workflow.robo.RBOpenWebServices;
import com.lecom.workflow.robo.face.GenericWSVO;
import com.lecom.workflow.vo.IntegracaoVO;

import br.com.lecom.atos.servicos.annotation.Execution;
import br.com.lecom.atos.servicos.annotation.IntegrationModule;
import br.com.lecom.atos.servicos.annotation.Version;



@IntegrationModule("abreprocesso")
@Version({1,0,7})
public class AbreProcesso {
    
    private static final Logger logger = LoggerFactory.getLogger(AbreProcesso.class);
    @Execution
    public String executa (IntegracaoVO integracaoVO) {
        String retorno = "0|sucesso";
        logger.info("teste");
        try{
            
            StringBuilder valores = new StringBuilder();
            valores.append("TESTE5|");
            valores.append("Sim");

            
            GenericWSVO wsvo = new GenericWSVO();
            wsvo.setCodForm(Integer.parseInt("1"));
            wsvo.setLoginUsuario("adm");
            wsvo.setSenhaUsuario("adm");
            wsvo.setValores(valores.toString());

             retorno = RBOpenWebServices.getInstance().executeWebServices(wsvo, RBOpenWebServices.ABRE_PROCESSO);
        logger.debug(retorno);
	    }catch(Exception e ){
	        
	        logger.info(e.toString());
	    }
	    return retorno;
	}
}