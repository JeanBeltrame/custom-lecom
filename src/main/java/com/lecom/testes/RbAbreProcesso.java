package com.lecom.testes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecom.workflow.robo.RBOpenWebServices;
import com.lecom.workflow.robo.face.GenericWSVO;
import com.lecom.workflow.vo.IntegracaoVO;

import br.com.lecom.atos.servicos.annotation.Execution;
import br.com.lecom.atos.servicos.annotation.RobotModule;
import br.com.lecom.atos.servicos.annotation.Version;



@RobotModule("RbAbreProcesso")
@Version({1,0,0})
public class RbAbreProcesso {
    
    private static final Logger logger = LoggerFactory.getLogger(RbAbreProcesso.class);
    @Execution
    public void executa () {
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
             System.out.println(retorno);
        logger.debug(retorno);
	    }catch(Exception e ){
	        
	        logger.info(e.toString());
	    }
//	    return retorno;
	}
}