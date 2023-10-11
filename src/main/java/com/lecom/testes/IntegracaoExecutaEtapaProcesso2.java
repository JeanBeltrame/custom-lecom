package com.lecom.testes;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecom.workflow.robo.RBOpenWebServices;
import com.lecom.workflow.robo.face.GenericWSVO;
import com.lecom.workflow.vo.IntegracaoVO;

import br.com.lecom.atos.servicos.annotation.Execution;
import br.com.lecom.atos.servicos.annotation.IntegrationModule;
import br.com.lecom.atos.servicos.annotation.Version;



@IntegrationModule("IntegracaoExecutaEtapaProcesso2")
@Version({1,0,7})
public class IntegracaoExecutaEtapaProcesso2 {
    
    private static final Logger logger = LoggerFactory.getLogger(IntegracaoExecutaEtapaProcesso2.class);
    @Execution
    public String executa (IntegracaoVO integracaoVO) {
        String retorno = "0|sucesso";
        logger.info("teste");
        try{
            
            StringBuilder valores = new StringBuilder();
            valores.append("REPETICAO_01|");
            valores.append("TESTE");

            GenericWSVO wsvo = new GenericWSVO();
            Map mapCamposFormulario = integracaoVO.getMapCamposFormulario();
            System.out.println("$TXT_COD_FORM" + mapCamposFormulario.get("$TXT_COD_FORM").toString());
            
            wsvo.setCodForm(Integer.parseInt(mapCamposFormulario.get("$TXT_COD_FORM").toString()));
            wsvo.setCodProcesso(Integer.parseInt(mapCamposFormulario.get("$TXT_COD_PROCESSO").toString()));
            wsvo.setCodEtapa(Integer.parseInt(mapCamposFormulario.get("$TXT_COD_ETAPA").toString()));
            wsvo.setCodCiclo(Integer.parseInt(mapCamposFormulario.get("$TXT_COD_CICLO").toString()));
            
            wsvo.setLoginUsuario("adm");
            wsvo.setSenhaUsuario("adm");
            wsvo.setValores(valores.toString());
            
            wsvo.setAcao("P");

             retorno = RBOpenWebServices.getInstance().executeWebServices(wsvo, RBOpenWebServices.EXECUTA_ETAPA_PROCESSO);
        logger.debug(retorno);
	    }catch(Exception e ){
	        
	        logger.info(e.toString());
	    }
	    return retorno;
	}
}